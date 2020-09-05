package com.example.libkotlin

class MyClass(name: String, age: Int) {
    val a = "MyClass's name is $name".also(::println)
    val b = "MyClass's name is $name".also {
        println(it)
    }
}

/**
 * For practice method of kotlin.
 * Let method of main outside MyClass.
 */
fun main() {
    println("It's great!")
    val myClass = MyClass("Tom", 15)
    println("myClass=$myClass")
//    myClass.b
}
