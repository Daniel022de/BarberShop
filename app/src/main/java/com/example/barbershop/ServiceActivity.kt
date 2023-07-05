package com.example.barbershop

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.barbershop.adapter.AdapterService
import com.example.barbershop.model.Service

class ServiceActivity : AppCompatActivity() {

    private var selectedServiceName: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        val recyclerView_services = findViewById<RecyclerView>(R.id.recyclerView_services)
        recyclerView_services.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        recyclerView_services.setHasFixedSize(true)

        //val AppointmentButton: Button = findViewById(R.id.buttonBookAppointment)

        val listServices: MutableList<Service> = mutableListOf()
        val adapterService = AdapterService(this,listServices)
        recyclerView_services.adapter = adapterService

        val service1 = Service(
            R.drawable.ic_hair,
            name = "Corte de Cabelo",
            describe = "Faça uma breve descrição do seu serviço",
            price = "R$ 20,00"

        )
        val service2 = Service(
            R.drawable.ic_bearde,
            name = "Barba",
            describe = "Faça uma breve descrição do seu serviço",
            price = "R$ 10,00"

        )
        val service3 = Service(
            R.drawable.ic_hair_bearde,
            name = "Corte de Cabelo e Barba",
            describe = "Faça uma breve descrição do seu serviço",
            price = "R$ 30,00"

        )
        val service4 = Service(
            R.drawable.ic_eyebrow,
            name = "Sombrancelha",
            describe = "Faça uma breve descrição do seu serviço",
            price = "R$ 20,00"

        )

        listServices.add(service1)
        listServices.add(service2)
        listServices.add(service3)
        listServices.add(service4)


//        AppointmentButton.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                val intent = Intent(this@ServiceActivity, ScheduleActivity::class.java)
//                startActivity(intent)
//            }
//        })




        val onItemClickListener = object : AdapterService.OnItemClickListener {
            override fun onItemClick(position: Int) {

                selectedServiceName = listServices[position].name
                val intent = Intent(this@ServiceActivity, ScheduleActivity::class.java)
                intent.putExtra("selected_service_name", selectedServiceName)
                startActivity(intent)


//                if (position == 0) {
//                    setContentView(R.layout.hair)
//                }
//                else if (position == 1) {
//                    setContentView(R.layout.bearde)
//                }
//                else if (position == 2) {
//                    setContentView(R.layout.hair_bearde)
//                }
//                else {
//                    setContentView(R.layout.eyebrow)
//                }

            }
        }

        adapterService.setOnItemClickListener(onItemClickListener)




    }}