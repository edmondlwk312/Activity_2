package com.example.activity_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.text.DecimalFormat
import kotlin.math.pow

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editWeight = findViewById<EditText>(R.id.editTextWeight)
        val editHeight = findViewById<EditText>(R.id.editTextHeight)

        val viewBMI = findViewById<TextView>(R.id.textViewBMI)
        val decimal = DecimalFormat("00.00")

        val buttonForCalculate = findViewById<Button>(R.id.buttonCalculate)
        val buttonForReset = findViewById<Button>(R.id.buttonReset)

        val imageBMI = findViewById<ImageView>(R.id.imageViewProfile)

        buttonForCalculate.setOnClickListener(View.OnClickListener
        {
            val messageWeight:String = editWeight.text.toString()
            val messageHeight:String = editHeight.text.toString()

            if((messageWeight.trim().isNotEmpty()) || (messageHeight.trim().isNotEmpty()))
            {
                if(messageWeight.trim().isNotEmpty())
                {
                    if(messageHeight.trim().isNotEmpty())
                    {
                        if((weight().toDouble() / ((height().toDouble()/ 100).pow(2))) < 18.5)
                        {
                            viewBMI.text = "BMI: " + decimal.format((weight() / ((height().toDouble()/ 100).pow(2)))) + "\n" + "Underweight"
                            imageBMI.setImageResource(R.drawable.under)
                        }
                        else if(((weight().toDouble() / ((height().toDouble()/ 100).pow(2))) > 18.5) &&((weight().toDouble() / ((height().toDouble()/ 100).pow(2))) < 24.9))
                        {
                            viewBMI.text = "BMI: " + decimal.format((weight().toDouble() / ((height().toDouble()/ 100).pow(2)))) + "\n" + "Normal"
                            imageBMI.setImageResource(R.drawable.normal)
                        }
                        else if((weight().toDouble() / ((height().toDouble()/ 100).pow(2))) > 25)
                        {
                            viewBMI.text = "BMI: " + decimal.format((weight().toDouble() / ((height().toDouble()/ 100).pow(2)))) + "\n" + "Overweight"
                            imageBMI.setImageResource(R.drawable.over)
                        }
                    }
                    else
                    {
                        Toast.makeText(applicationContext, "Please Enter Height", Toast.LENGTH_SHORT).show()
                    }
                }
                else
                {
                    Toast.makeText(applicationContext, "Please Enter Weight", Toast.LENGTH_SHORT).show()
                }
            }
            else
            {
                Toast.makeText(applicationContext, "Please Enter Weight and Height", Toast.LENGTH_SHORT).show()
            }
        })

        buttonForReset.setOnClickListener(View.OnClickListener
        {
            View -> editHeight.getText().clear();
                    editWeight.getText().clear();
                    imageBMI.setImageResource(R.drawable.empty)
                    viewBMI.text = "BMI :"
        })
    }

    fun weight(): Int
    {
        val input_weight = findViewById<EditText>(R.id.editTextWeight)
        return Integer.parseInt(input_weight.text.toString())
    }

    fun height(): Int
    {
        val input_height = findViewById<EditText>(R.id.editTextHeight)
        return Integer.parseInt(input_height.text.toString())
    }
}