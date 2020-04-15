package com.dotinfiny.attendanceapp

class SimpleSpice {
    val nameOfSpice: String = "Curry"
    val levelOfSpice: String = "mild"

    var heat : Int
        get() = 5
        set(mild) { when(mild) { 5 -> "spiciness" else -> "no thing" }}
}

class Aquarium {

    var width: Int = 20
    var height: Int = 40
    var length: Int = 100

    var volume: Int
        get() = width * height * length / 100
        set(value) { height = (value * 1000) /  (width * length)}

}