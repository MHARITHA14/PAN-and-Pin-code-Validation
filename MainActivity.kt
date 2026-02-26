package com.example.panvalidation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.digitalcafeloginvalidation.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pan = findViewById<EditText>(R.id.editPan)
        val pincode = findViewById<EditText>(R.id.editPincode)
        val button = findViewById<Button>(R.id.btnValidate)
        val result = findViewById<TextView>(R.id.textResult)

        button.setOnClickListener {

            val panText = pan.text.toString().trim()
            val pinText = pincode.text.toString().trim()

            // Check empty
            if (panText.isEmpty() || pinText.isEmpty()) {
                result.text = "Both fields should not be empty"
                return@setOnClickListener
            }

            // PAN validation (10 alphanumeric)
            if (!panText.matches(Regex("[A-Za-z0-9]{10}"))) {
                result.text = "PAN must be 10 alphanumeric characters"
                return@setOnClickListener
            }

            // Pincode validation (6 digits)
            if (!pinText.matches(Regex("\\d{6}"))) {
                result.text = "Pincode must be 6 digits"
                return@setOnClickListener
            }

            result.text = "Validation Successful!"
        }
    }
}
