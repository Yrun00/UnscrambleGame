package com.github.yrun00unscramblegame

import com.github.yrun00unscramblegame.databinding.ActivityMainBinding

interface MainUiState {

    fun update(binding: ActivityMainBinding) {
        //TODO
    }

    data class CorrectNumberOfCharactersInputedState(
        val wordForUnscramble: String,
        val answer: String
    ) :
        MainUiState {
    }

    data class RightAnswerState(val wordForUnscramble: String, val answer: String) : MainUiState {

    }

    data class ErrorState(val wordForUnscramble: String, val answer: String) : MainUiState {

    }

    data class IncorrectNumberOfCharactersInputedState(
        val wordForUnscramble: String,
        val answer: String
    ) :
        MainUiState {

    }


    data class NoEnteredWordState(val wordForUnscramble: String) : MainUiState {

    }


}
