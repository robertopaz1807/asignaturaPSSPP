package com.miteris.corruntinas

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

// Problema 1 -Rutinas con Launch()
fun main(args: Array<String>) {

 //   rutinas1()  // Rutinas con Launch
 //   rutinas2()  // Rutinas con runBlocking con
 //   rutinas4()  // Rutinas con runBlocking
 //   rutinas5()  // Rutinas con runBlocking
      rutinas6()  // Rutinas con runBlocking
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

        println("Esto cuando se imprime??")
        println("Tiempo empleado: ${totalTime}")
        println("Esto cuando se imprimeeeeeeeeee??")
    }

    println("FINNNNNNNNNNN")
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




fun rutinas2() = runBlocking {
    // 1. Inicio
    println("¡Go!")

    // 2. Buscar palabras en el background lanzando la corutina
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

    println("FFFFIIIIINNNNNNN")

}











fun rutinas1() {
    // 1. Inicio
    println("¡Go!")

    // 2. Buscar palabras en el background lanzando la corutina
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
