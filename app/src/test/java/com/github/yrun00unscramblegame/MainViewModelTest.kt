package com.github.yrun00unscramblegame

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        viewModel = MainViewModel(repository = FakeRepository())
    }

    @Test
    fun caseNumber1() {
        var actual: MainUiState = viewModel.init()
        var expected: MainUiState = MainUiState.noEnteredWordState(wordForUnscramble = "people")

        assertEquals(expected, actual)

        actual = viewModel.handleUserInput("h")
        expected = MainUiState.IncorrectNumberOfCharactersInputedState(
            wordForUnscramble = "people",
            answer = "h"
        )

        assertEquals(expected, actual)

        actual = viewModel.handleUserInput("people")
        expected = MainUiState.CorrectNumberOfCharactersInputedState(
            wordForUnscramble = "people",
            answer = "people"
        )

        assertEquals(expected, actual)

        actual = viewModel.check()
        expected = MainUiState.RightAnswerState(wordForUnscramble = "people", answer = "people")

        assertEquals(expected, actual)

        actual = viewModel.clickNext()
        expected = MainUiState.noEnteredWordState(wordForUnscramble = "history")

        assertEquals(expected, actual)
    }

    @Test
    fun caseNumber2() {

        var actual: MainUiState = viewModel.init()
        var expected: MainUiState = MainUiState.noEnteredWordState(wordForUnscramble = "people")

        assertEquals(expected, actual)

        actual = viewModel.skip()
        expected = MainUiState.noEnteredWordState(wordForUnscramble = "history")

        assertEquals(expected, actual)

        actual = viewModel.handleUserInput("q")
        expected = MainUiState.InCorrectNumberOfCharactersInputedState(
            wordForUnscramble = "history",
            answer = "q"
        )

        assertEquals(expected, actual)

        actual = viewModel.skip()
        expected = MainUiState.noEnteredWordState(wordForUnscramble = "way")

        assertEquals(expected, actual)

        actual = viewModel.handleUserInput("w")
        expected = MainUiState.InCorrectNumberOfCharactersInputedState(
            wordForUnscramble = "way",
            answer = "w"
        )

        assertEquals(expected, actual)

        actual = viewModel.handleUserInput("www")
        expected = MainUiState.CorrectNumberOfCharactersInputedState(
            wordForUnscramble = "way",
            answer = "www"
        )

        assertEquals(expected, actual)

        actual = viewModel.skip()
        expected = MainUiState.noEnteredWordState(wordForUnscramble = "art")

        assertEquals(expected, actual)

        actual = viewModel.handleUserInput("a")
        expected = MainUiState.InCorrectNumberOfCharactersInputedState(
            wordForUnscramble = "art",
            answer = "a"
        )

        assertEquals(expected, actual)

        actual = viewModel.handleUserInput("aaa")
        expected = MainUiState.CorrectNumberOfCharactersInputedState(
            wordForUnscramble = "art",
            answer = "aaa"
        )

        assertEquals(expected, actual)

        actual = viewModel.handleUserInput("ar")
        expected = MainUiState.InCorrectNumberOfCharactersInputedState(
            wordForUnscramble = "art",
            answer = "aa"
        )

        assertEquals(expected, actual)

        actual = viewModel.skip()
        expected = MainUiState.noEnteredWordState(wordForUnscramble = "world")

        assertEquals(expected, actual)

        actual = viewModel.handleUserInput("w")
        expected = MainUiState.InCorrectNumberOfCharactersInputedState(
            wordForUnscramble = "world",
            answer = "w"
        )

        assertEquals(expected, actual)

        actual = viewModel.handleUserInput("wwwww")
        expected = MainUiState.CorrectNumberOfCharactersInputedState(
            wordForUnscramble = "world",
            answer = "wwwww"
        )

        assertEquals(expected, actual)

        actual = viewModel.check()
        expected = MainUiState.ErrorState(wordForUnscramble = "world", answer = "wwwww")

        assertEquals(expected, actual)

        actual = viewModel.skip()
        expected = MainUiState.noEnteredWordState(wordForUnscramble = "map")

        assertEquals(expected, actual)

        actual = viewModel.handleUserInput("m")
        expected = MainUiState.InCorrectNumberOfCharactersInputedState(
            wordForUnscramble = "map",
            answer = "m"
        )

        assertEquals(expected, actual)

        actual = viewModel.handleUserInput("mmm")
        expected = MainUiState.CorrectNumberOfCharactersInputedState(
            wordForUnscramble = "map",
            answer = "mmm"
        )

        assertEquals(expected, actual)

        actual = viewModel.check()
        expected = MainUiState.ErrorState(wordForUnscramble = "map", answer = "mmm")

        assertEquals(expected, actual)

        actual = viewModel.handleUserInput("mm")
        expected = MainUiState.InCorrectNumberOfCharactersInputedState(
            wordForUnscramble = "map",
            answer = "mm"
        )

        assertEquals(expected, actual)

        actual = viewModel.handleUserInput("mmm")
        expected = MainUiState.CorrectNumberOfCharactersInputedState(
            wordForUnscramble = "map",
            answer = "mmm"
        )

        assertEquals(expected, actual)

        actual = viewModel.skip()
        expected = MainUiState.noEnteredWordState(wordForUnscramble = "two")

        assertEquals(expected, actual)

        actual = viewModel.handleUserInput("t")
        expected = MainUiState.InCorrectNumberOfCharactersInputedState(
            wordForUnscramble = "two",
            answer = "t"
        )

        assertEquals(expected, actual)

        actual = viewModel.handleUserInput("ttt")
        expected = MainUiState.CorrectNumberOfCharactersInputedState(
            wordForUnscramble = "two",
            answer = "ttt"
        )

        assertEquals(expected, actual)

        actual = viewModel.check()
        expected = MainUiState.ErrorState(
            wordForUnscramble = "two",
            answer = "ttt"
        )

        assertEquals(expected, actual)

        actual = viewModel.handleUserInput("tt")
        expected = MainUiState.InCorrectNumberOfCharactersInputedState(
            wordForUnscramble = "two",
            answer = "tt"
        )

        assertEquals(expected, actual)

        actual = viewModel.handleUserInput("ttt")
        expected = MainUiState.CorrectNumberOfCharactersInputedState(
            wordForUnscramble = "two",
            answer = "ttt"
        )

        assertEquals(expected, actual)

        actual = viewModel.check()
        expected = MainUiState.ErrorState(
            wordForUnscramble = "two",
            answer = "ttt"
        )

        assertEquals(expected, actual)


        actual = viewModel.handleUserInput("tt")
        expected = MainUiState.InCorrectNumberOfCharactersInputedState(
            wordForUnscramble = "two",
            answer = "tt"
        )

        assertEquals(expected, actual)

        actual = viewModel.handleUserInput("ttt")
        expected = MainUiState.CorrectNumberOfCharactersInputedState(
            wordForUnscramble = "two",
            answer = "ttt"
        )

        assertEquals(expected, actual)

        actual = viewModel.check()
        expected = MainUiState.ErrorState(
            wordForUnscramble = "two",
            answer = "ttt"
        )

        assertEquals(expected, actual)

        actual = viewModel.handleUserInput("tt")
        expected = MainUiState.InCorrectNumberOfCharactersInputedState(
            wordForUnscramble = "two",
            answer = "tt"
        )

        assertEquals(expected, actual)

        actual = viewModel.handleUserInput("two")
        expected = MainUiState.CorrectNumberOfCharactersInputedState(
            wordForUnscramble = "two",
            answer = "two"
        )

        assertEquals(expected, actual)

        actual = viewModel.check()
        expected = MainUiState.RightAnswerState(
            wordForUnscramble = "two",
            answer = "two"
        )

        assertEquals(expected, actual)

        actual = viewModel.next()
        expected = MainUiState.noEnteredWordState(wordForUnscramble = "family")

        assertEquals(expected, actual)
    }
}


//List of words
//people
//history
//way
//art
//world
//map
//two
//family
//government
//health
//system
//computer
//meat
//year
//thanks
//music
//person
//reading
//method
//data
//food
//understanding
//theory
//law
//bird
//literature
//problem
//software
//control