package com.example.tamagotchiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.Scanner

// Define the Tamagotchi class
class Tamagotchi(var name: String) {
    //declare
    private var hunger = 0
    private var happiness = 100
    private var energy = 100
    private var isAlive = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun feed() {
        hunger -= 10
        if (hunger < 0) hunger = 0
        happiness += 5
        if (happiness > 100) happiness = 100
        energy -= 5
        if (energy < 0) energy = 0
        checkStatus()
    }

    fun play() {
        happiness += 10
        if (happiness > 100) happiness = 10
        energy -= 10
        if (energy < 0) energy = 0
        checkStatus()
    }

    fun clean() {
         energy += 20
         if (energy > 100) energy = 100
         hunger += 10
         if (hunger > 100) hunger = 100
         checkStatus()
    }

    private fun checkStatus() {
        if (hunger >= 100 || happiness <= 0 || energy <= 0) {
            isAlive = false
            println("$name has passed away. Game over!")
        }
    }

    fun isAlive: Boolean {
        return isAlive
    }

    fun displayStatus() {
        println("Name: $name")
        println("Hunger: $hunger")
        println("Happiness: $happiness")
        println("Energy: $energy")
    }
}
fun main() {
    val scanner = Scanner(System.'in')
    println("Welcome to Tamagotchi Pet App!")
    print("Enter your pet's name: ")
    val petName = scanner.nextLine()
    val pet = Tamagotchi(petName)

    while (pet.isAlive()) {
        println("\nWhat would you  like to with ${pet.name}")
        println("1. Feed")
        println("2. Play")
        println("3. Clean")
        println("4. Quit")
        println("Enter your choice: ")
        when (scanner.nextInt()) {
            1 -> pet.feed()
            2 -> pet.play()
            3 -> pet.clean()
            4 -> {
                println("Goodbye!")
                return
            }
            else -> println("Invalid choice. Please try again.")
        }
        pet.displayStatus()
    }
}