package com.example.mvvmcalculator.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmcalculator.R
import com.example.mvvmcalculator.databinding.ActivityMainBinding
import com.example.mvvmcalculator.viewmodel.CalculatorViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var calculatorViewModel: CalculatorViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calculatorViewModel = ViewModelProvider(this).get(CalculatorViewModel::class.java)

        binding.calculatebutton.setOnClickListener {
            val num1 = binding.editTextNum1.text.toString().toIntOrNull() ?:0
            val num2 =binding.editTextNum2.text.toString().toIntOrNull() ?:0

            val result = calculatorViewModel.calculateSum(num1,num2)

            binding.resultTitle.text="${result.sum}"
        }
    }
}