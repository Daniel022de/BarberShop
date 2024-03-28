package com.example.barbershop.adapter

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.barbershop.R
import com.example.barbershop.model.Service

class AdapterService(private val context: Context, private val services: MutableList<Service>) :
    RecyclerView.Adapter<AdapterService.ServiceViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    private var listener: OnItemClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val itemLista = LayoutInflater.from(context).inflate(R.layout.services_item, parent, false)
        return ServiceViewHolder(itemLista)

    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        val itemCurrent = services[position]
        holder.bind(itemCurrent)
    }

    override fun getItemCount(): Int = services.size


    inner class ServiceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Service) {
            val image = itemView.findViewById<ImageView>(R.id.image_service)
            val name = itemView.findViewById<TextView>(R.id.name_service)
            val describe = itemView.findViewById<TextView>(R.id.describe_service)
            val price = itemView.findViewById<TextView>(R.id.price_service)

            image.setImageResource(item.imageResourceId)
            name.text = item.nameResourceId
            describe.text = item.describeResourceId
            price.text = item.priceResourceId

            itemView.setOnClickListener {
                listener?.onItemClick(position)
            }


        }

    }


    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

}