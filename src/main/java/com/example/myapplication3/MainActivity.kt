package com.example.myapplication3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import androidx.appcompat.resources.Compatibility.Api21Impl.inflate
import com.example.myapplication3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.weightpicker.minValue=30
        binding.weightpicker.maxValue=150

        binding.heightpicker.minValue=100
        binding.heightpicker.maxValue=250

        binding.weightpicker.setOnValueChangedListener { _,_,_ ->
            calculateBMI()
        }
        binding.heightpicker.setOnValueChangedListener { _,_,_ ->
            calculateBMI()
        }

    }
    private fun calculateBMI()
    {
        val height =binding.heightpicker.value
        val doubleHeight =height.toDouble()/100

        val weight =binding.weightpicker.value
        val bmi =weight.toDouble()/(doubleHeight * doubleHeight)

        binding.resultsTV.text = String.format("Your BMI is : %.2f",bmi)
        binding.healthyTV.text = String.format("considered: %s",healthyMessage(bmi))

    }

    private fun healthyMessage(bmi:Double):String
    {
        if(bmi<18.5)
            return "Underweight"
        if(bmi <25)
            return "Healthy"
        if(bmi <30)
            return "Overweight"
        return "Obese"
    }
}
