package com.miteris.encriptarydesencriptar

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.miteris.encriptarydesencriptar.databinding.ActivityMainBinding
import com.miteris.encriptarydesencriptar.CifradoAES
import java.security.MessageDigest
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    lateinit var cipherTextNew : ByteArray
    lateinit var cipherText : ByteArray
    var myAes = CifradoAES

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEncrypt.setOnClickListener {
            cipherTextNew = myAes.encrypt(binding.edtPlainText.text.toString(),
                                          binding.edtKeyEncrypt.text.toString())
            binding.txtShowCipherValue.text = cipherTextNew.toString()
        }

        binding.btnDecrypt.setOnClickListener {

            cipherText  = myAes.decrypt(cipherTextNew, binding.edtKeyDecrypt.text.toString())
            buildString(cipherText, "decrypt")
        //    binding.txtShowOrginalWord.text = cipherTextNew.toString()
        }
    }

    private fun buildString(text: ByteArray, status: String): String{
        val sb = StringBuilder()
        for (char in text) {
            sb.append(char.toInt().toChar())
        }
        binding.txtShowOrginalWord.text = sb.toString()
        return sb.toString()
    }


/*    private fun encrypt(context: Context, strToEncrypt: String, keyToEncrypt: String): ByteArray {
        val plainText = strToEncrypt.toByteArray(Charsets.UTF_8)
        val key = generateKey(keyToEncrypt)
        val cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
        cipher.init(Cipher.ENCRYPT_MODE, key)
        val cipherText = cipher.doFinal(plainText)
        ivValue = cipher.iv
        return cipherText
    }

    private fun decrypt(context: Context, dataToDecrypt: ByteArray, keyToDecrypt: String): ByteArray {
        val cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
        val key = generateKey(keyToDecrypt)
        cipher.init(Cipher.DECRYPT_MODE, key, IvParameterSpec(ivValue))
        val cipherText = cipher.doFinal(dataToDecrypt)
        buildString(cipherText, "decrypt")
        return cipherText
    }

    private fun generateKey(password: String): SecretKeySpec {
        val digest: MessageDigest = MessageDigest.getInstance("SHA-256")
        val bytes = password.toByteArray()
        digest.update(bytes, 0, bytes.size)
        val key = digest.digest()
        val secretKeySpec = SecretKeySpec(key, "AES")
        return secretKeySpec
    }

    private fun buildString(text: ByteArray, status: String): String{
        val sb = StringBuilder()
        for (char in text) {
            sb.append(char.toInt().toChar())
        }
        binding.txtShowOrginalWord.text = sb.toString()
        return sb.toString()
    }*/
}
