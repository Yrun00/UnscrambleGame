package com.github.yrun00unscramblegame

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith



@RunWith(AndroidJUnit4::class)
class ScenarioTest {

@get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    private lateinit var gamePage: GamePage

    @Before
    fun setup() {
        gamePage = GamePage(word = "Apple".reversed())
    }
    
    /**
     * Test case HappyPath
     */
    @Test
    fun scenarioTestHappyPath() {

        gamePage.checkNoEnteredWordState()

        gamePage.inputInsufficientWord()
        gamePage.checkIncorrectNumberOfCharactersInputedState()

        gamePage.inputSufficientAndCorrectWord()

        gamePage.checkCorrectNumberOfCharactersInputedState()

        gamePage.clickCheck()
        gamePage.checkRightAnswerState()

        gamePage.clickNext()

        gamePage = GamePage(
            word = "Banana".reversed()
        )
        gamePage.checkNoEnteredWordState()
    }

    @Test
    fun scenarioTestComplexPath() {
        gamePage.checkNoEnteredWordState()

        gamePage.clickSkip()
        gamePage = GamePage(
            word = "Banana".reversed()
        )
        gamePage.checkNoEnteredWordState()

        gamePage.inputInsufficientWord()
        gamePage.checkIncorrectNumberOfCharactersInputedState()

        gamePage.clickSkip()
        gamePage = GamePage(
            word = "Carrot".reversed()
        )
        gamePage.checkNoEnteredWordState()

        gamePage.inputInsufficientWord()
        gamePage.checkIncorrectNumberOfCharactersInputedState()

        gamePage.inputSufficientAndIncorrectWord()
        gamePage.checkCorrectNumberOfCharactersInputedState()

        gamePage.clickSkip()
        gamePage = GamePage(
            word = "Penguin".reversed()
        )
        gamePage.checkNoEnteredWordState()

        gamePage.inputSufficientAndIncorrectWord()
        gamePage.checkIncorrectNumberOfCharactersInputedState()

        gamePage.inputSufficientAndIncorrectWord()
        gamePage.checkCorrectNumberOfCharactersInputedState()

        gamePage.deleteCharacter()
        gamePage.checkIncorrectNumberOfCharactersInputedState()

        gamePage.clickSkip()
        gamePage = GamePage(
            word = "Elephant".reversed()
        )
        gamePage.checkNoEnteredWordState()

        gamePage.inputInsufficientWord()
        gamePage.checkIncorrectNumberOfCharactersInputedState()

        gamePage.inputSufficientAndIncorrectWord()
        gamePage.checkCorrectNumberOfCharactersInputedState()

        gamePage.deleteCharacter()
        gamePage.checkIncorrectNumberOfCharactersInputedState()

        gamePage.inputSufficientAndIncorrectWord()
        gamePage.checkCorrectNumberOfCharactersInputedState()

        gamePage.clickCheck()
        gamePage.checkErrorState()

        gamePage.clickSkip()
        gamePage = GamePage(
            word = "Flower".reversed()
        )
        gamePage.checkNoEnteredWordState()

        gamePage.inputInsufficientWord()
        gamePage.checkIncorrectNumberOfCharactersInputedState()

        gamePage.inputSufficientAndIncorrectWord()
        gamePage.checkCorrectNumberOfCharactersInputedState()

        gamePage.clickCheck()
        gamePage.checkErrorState()

        gamePage.deleteCharacter()
        gamePage.checkIncorrectNumberOfCharactersInputedState()

        gamePage.inputSufficientAndCorrectWord()
        gamePage.checkCorrectNumberOfCharactersInputedState()

        gamePage.clickSkip()
        gamePage = GamePage(
            word = "Garden".reversed()
        )
        gamePage.checkNoEnteredWordState()

        gamePage.inputInsufficientWord()
        gamePage.checkIncorrectNumberOfCharactersInputedState()

        gamePage.inputSufficientAndIncorrectWord()
        gamePage.checkCorrectNumberOfCharactersInputedState()

        gamePage.clickCheck()
        gamePage.checkErrorState()

        gamePage.deleteCharacter()
        gamePage.checkIncorrectNumberOfCharactersInputedState()

        gamePage.inputSufficientAndIncorrectWord()
        gamePage.checkCorrectNumberOfCharactersInputedState()

        gamePage.clickCheck()
        gamePage.checkErrorState()

        gamePage.deleteCharacter()
        gamePage.checkIncorrectNumberOfCharactersInputedState()

        gamePage.inputSufficientAndCorrectWord()
        gamePage.checkCorrectNumberOfCharactersInputedState()

        gamePage.clickCheck()
        gamePage.checkRightAnswerState()

        gamePage.clickNext()
        gamePage = GamePage(
            word = "House".reversed()
        )
        gamePage.checkNoEnteredWordState()
    }
}

/*
Apple
Banana
Carrot
Elephant
Flower
Garden
House
Ice
Juice
Kite
Lemon
Monkey
Nes
Orange
Penguin
Queen
Rabbit
Sun
Tree
Umbrella
Violet
Water
Xylophone
Yellow
Zebra
Airplane
Ball
Cat
Door
 */