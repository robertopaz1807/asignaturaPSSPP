package com.miteris.cifradocesar

class CifradoCesar {

    companion object {
        val ALFABETO: String = "abcdefghijklmnopqrstuvwxyz"

        /**
         * determina si un texto dado pertenece al abcedario
         * @param texto
         * @reREST APIs are a type of Web Service APIsturn boolean
         */
        fun esLetra(texto: String): Boolean {
            return texto.matches("[a-z]+".toRegex())
        }

        /**
         * Cifra mensaje utilizando el Codigo Cesar
         * @param mensaje
         * @param desplazamiento
         * @return String Texto cifrado
         */
        fun encriptar(mensaje: String, desplazamiento: Int): String {
            var textoCesar: String = ""
            for (i in 0..mensaje.length - 1) {
                if (esLetra(mensaje.lowercase()[i].toString())) {
                    //Obtiene posicion del caracter "i" del mensaje en el alfabeto
                    var posicionActual: Int = ALFABETO.indexOf(mensaje.lowercase()[i])
                    //Obtiene nueva posicion
                    var nuevaPosicion: Int = ((desplazamiento + posicionActual) % 26)
                    //Obtiene nuevo caracter y concatena en mensaje
                    textoCesar += ALFABETO.get(nuevaPosicion)
                } else {//ignora y concatena caracter original en mensaje
                    textoCesar += mensaje.lowercase()[i].toString()
                }
            }
            return textoCesar
        }

        /**
         * Descifra mensaje utilizando el Codigo Cesar
         * @param mensajeCifrado
         * @param desplazamiento
         * @return String mensaje descifrado
         */
        fun desencriptar(mensajeCifrado: String, desplazamiento: Int): String {
            var mensaje: String = ""
            for (i in 0..mensajeCifrado.length - 1) {
                if (esLetra(mensajeCifrado.lowercase()[i].toString())) {
                    var posicionActual: Int =
                                      ALFABETO.indexOf(mensajeCifrado.lowercase()[i])
                    var nuevaPosicion: Int = ((posicionActual - desplazamiento) % 26)
                    if (nuevaPosicion < 0) {
                        nuevaPosicion = ALFABETO.length + nuevaPosicion
                    }
                    mensaje += ALFABETO.get(nuevaPosicion)
                } else {//ignora y concatena en mensaje
                    mensaje += mensajeCifrado.lowercase()[i].toString()
                }
            }
            return mensaje
        }
        @JvmStatic
        fun main(args: Array<String>) {
            var mensaje: String = "En un lugar de La Mancha, de cuyo nombre no quiero " +
                    "acordarme, no ha mucho tiempo que vivía un hidalgo de los de lanza " +
                    "y astillero, adarga antigua, rocín flaco y galgo corredor."
            println("Original : $mensaje")
            var cifrado: String = encriptar(mensaje, 3)
            println("Cifrado : $cifrado")
            println("Descifrado: " + desencriptar(cifrado, 3))
        }
    }
}
