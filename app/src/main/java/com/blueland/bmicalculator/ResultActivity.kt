package com.blueland.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.blueland.bmicalculator.databinding.ActivityResultBinding
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {

    private val binding: ActivityResultBinding by lazy { DataBindingUtil.setContentView(this, R.layout.activity_result) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        val bmi = weight / (height / 100.0).pow(2.0)
        val bmiText = when {
            bmi >= 35.0 -> "고도 비만"
            bmi >= 30.0 -> "중등도 비만"
            bmi >= 25.0 -> "경도 비만"
            bmi >= 23.0 -> "과체중"
            bmi >= 18.5 -> "정상체중"
            else -> "저체중"
        }

        binding.apply {
            tvBmi.text = bmi.toString()
            tvBmiText.text = bmiText
        }
    }
}