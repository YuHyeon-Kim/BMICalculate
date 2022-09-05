package com.blueland.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.blueland.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { DataBindingUtil.setContentView(this, R.layout.activity_main) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.apply {
            btnSubmit.setOnClickListener {

                val height = etHeight.text.toString()
                val weight = etWeight.text.toString()

                if (height.isEmpty() || weight.isEmpty()) {
                    Toast.makeText(this@MainActivity, "빈 값을 입력해주세요.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val intent = Intent(this@MainActivity, ResultActivity::class.java)
                intent.putExtra("height", height.toInt())
                intent.putExtra("weight", weight.toInt())
                startActivity(intent)
            }
        }
    }
}