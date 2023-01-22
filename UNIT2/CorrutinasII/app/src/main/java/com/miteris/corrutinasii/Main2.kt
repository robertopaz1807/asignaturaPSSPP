package com.miteris.corrutinasii

import kotlinx.coroutines.*


fun main(args: Array<String>) = runBlocking {

    val corrutina1= launch {
        for(x in 1..10) {
            print("$x ")
            delay(1000)
        }
    }

    val corrutina2 = launch {
        for(x in 11..20) {
            print("$x ")
            delay(1000)
        }
    }

}











