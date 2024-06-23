package com.example.kotlinkalkulator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinkalkulator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addButton.setOnClickListener { calculateLogic(1) }
        binding.subtractButton.setOnClickListener { calculateLogic(2) }
        binding.multiplyButton.setOnClickListener { calculateLogic(3) }
        binding.divideButton.setOnClickListener { calculateLogic(4) }
    }

    fun calculateLogic(operation: Int) {
        val firstNumberText = binding.firstNumber.text.toString()
        val secondNumberText = binding.secondNumber.text.toString()

        if (firstNumberText.isEmpty() || secondNumberText.isEmpty()) {
            Toast.makeText(this, "Wypełnij oba pola liczbą!", Toast.LENGTH_SHORT).show()
            return
        }

        val firstNumber = firstNumberText.toFloatOrNull()
        val secondNumber = secondNumberText.toFloatOrNull()

        if (firstNumber != null && secondNumber != null) {
            val result = when (operation) {
                1 -> firstNumber + secondNumber
                2 -> firstNumber - secondNumber
                3 -> firstNumber * secondNumber
                4 -> if (secondNumber != 0f) {
                    firstNumber / secondNumber
                } else {
                    Toast.makeText(this, "Nie można dzielić przez zero!", Toast.LENGTH_SHORT).show()
                    return
                }
                else -> 0f
            }
            binding.resultText.text = result.toString()
        } else {
            Toast.makeText(this, "Wpisz TYLKO cyfry", Toast.LENGTH_SHORT).show()
        }
    }
}
