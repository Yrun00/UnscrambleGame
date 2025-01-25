package com.github.yrun00unscramblegame

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ScenarioTest {

    /**
     * Test case HappyPath
     */
    @Test
    fun scenarioTestHappyPath() {
        var gamePage = GamePage(
            word = "hello"
        )
        gamePage.checkNoEnteredWordState()

        gamePage.inputInsufficientWord(text = "word")
        gamePage.checkIncorrectNumberOfCharactersInputedState()

        gamePage.inputSufficientAndCorrectWord(text = "hello")

        gamePage.checkCorrectNumberOfCharactersInputedState()

        gamePage.clickCheck()
        gamePage.checkRightAnswerState()

        gamePage.clickNext()

        gamePage = GamePage(
            word = "happy"
        )
        gamePage.checkNoEnteredWordState()
    }
}