package com.github.yrun00unscramblegame

interface Repository {

    fun wordForUnscramble(): String

    fun check(userInput: String): Boolean

    fun next()

    class Base() : Repository {
        override fun wordForUnscramble(): String {
            return listOfWords[index].reversed()
        }

        override fun check(userInput: String): Boolean {
            return listOfWords[index].equals(userInput, ignoreCase = true)
        }

        override fun next() {
            index++
        }

        private var index = 0

        private val listOfWords = listOf(
            "Apple",
            "Banana",
            "Carrot",
            "Elephant",
            "Flower",
            "Garden",
            "House",
            "Ice",
            "Juice",
            "Kite",
            "Lemon",
            "Monkey",
            "Nes",
            "Orange",
            "Penguin",
            "Queen",
            "Rabbit",
            "Sun",
            "Tree",
            "Umbrella",
            "Violet",
            "Water",
            "Xylophone",
            "Yellow",
            "Zebra",
            "Airplane",
            "Ball",
            "Cat",
            "Door"
        )

    }


}
