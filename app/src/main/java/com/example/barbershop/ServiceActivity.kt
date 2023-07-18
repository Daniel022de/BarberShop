package com.example.barbershop

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.barbershop.adapter.AdapterService
import com.example.barbershop.model.Service

class ServiceActivity : AppCompatActivity() {

    private var selectedServiceName: Service? = null


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
            nameResourceId = "Corte de Cabelo",
            describeResourceId = "Faça uma breve descrição do seu serviço",
            priceResourceId = "R$ 20,00"

        )
        val service2 = Service(
            R.drawable.ic_bearde,
            "Barba",
            "Faça uma breve descrição do seu serviço",
            "R$ 10,00"

        )
        val service3 = Service(
            R.drawable.ic_hair_bearde,
            "Corte de Cabelo e Barba",
            "Faça uma breve descrição do seu serviço",
            "R$ 30,00"

        )
        val service4 = Service(
            R.drawable.ic_eyebrow,
            "Sombrancelha",
            "Faça uma breve descrição do seu serviço",
            "R$ 20,00"

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

                val itemClicked = recyclerView_services.getChildAt(position)
                itemClicked.setBackgroundColor(Color.LTGRAY) // Altere a cor para a cor desejada

                // Restaurar a cor original após um intervalo de tempo
                val handler = Handler()
                handler.postDelayed({
                    itemClicked.setBackgroundColor(Color.TRANSPARENT) // Restaurar a cor original
                }, 500) // Defina o tempo desejado para o efeito de clique


                selectedServiceName = listServices[position]
                val intent = Intent(this@ServiceActivity, ScheduleActivity::class.java)
                intent.putExtra("selected_service_name", selectedServiceName)
                startActivity(intent)




            }
        }

        adapterService.setOnItemClickListener(onItemClickListener)




    }}