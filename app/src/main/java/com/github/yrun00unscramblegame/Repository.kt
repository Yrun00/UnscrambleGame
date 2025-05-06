package com.github.yrun00unscramblegame

interface Repository {

    fun wordForUnscramble(): String

    fun check(userInput: String): Boolean

    fun next()

    class Base() : Repository {
        override fun wordForUnscramble(): String {
            TODO("Not yet implemented")
        }

        override fun check(userInput: String): Boolean {
            TODO("Not yet implemented")
        }

        override fun next() {
            TODO("Not yet implemented")
        }
    }
}
