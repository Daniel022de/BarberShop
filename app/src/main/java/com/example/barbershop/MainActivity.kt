package com.example.barbershop

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val AppointmentButton: Button = findViewById(R.id.buttonBookAppointment)
        val ServicesButton: Button = findViewById(R.id.buttonViewServices)
//        val ContactButton: Button = findViewById(R.id.buttonContactUs)

        AppointmentButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(this@MainActivity, ScheduleActivity::class.java)
                startActivity(intent)
            }
        })

        ServicesButton.setOnClickListener( object : View.OnClickListener{

            override fun onClick(v: View?) {
                val intent = Intent(this@MainActivity, ServiceActivity::class.java)
                startActivity(intent)
            }

        })

//        ContactButton.setOnClickListener{
//            setContentView(R.layout.activity_contact)
//        }
    }
}