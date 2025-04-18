package com.github.yrun00unscramblegame

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModel
import com.github.yrun00unscramblegame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rootLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = MainViewModel()

        binding.inputEditText.addTextChangedListener {
            val uiState: MainUiState = viewModel.textChanged()
            uiState.update(binding = binding)
        }

        binding.checkButton.setOnClickListener {
            val uiState: MainUiState = ViewModel.check
            uiState.update(binding = binding)
        }

        binding.nextButton.setOnClickListener {
            val uiState: MainUiState = ViewModel.next
            uiState.update(binding = binding)
        }

        binding.skipButton.setOnClickListener {
            val uiState: MainUiState = ViewModel.skip
            uiState.update(binding = binding)
        }
    }
}