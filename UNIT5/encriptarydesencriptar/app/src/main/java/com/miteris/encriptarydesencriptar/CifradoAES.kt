package com.miteris.encriptarydesencriptar

import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import java.security.MessageDigest
import javax.crypto.spec.IvParameterSpec

class CifradoAES {

    companion object {

        lateinit var ivValue: ByteArray

        fun encrypt(strToEncrypt: String, keyToEncrypt: String): ByteArray {
            val plainText = strToEncrypt.toByteArray(Charsets.UTF_8)
            val key = generateKey(keyToEncrypt)
            val cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
            cipher.init(Cipher.ENCRYPT_MODE, key)
            val cipherText = cipher.doFinal(plainText)
            ivValue = cipher.iv
            return cipherText
        }

        fun decrypt(dataToDecrypt: ByteArray, keyToDecrypt: String): ByteArray {
            val cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
            val key = generateKey(keyToDecrypt)
            cipher.init(Cipher.DECRYPT_MODE, key, IvParameterSpec(ivValue))
            val cipherText = cipher.doFinal(dataToDecrypt)
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


    }
}