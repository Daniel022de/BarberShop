package com.example.barbershop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.graphics.drawable.toDrawable
import com.example.barbershop.model.Service


class ScheduleActivity : AppCompatActivity() {
    private lateinit var nomeEditText: EditText
//    private lateinit var diaRadioGroup: RadioGroup
//    private lateinit var horarioRadioGroup: RadioGroup
    private lateinit var serviceNameTextView: TextView
    private lateinit var serviceNameEditText: EditText
    private lateinit var diaGridLayout: GridLayout
    private lateinit var horarioGridLayout: GridLayout
    private lateinit var servicePriceEditText: EditText
    private lateinit var imageService : ImageView
    private lateinit var priceService: TextView
    private lateinit var nameService: TextView
    private lateinit var describeSerivce: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)


        nomeEditText = findViewById(R.id.nomeEditText)
        serviceNameTextView = findViewById(R.id.serviceNameTextView)
        serviceNameEditText = findViewById(R.id.serviceNameEditText)
        diaGridLayout = findViewById(R.id.diaGridLayout)
        horarioGridLayout = findViewById(R.id.horarioGridLayout)
        servicePriceEditText = findViewById(R.id.servicePriceEditText)
        imageService = findViewById(R.id.serviceImage)
        priceService = findViewById(R.id.price_service)
        nameService = findViewById(R.id.name_service)
        describeSerivce = findViewById(R.id.describe_service)

        val selectedServiceName = intent.getSerializableExtra("selected_service_name") as? Service

        serviceNameEditText.setText(selectedServiceName?.nameResourceId)
        servicePriceEditText.setText(selectedServiceName?.priceResourceId.orEmpty())


        if (selectedServiceName != null) {
            imageService.setImageResource(selectedServiceName.imageResourceId)
            priceService.setText(selectedServiceName.priceResourceId)
            nameService.setText(selectedServiceName.nameResourceId)
            describeSerivce.setText(selectedServiceName.describeResourceId)
        }


        val enviarButton = findViewById<Button>(R.id.enviarButton)
        enviarButton.setOnClickListener {
            enviarAgendamento()
        }
    }



    fun enviarAgendamento() {
        val nome = nomeEditText.text.toString()
        val diaSelecionado = getDiaSelecionado(diaGridLayout)
        val horarioSelecionado = gethorarioSelecionado(horarioGridLayout)
        val selectedServiceName = serviceNameEditText.text.toString()
        val selectedPrice = servicePriceEditText.text.toString()

        if (nome.isNotEmpty() && diaSelecionado.isNotEmpty() && horarioSelecionado.isNotEmpty() && selectedServiceName.isNotEmpty()) {

            val mensagem = "*Olá! Gostaria de agendar um horário*.\n\n*Nome*: $nome\n*Serviço*: $selectedServiceName\n*Dia*: $diaSelecionado\n*Horário*: $horarioSelecionado\n" +
                    "*Preço*: $selectedPrice"
            enviarMensagemWhatsApp("+5521985198380", mensagem)

            desabilitarDia(diaSelecionado)
            desabilitarHorario(horarioSelecionado)
        } else {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
        }

    }

    fun enviarMensagemWhatsApp(numero: String, mensagem: String) {
        val uri = Uri.parse("https://api.whatsapp.com/send?phone=$numero&text=$mensagem")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    private fun desabilitarDia(dia: String) {
        when (dia) {
            "Segunda-feira" -> {
                val segundaRadioButton = findViewById<RadioButton>(R.id.segundaRadioButton)
                segundaRadioButton.isEnabled = false
            }
            "Terça-feira" -> {
                val tercaRadioButton = findViewById<RadioButton>(R.id.tercaRadioButton)
                tercaRadioButton.isEnabled = false
            }
            "Quarta-feira" -> {
                val quartaRadioButton = findViewById<RadioButton>(R.id.quartaRadioButton)
                quartaRadioButton.isEnabled = false
            }
            "Quinta-feira" -> {
                val quintaRadioButton = findViewById<RadioButton>(R.id.quintaRadioButton)
                quintaRadioButton.isEnabled = false
            }
            "Sexta-feira" -> {
                val sextaRadioButton = findViewById<RadioButton>(R.id.sextaRadioButton)
                sextaRadioButton.isEnabled = false
            }
            "Sábado" -> {
                val sabadoRadioButton = findViewById<RadioButton>(R.id.sabadoRadioButton)
                sabadoRadioButton.isEnabled = false
            }
        }
    }

    private fun desabilitarHorario(horario: String) {
        when (horario) {
            "10:00" -> {
                val horario10RadioButton = findViewById<RadioButton>(R.id.horario10RadioButton)
                horario10RadioButton.isEnabled = false
            }
            "11:00" -> {
                val horario11RadioButton = findViewById<RadioButton>(R.id.horario11RadioButton)
                horario11RadioButton.isEnabled = false
            }
            "12:00" -> {
                val horario12RadioButton = findViewById<RadioButton>(R.id.horario12RadioButton)
                horario12RadioButton.isEnabled = false
            }
            "13:00" -> {
                val horario13RadioButton = findViewById<RadioButton>(R.id.horario13RadioButton)
                horario13RadioButton.isEnabled = false
            }
            "14:00" -> {
                val horario14RadioButton = findViewById<RadioButton>(R.id.horario14RadioButton)
                horario14RadioButton.isEnabled = false
            }
            "15:00" -> {
                val horario15RadioButton = findViewById<RadioButton>(R.id.horario15RadioButton)
                horario15RadioButton.isEnabled = false
            }
            "16:00" -> {
                val horario16RadioButton = findViewById<RadioButton>(R.id.horario16RadioButton)
                horario16RadioButton.isEnabled = false
            }
            "17:00" -> {
                val horario17RadioButton = findViewById<RadioButton>(R.id.horario17RadioButton)
                horario17RadioButton.isEnabled = false
            }
            "18:00" -> {
                val horario18RadioButton = findViewById<RadioButton>(R.id.horario18RadioButton)
                horario18RadioButton.isEnabled = false
            }
            "19:00" -> {
                val horario19RadioButton = findViewById<RadioButton>(R.id.horario19RadioButton)
                horario19RadioButton.isEnabled = false
            }
        }
    }
    fun getDiaSelecionado(gridLayout: GridLayout): String {
        for (i in 0 until gridLayout.childCount) {
            val radioButton = gridLayout.getChildAt(i) as RadioButton
            if (radioButton.isChecked) {
                return radioButton.text.toString()
            }
        }
        return ""
    }
    fun gethorarioSelecionado(gridLayout: GridLayout): String {
        for (i in 0 until gridLayout.childCount) {
            val radioButton = gridLayout.getChildAt(i) as RadioButton
            if (radioButton.isChecked) {
                return radioButton.text.toString()
            }
        }
        return ""
    }
}
