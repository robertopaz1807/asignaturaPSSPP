package com.miteris.corrutinasii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Problema1()

    }

    private fun Problema1() {
        GlobalScope.launch {
            for(x in 1..10) {
                print("$x -")
                delay(1000)
            }
        }
        println("Se bloquea el hilo principal del programa al llamar a readLine")
        readLine()

    }
}