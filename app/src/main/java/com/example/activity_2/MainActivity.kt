package com.example.activity_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.IntegerRes
import kotlin.math.pow

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editWeight = findViewById(R.id.editTextWeight) as EditText
        val editHeight = findViewById(R.id.editTextHeight) as EditText

        val viewBMI = findViewById(R.id.textViewBMI) as TextView

        val buttonForCalculate = findViewById(R.id.buttonCalculate) as Button
        val buttonForReset = findViewById(R.id.buttonReset) as Button

        buttonForCalculate.setOnClickListener(View.OnClickListener
        {
            View -> viewBMI.text = "BMI: " + (weight().toDouble() / ((height().toDouble()/ 100).pow(2))).toDouble()
            //View -> viewBMI.text = "BMI: " + (weight() / ((height() / 100) * (height() / 100))).toString()

//            if(viewBMI.text < 20)
//            {
//                print("Not enough space")
//            }
//            else if(viewBMI.text > 20)
//            {
//                print("Pig")
//            }
//            else
//            {
//                print("shit")
//            }
        })

        buttonForReset.setOnClickListener(View.OnClickListener
        {
            View -> editHeight.getText().clear();
                    editWeight.getText().clear();
                    viewBMI.text = "BMI: "
        })
    }

    fun weight(): Int
    {
        val input_weight = findViewById(R.id.editTextWeight) as EditText
        return Integer.parseInt(input_weight.text.toString())
    }

    fun height(): Int
    {
        val input_height = findViewById(R.id.editTextHeight) as EditText
        return Integer.parseInt(input_height.text.toString())
    }
}
