package com.github.yrun00unscramblegame

import android.view.View
import android.widget.LinearLayout
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import org.hamcrest.Matcher

class GamePage(word: String) {

    private val containerIdMatcher: Matcher<View> = withParent(withId(R.id.rootLayout))

    private val classTypeMatcher: Matcher<View> =
        withParent(isAssignableFrom(LinearLayout::class.java))

    private val shuffledWordUi = ShuffledWordUi(
        text = word,
        containerIdMatcher = containerIdMatcher,
        containerClassTypeMatcher = classTypeMatcher
    )

    private val inputTextUi = InputTextUi(
        text = word,
        containerIdMatcher = containerIdMatcher,
        containerClassTypeMatcher = classTypeMatcher
    )

    private val checkUi = ButtonUi(
        id = R.id.checkButton,
        text = R.string.check,
        colorHex = "FF9500",
        containerIdMatcher = containerIdMatcher,
        containerClassTypeMatcher = classTypeMatcher
    )
    private val nextUi = ButtonUi(
        id = R.id.nextButton,
        text = R.string.next,
        colorHex = "34C759",
        containerIdMatcher = containerIdMatcher,
        containerClassTypeMatcher = classTypeMatcher
    )
    private val skipUi = ButtonUi(
        id = R.id.skipButton,
        text = R.string.skip,
        colorHex = "007AFF",
        containerIdMatcher = containerIdMatcher,
        containerClassTypeMatcher = classTypeMatcher
    )


    fun clickCheck() {
        checkUi.click()
    }


    fun clickNext() {
        nextUi.click()
    }

    fun clickSkip() {
        skipUi.click()
    }

    fun checkNoEnteredWordState() {
        shuffledWordUi.assertTextVisible()
        inputTextUi.assertStateEmpty()
        checkUi.assertDisabled()
        nextUi.assertNotVisible()
        skipUi.assertEnabled()
    }

    fun checkIncorrectNumberOfCharactersInputedState() {
        shuffledWordUi.assertTextVisible()
        inputTextUi.assertStateNotEmpty()
        checkUi.assertDisabled()
        nextUi.assertNotVisible()
        skipUi.assertEnabled()
    }

    fun checkCorrectNumberOfCharactersInputedState() {
        shuffledWordUi.assertTextVisible()
        inputTextUi.assertStateNotEmpty()
        checkUi.assertEnabled()
        nextUi.assertNotVisible()
        skipUi.assertEnabled()
    }

    fun checkErrorState() {
        shuffledWordUi.assertTextVisible()
        inputTextUi.assertStateErrorAndNotEmpty()
        checkUi.assertDisabled()
        nextUi.assertNotVisible()
        skipUi.assertEnabled()
    }

    fun checkRightAnswerState() {
        shuffledWordUi.assertTextVisible()
        inputTextUi.assertStateRight()
        checkUi.assertNotVisible()
        nextUi.assertEnabled()
        skipUi.assertDisabled()
    }


    fun inputSufficientAndIncorrectWord() {
        inputTextUi.inputSufficientAndIncorrect()
    }


    fun inputInsufficientWord() {
        inputTextUi.inputInsufficient()
    }

    fun inputSufficientAndCorrectWord() {
        inputTextUi.inputCorrect()
    }

    fun deleteCharacter() {
        inputTextUi.deleteCharacter()
    }

}
