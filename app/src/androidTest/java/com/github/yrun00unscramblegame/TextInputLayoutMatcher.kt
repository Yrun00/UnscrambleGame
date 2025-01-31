package com.github.yrun00unscramblegame

import android.view.View
import androidx.test.espresso.matcher.BoundedMatcher
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.Description

class TextInputLayoutMatcher(private val expectedState: InputLayouState) :
    BoundedMatcher<View, TextInputLayout>(TextInputLayout::class.java) {

    override fun describeTo(description: Description) {
        description.appendText("state doesn't match with expected $expectedState")
    }

    override fun matchesSafely(item: TextInputLayout): Boolean {
        return item.isErrorEnabled
    }
}