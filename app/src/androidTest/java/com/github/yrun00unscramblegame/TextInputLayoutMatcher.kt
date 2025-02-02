package com.github.yrun00unscramblegame

import android.view.View
import androidx.test.espresso.matcher.BoundedMatcher
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.Description

class TextInputLayoutErrorMatcher(private val expectedEnabled: Boolean) :
    BoundedMatcher<View, TextInputLayout>(TextInputLayout::class.java) {


    override fun describeTo(description: Description) {
        description.appendText("error enabled doesn't match with expected $expectedEnabled")
    }

    override fun matchesSafely(item: TextInputLayout): Boolean {
        return item.isErrorEnabled == expectedEnabled
    }
}