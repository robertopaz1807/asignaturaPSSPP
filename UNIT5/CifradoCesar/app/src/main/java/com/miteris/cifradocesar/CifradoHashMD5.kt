package com.miteris.cifradocesar

import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class CifradoHashMD5 {

    companion object {
        @Throws(NoSuchAlgorithmException::class)
        @JvmStatic
        fun main(args: Array<String>) {
            val password = "https://www.miteris.com/"
            val md = MessageDigest.getInstance("MD5")
            val hashInBytes = md.digest(
                password.toByteArray(StandardCharsets.UTF_8)
            )
            val sb = StringBuilder()
            for (b in hashInBytes) {
                sb.append(String.format("%02x", b)).toString()
            }
            println("Entrada: $password")
            println("Salida: $sb")
        }
    }
}