package com.github.yrun00unscramblegame

import android.view.View
import android.widget.Button
import com.github.yrun00unscramblegame.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

interface MainUiState {

    fun update(binding: ActivityMainBinding)

    abstract class Abstract(
        private val wordForUnscramble: String,
        private val inputUiState: InputUiState,
        private val checkButtonUiState: CheckButtonUiState,
        private val nextButtonVisibility: Int = View.INVISIBLE,
        private val skipButtonVisibility: Int = View.VISIBLE,
    ) : MainUiState {

        override fun update(binding: ActivityMainBinding) {
            with(binding) {
                shuffledWordTextView.text = wordForUnscramble
                inputUiState.update(binding.inputLayout, binding.inputEditText)
                checkButtonUiState.update(checkButton)
                nextButton.visibility = nextButtonVisibility
                skipButton.visibility = skipButtonVisibility
            }
        }

    }

    data class NoEnteredWordState(private val wordForUnscramble: String) : Abstract(
        wordForUnscramble,
        InputUiState.NoEnteredWordState,
        CheckButtonUiState.Disabled,

        )

    data class CorrectNumberOfCharactersInputedState(
        private val wordForUnscramble: String,
        private val answer: String
    ) : Abstract(
        wordForUnscramble,
        InputUiState.WordEnteredState(answer),
        CheckButtonUiState.Enabled,
    )

    data class RightAnswerState(private val wordForUnscramble: String, private val answer: String) :
        Abstract(
            wordForUnscramble,
            InputUiState.WordEnteredState(answer),
            CheckButtonUiState.Invisible,
            nextButtonVisibility = View.VISIBLE,
            skipButtonVisibility = View.INVISIBLE
        )

    data class ErrorState(val wordForUnscramble: String, val answer: String) : Abstract(
        wordForUnscramble,
        InputUiState.ErrorState(answer),
        CheckButtonUiState.Disabled,

        )

    data class IncorrectNumberOfCharactersInputedState(
        private val wordForUnscramble: String,
        private val answer: String
    ) : Abstract(
        wordForUnscramble,
        InputUiState.WordEnteredState(answer),
        CheckButtonUiState.Disabled
    )


}

interface InputUiState {

    fun update(inputLayout: TextInputLayout, inputEditText: TextInputEditText)

    abstract class Abstract(
        private val errorIsVisible: Boolean,
        private val congratulationIsVisible: Boolean,
        private val clearText: Boolean = false,
    ) : InputUiState {
        override fun update(inputLayout: TextInputLayout, inputEditText: TextInputEditText) {
            inputLayout.isErrorEnabled = errorIsVisible
            if (errorIsVisible) {
                inputLayout.error = inputLayout.context.getString(R.string.wrong_word)
                inputLayout.isHintEnabled = false

            }
            inputLayout.isHintEnabled = congratulationIsVisible
            inputLayout.hintTextColor = inputLayout.context.getColorStateList(R.color.green)

            if (clearText) {
                inputEditText.setText("")
            }
        }
    }

    object NoEnteredWordState : Abstract(
        errorIsVisible = false,
        congratulationIsVisible = false,
        clearText = true
    )

    data class WordEnteredState(private val enteredWord: String) : Abstract(
        errorIsVisible = false,
        congratulationIsVisible = false,
    )

    data class ErrorState(private val enteredWord: String) : Abstract(
        errorIsVisible = true,
        congratulationIsVisible = false
    )


}

interface CheckButtonUiState {

    fun update(checkButton: Button)

    abstract class Abstract(
        private val visible: Int,
        private val enabled: Boolean
    ) : CheckButtonUiState {
        override fun update(checkButton: Button) = with(checkButton) {
            visibility = visible
            isEnabled = enabled
        }
    }

    object Disabled : Abstract(visible = View.VISIBLE, false) {

    }

    object Enabled : Abstract(visible = View.VISIBLE, true) {

    }

    object Invisible : Abstract(visible = View.GONE, false)
}
