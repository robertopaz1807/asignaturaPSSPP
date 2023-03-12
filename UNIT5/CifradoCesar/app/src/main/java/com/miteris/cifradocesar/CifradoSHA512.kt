package com.miteris.cifradocesar

import java.security.NoSuchAlgorithmException
import java.math.BigInteger
import java.security.MessageDigest

class CifradoSHA512 {

    companion object {
        @Throws(NoSuchAlgorithmException::class)
        @JvmStatic
        fun main(args: Array<String>) {
            println("HashCode Generated by SHA-512")
            val s1 = "https://www.miteris.com/"
            println("Entrada: $s1")
            println("Salida: ${encryptStringSHA512(s1)}")
        }

        fun encryptStringSHA512(input: String): String {
            return try {
                val md = MessageDigest.getInstance("SHA-512")
                val messageDigest = md.digest(input.toByteArray())
                val no = BigInteger(1, messageDigest)
                var hashtext = no.toString(16)
                while (hashtext.length < 32) {
                    hashtext = "0$hashtext"
                }
                hashtext
            } catch (e: NoSuchAlgorithmException) {
                throw RuntimeException(e)
            }
        }
    }
}