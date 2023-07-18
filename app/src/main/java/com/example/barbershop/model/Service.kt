package com.example.barbershop.model

import java.io.Serializable

data class Service(
    val imageResourceId: Int,
    val nameResourceId: String,
    val describeResourceId: String,
    val priceResourceId: String


) : Serializable