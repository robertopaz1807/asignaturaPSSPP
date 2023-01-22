package com.miteris.corrutinasii

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.random.Random

// Problema 10 - Corrutinas: Flujos (Flow)

data class Persona(val nombre: String, val edad: Int)


fun retornarPersona(): Flow<Persona> = flow {
    val lista = listOf(
        Persona("diego", 53),
        Persona("juan", 33),
        Persona("ana", 33)
    )
    for (elemento in lista) {
        delay(1000)
        emit(elemento)
    }
}

fun main() = runBlocking {
    async { retornarPersona().collect { persona -> println("${persona.nombre} ${persona.edad}") }}
    println("Fin de la main")
}


/*fun main() = runBlocking {
    retornarPersona().collect { persona -> println("${persona.nombre} ${persona.edad}") }
}*/


/*// Problema 9 - Llamadas concurrentes.
fun main(args: Array<String>) = runBlocking {
    val tiempo1 = System.currentTimeMillis()
    val corrutina1=async { dato1() }
    val corrutina2=async { dato2() }
    println(corrutina1.await()+corrutina2.await())
    val tiempo2 = System.currentTimeMillis()
    println("Tiempo total ${(tiempo2-tiempo1)/1000} seg")
}

suspend fun dato1(): Int {
    delay(3000)
    return 3
}

suspend fun dato2(): Int {
    delay(3000)
    return 3
}*/


/*// Problema 8 - Suspensión (ejecución secuencial)
fun main(args: Array<String>) = runBlocking {
    val d1=dato1()
    println("Fin de la primera función de suspensión")
    val d2=dato2()
    println("Fin de la segundo función de suspensión")
    print(d1+d2)
}

suspend fun dato1(): Int {
    delay(3000)
    return 3
}

suspend fun dato2(): Int {
    delay(3000)
    return 3
}*/


/*// Problema 7 - coroutineScope
fun main(args: Array<String>) = runBlocking {
    Tareas(1)
    Tareas(2)
    println("Fin de todas las tareas")
}

suspend fun Tareas(nro:Int) = coroutineScope {
    launch {
        delay(2000)
        println("Tarea $nro parte A")
    }
    launch {
        delay(1000)
        println("Tarea $nro parte B")
    }
    println("Esperando finalizar las dos tareas $nro")
}*/


/*// Problema 6 - Dos corrutinas en serie
fun main(args: Array<String>) = runBlocking {
    val corrutina1=launch {
        delay(3000)
        println("Pasaron 3 segundos")
    }
    corrutina1.join()
    val corrutina2=launch {
        delay(3000)
        println("Paso otros 3 segundos")
    }
    corrutina2.join()
    println("Finalizado")
}*/


// Problema 5  - 100.000 Corrutinas
/*fun main(args: Array<String>) = runBlocking {
    for(x in 1..100000)
        launch {
            delay(1000)
            print(".")
        }
}*/


// Problema 4 - runBloging
/*fun main(args: Array<String>) = runBlocking {
    launch {
        espera()
    }
    println("Iniciando")
}

suspend fun espera() {
    delay(1000)
    println("Paso un segundo")
}*/


/*// Problema 3 - Adivinar número Aleatorio
fun main(args: Array<String>) {
    val adivina = Random.nextInt(1, 100)
    var inicio = 1
    var fin = 100
    GlobalScope.launch {
        var pienso:Int
        do {
            pienso = Random.nextInt(inicio, fin)
            println(pienso)
            if (pienso == adivina)
                println("Gane con el $pienso")
            else
                if (pienso < adivina) {
                    println("El numero es mayor")
                    inicio = pienso
                } else {
                    println("El numero es menor")
                    fin = pienso
                }
            delay(500)
        } while (pienso != adivina)
    }
    readLine() //detenemos el hilo principal del programa
}*/


/*// Problema 2 - Lanzar dos Launch()
fun main(args: Array<String>) {
    GlobalScope.launch {
        for(x in 1..10) {
            print("$x ")
            delay(1000)
        }
    }
    GlobalScope.launch {
        for(x in 11..20) {
            print("$x ")
            delay(1000)
        }
    }
    println("Se bloquea el hilo principal del programa al llamar a readLine")
    readLine()
}*/


/*
// Problema 1 -Rutinas con Launch()
fun main(args: Array<String>) {
    GlobalScope.launch {
        for(x in 1..10) {
            print("$x -")
            delay(1000)
        }
    }
    println("Se bloquea el hilo principal del programa al llamar a readLine")
    readLine()
}*/
