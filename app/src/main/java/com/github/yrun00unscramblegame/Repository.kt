package com.github.yrun00unscramblegame

interface Repository {

    fun wordForUnscramble(): String

    fun check(userInput: String): Boolean

    fun next()

    class Base() : Repository {
        override fun wordForUnscramble(): String {
            return listOfWords[index]
        }

        override fun check(userInput: String): Boolean {
            return listOfWords[index].equals(userInput, ignoreCase = true)
        }

        override fun next() {
            index++
        }

        private var index = 0

        private val listOfWords = listOf(
            "people",
            "history",
            "way",
            "art",
            "world",
            "map",
            "two",
            "family"
        )

    }


}
