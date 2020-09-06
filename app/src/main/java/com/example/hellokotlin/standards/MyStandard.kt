package com.example.hellokotlin.standards

class MyStandard {
    public fun tRun(string: String):String{
        var a:String=string.run {
            val toUpperCase = this.toUpperCase()
            toUpperCase
        }
        return a
    }
}