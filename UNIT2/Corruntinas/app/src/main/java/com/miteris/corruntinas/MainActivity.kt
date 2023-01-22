package com.miteris.corruntinas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rutinas1()
    //    rutinas2()
    //    rutinas3()
    //    rutinas4()
    //    rutinas5()
    //    rutinas6()


    }


    fun rutinas1() {
        // 1. Inicio
        println("¡Go!")

        // 2. Buscar palabras en el background
        GlobalScope.launch {
            (1..5).forEach {
                delay(300)
                println("¡Palabra $it encontrada!")
            }
        }

        // 3. Iniciar temporizador en foreground
        for (i in 10 downTo 1) {
            println("${i}s")
            Thread.sleep(100)
        }

        // 4. Tiempo fuera
        println("Se terminó el tiempo")

        // 5. Tiempo extra
        println("Tiempo extra")
        runBlocking {
            delay(600)
        }

    }

    fun rutinas2() = runBlocking<Unit> {
        // 1. Inicio
        println("¡Go!")

        // 2. Buscar palabras en el background
        GlobalScope.launch {
            (1..5).forEach {
                delay(300)
                println("¡Palabra $it encontrada!")
            }
        }

        // 3. Iniciar temporizador en foreground
        for (i in 10 downTo 1) {
            println("${i}s")
            delay(100)
        }

        // 4. Tiempo fuera
        println("Se terminó el tiempo")

        delay(600)
    }

    fun rutinas3() = runBlocking {
        // 1. Inicio
        println("¡Go!")

        // 2. Buscar palabras en el background
        val job = GlobalScope.launch {
            (1..5).forEach {
                delay(300)
                println("¡Palabra $it encontrada!")
            }
        }

        // 3. Iniciar temporizador en foreground
        for (i in 10 downTo 1) {
            println("${i}s")
            delay(100)
        }

        // 4. Tiempo fuera
        println("Se terminó el tiempo")

        job.join()
    }


    fun rutinas4() = runBlocking {
        // 1. Inicio
        println("¡Go!")

        // 2. Buscar palabras en el background
        launch {
            (1..5).forEach {
                delay(300)
                println("¡Palabra $it encontrada!")
            }
        }

        // 3. Iniciar temporizador en foreground
        for (i in 10 downTo 1) {
            println("${i}s")
            delay(100)
        }

        // 4. Tiempo fuera
        println("Se terminó el tiempo")
    }

    fun rutinas5() = runBlocking {

        val totalTime = async {
            val t0 = System.currentTimeMillis()
            (1..5).forEach {
                delay(300)
                println("¡Palabra $it encontrada!")
            }
            System.currentTimeMillis() - t0
        }
        println("Esto cuando se imprime??")
        println("Tiempo empleado: ${totalTime.await()}")
        println(" Y esto. Cuando se imprime??")
    }

    fun rutinas6() = runBlocking {

        coroutineScope {
            val totalTime = async {
                val t0 = System.currentTimeMillis()
                (1..5).forEach {
                    delay(300)
                    println("¡Palabra $it encontrada!")
                }
                System.currentTimeMillis() - t0
            }.await()

            println("Tiempo empleado: ${totalTime}")
        }
    }


}