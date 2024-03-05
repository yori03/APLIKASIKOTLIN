package com.pnm.ac.aplikasikotlin

class ConstructorA {}

class ConstructorB (x: Int) {}

class ConstructorC(val x: Int) {}

fun main() {
    val A = ConstructorA()
    val B = ConstructorB(5)
    val C = ConstructorC(10)

    println(A)
    println(B)
    // println(ConstructorB)
    println(ConstructorB::class.java)
}