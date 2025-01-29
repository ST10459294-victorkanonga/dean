package com.example.physicalapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import detailedviewscreenactivity

class MainScreenActivity : AppCompatActivity() {


    private lateinit var dateEditText: EditText
    private lateinit var morningScreenTimeEditText: EditText
    private lateinit var afternoonScreenTimeEditText: EditText
    private lateinit var activityNotesEditText: EditText

    // Using mutableListOf for better readability and clarity
    private val dates = mutableListOf<String>()
    private val morningScreenTimes = mutableListOf<Int>()
    private val afternoonScreenTimes = mutableListOf<Int>()
    private val activityNotes = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_screen)

        dateEditText = findViewById(R.id.dateeditText)
        morningScreenTimeEditText = findViewById(R.id.morningstepseditText)
        afternoonScreenTimeEditText = findViewById(R.id.afternonstepseditText)
        activityNotesEditText = findViewById(R.id.activitynoteseditText)

        val addButton: Button = findViewById(R.id.addButton)
        val clearButton: Button = findViewById(R.id.clearButton)
        val detailedViewButton: Button = findViewById(R.id.detailedviewbutton)

        addButton.setOnClickListener {
            addScreenTime()
        }

        clearButton.setOnClickListener {
            clearData()
        }

        detailedViewButton.setOnClickListener {
            val intent = Intent(this,detailedviewscreenactivity::class.java)
            intent.putStringArrayListExtra("dates", ArrayList(dates))  // Fixed: Convert MutableList to ArrayList
            intent.putIntegerArrayListExtra("morningScreenTimes", ArrayList(morningScreenTimes))  // Fixed: Convert MutableList to ArrayList
            intent.putIntegerArrayListExtra("afternoonScreenTimes", ArrayList(afternoonScreenTimes))  // Fixed: Convert MutableList to ArrayList
            intent.putStringArrayListExtra("activityNotes", ArrayList(activityNotes))  // Fixed: Convert MutableList to ArrayList
            startActivity(intent)
        }
    }

    private fun addScreenTime() {
        val date = dateEditText.text.toString()
        val morningScreenTime = morningScreenTimeEditText.text.toString().toIntOrNull()
        val afternoonScreenTime = afternoonScreenTimeEditText.text.toString().toIntOrNull()
        val notes = activityNotesEditText.text.toString()

        if (date.isNotEmpty() && morningScreenTime != null && afternoonScreenTime != null) {
            dates.add(date)
            morningScreenTimes.add(morningScreenTime)
            afternoonScreenTimes.add(afternoonScreenTime)
            activityNotes.add(notes)

            dateEditText.text.clear()
            morningScreenTimeEditText.text.clear()
            afternoonScreenTimeEditText.text.clear()
            activityNotesEditText.text.clear()

            Toast.makeText(this, "Data added successfully", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Please fill all fields correctly", Toast.LENGTH_SHORT).show()
        }
    }

    private fun clearData() {
        dates.clear()
        morningScreenTimes.clear()
        afternoonScreenTimes.clear()
        activityNotes.clear()

        dateEditText.text.clear()
        morningScreenTimeEditText.text.clear()
        afternoonScreenTimeEditText.text.clear()
        activityNotesEditText.text.clear()

        Toast.makeText(this, "Data cleared", Toast.LENGTH_SHORT).show()
    }
}
