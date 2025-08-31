package com.github.yrun00unscramblegame

import android.graphics.Color
import android.view.View
import androidx.test.espresso.matcher.BoundedMatcher
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.Description


class TextInputLayoutHelperTextMatcher(private val textColor: Int, private val helperText: String) :
    BoundedMatcher<View, TextInputLayout>(TextInputLayout::class.java) {

    constructor(textColor: String, helperText: String) : this(
        Color.parseColor(textColor),
        helperText = helperText
    )

    override fun describeTo(description: Description) {
        description.appendText("helper text doesn't match with expected $helperText or $textColor")
    }

    override fun matchesSafely(item: TextInputLayout): Boolean {
        return item.helperText == helperText && item.helperTextCurrentTextColor == textColor
    }
}
