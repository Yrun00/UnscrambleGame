package com.github.yrun00unscramblegame

class MainViewModel(val repository: Repository) {

    private lateinit var word: String
    private lateinit var userInput: String

    fun init(): MainUiState {
        word = repository.wordForUnscramble()
        return MainUiState.NoEnteredWordState(word)
    }

    fun handleUserInput(userInput: String): MainUiState {
        this.userInput = userInput
        return if (this.userInput.length == word.length) {
            MainUiState.CorrectNumberOfCharactersInputedState(word, this.userInput)
        } else MainUiState.IncorrectNumberOfCharactersInputedState(word, this.userInput)

    }

    fun check(): MainUiState {
        return if (repository.check(userInput)) {
            MainUiState.RightAnswerState(word, userInput)
        } else MainUiState.ErrorState(word, userInput)
    }

    fun next(): MainUiState {
        repository.next()
        return init()
    }

    fun skip(): MainUiState {
        return next()
    }
}
