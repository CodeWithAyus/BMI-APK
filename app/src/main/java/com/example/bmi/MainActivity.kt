package com.example.bmi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat

@Suppress("UNUSED_EXPRESSION")
class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtWeight=findViewById<EditText>(R.id.edtwt)
        val edtHeight=findViewById<EditText>(R.id.edtht)
        val submitButton=findViewById<Button>(R.id.subbtn)
        val finalResult=findViewById<TextView>(R.id.resulttxt)
        val myActivity=findViewById<LinearLayout>(R.id.myActivity)

        submitButton.setOnClickListener {

            val weightIn=edtWeight.text.toString().toDoubleOrNull()
            val HeightFeet = edtHeight.text.toString().toDoubleOrNull()

            if (weightIn!=null&&HeightFeet!=null){
                val heightMeter=HeightFeet*0.3048
                val statment="Your BMI is :- "
                val status="Status"
                val underWeight="You are UnderWeight"
                val overWeight="You are OverWeight"
                val Healthy="You are Healthy"


                val BMI=weightIn/(heightMeter*heightMeter)
                if (BMI<18)

                {
                    finalResult.text=String.format("$statment $BMI \n $status $underWeight")
                    myActivity.setBackgroundColor(ContextCompat.getColor(this,R.color.underWeight))
                }
                else if (BMI>23){
                    finalResult.text=String.format("$statment $BMI \n $status $overWeight")
                    myActivity.setBackgroundColor(ContextCompat.getColor(this,R.color.overWeight))
                }
                else{
                    finalResult.text=String.format ("$statment $BMI \n $status $Healthy")
                    myActivity.setBackgroundColor(ContextCompat.getColor(this,R.color.healthy))
                }
            }

        }
    }

}