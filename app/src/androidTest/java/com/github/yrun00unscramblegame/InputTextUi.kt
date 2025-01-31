package com.github.yrun00unscramblegame

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher

class InputTextUi(
    text: String,
    containerIdMatcher: Matcher<View>,
    containerClassTypeMatcher: Matcher<View>
) {

    private val layoutInteraction: ViewInteraction = onView(
        allOf(
            containerIdMatcher,
            containerClassTypeMatcher,
            withId(R.id.inputLayout),
            isAssignableFrom(TextInputLayout::class.java)
        )
    )

    private val inputInteraction: ViewInteraction = onView(
        allOf(

            containerIdMatcher,
            containerClassTypeMatcher,
            withId(R.id.inputEditText),
            isAssignableFrom(TextInputEditText::class.java),
            withParent(withId(R.id.inputLayout))

        )
    )


    fun assertStateEmpty() {
        TODO("Not yet implemented")
    }

    fun assertStateNotEmpty() {
        TODO("Not yet implemented")
    }

    fun assertStateErrorAndNotEmpty() {
        TODO("Not yet implemented")
    }

    fun assertStateRight() {
        TODO("Not yet implemented")
    }

    fun inputSufficientAndIncorrect() {
        TODO("Not yet implemented")
    }

    fun inputInsufficient() {
        TODO("Not yet implemented")
    }

    fun inputCorrect() {
        TODO("Not yet implemented")
    }

    fun deleteCharacter() {
        TODO("Not yet implemented")
    }

}
