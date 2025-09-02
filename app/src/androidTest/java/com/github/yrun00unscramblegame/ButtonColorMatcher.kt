package com.github.yrun00unscramblegame

import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import androidx.core.graphics.toColorInt
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description

class ButtonColorMatcher(private val color: Int) :
    BoundedMatcher<View, Button>(AppCompatButton::class.java) {

    constructor(colorString: String) : this(colorString.toColorInt())

    override fun describeTo(description: Description) {
        description.appendText("color for button doesn't match expected $color")
    }

    override fun matchesSafely(item: Button): Boolean {
        return (item.background as ColorDrawable).color == color
    }

}