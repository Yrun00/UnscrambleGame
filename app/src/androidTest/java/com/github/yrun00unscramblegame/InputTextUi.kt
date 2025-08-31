package com.github.yrun00unscramblegame

import android.view.KeyEvent
import android.view.View
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.pressKey
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Matcher

private const val s = "write unscrambled word"

class InputTextUi(
    private val text: String,
    containerIdMatcher: Matcher<View>,
    containerClassTypeMatcher: Matcher<View>
) {
    private val layoutInteraction: ViewInteraction = onView(
        allOf(
            containerIdMatcher,
            containerClassTypeMatcher,
            withId(R.id.inputLayout),
            isAssignableFrom(TextInputLayout::class.java),
        )
    )

    private val inputInteraction: ViewInteraction = onView(
        allOf(
            containerIdMatcher,
            containerClassTypeMatcher,
            withId(R.id.inputEditText),
            withParent(isAssignableFrom(TextInputEditText::class.java)),
            withParent(withId(R.id.inputLayout)),
        )
    )

    private var deleteCounter: Int = 0


    fun assertStateEmpty() {
        inputInteraction.check(matches(withText("")))
        layoutInteraction.check(
            matches(
                TextInputLayoutHelperTextMatcher(
                    textColor = R.color.black,
                    helperText = R.string.write_unscrambled_word.toString()
                )
            )
        )
        layoutInteraction.check(
            matches(
                TextInputLayoutErrorMatcher(false)
            )
        )


    }

    fun assertStateNotEmpty() {
        inputInteraction.check(matches(not(withText(""))))
        layoutInteraction.check(
            matches(
                TextInputLayoutHelperTextMatcher(
                    textColor = R.color.black,
                    helperText = R.string.write_unscrambled_word.toString()
                )
            )
        )
        layoutInteraction.check(
            matches(
                TextInputLayoutErrorMatcher(false)
            )
        )
    }

    fun assertStateErrorAndNotEmpty() {
        inputInteraction.check(matches(not(withText(""))))
        layoutInteraction.check(
            matches(
                TextInputLayoutErrorMatcher(true)
            )
        )

    }

    fun assertStateRight() {
        inputInteraction.check(matches(withText(text)))
        layoutInteraction.check(
            matches(
                TextInputLayoutErrorMatcher(false)
            )
        )
        layoutInteraction.check(
            matches(
                TextInputLayoutHelperTextMatcher(
                    textColor = "#34C759",
                    helperText = R.string.right_word.toString()
                )
            )
        )
    }

    fun inputSufficientAndIncorrect() {
        inputInteraction.perform(replaceText(text.reversed()))
    }

    fun inputInsufficient() {
        inputInteraction.perform(replaceText(text.dropLast(1)))
    }

    fun inputCorrect() {
        inputInteraction.perform(replaceText(text))

    }

    fun deleteCharacter() {
        inputInteraction.perform(click())
            .perform(pressKey(KeyEvent.KEYCODE_DEL))
        closeSoftKeyboard()
    }

}
