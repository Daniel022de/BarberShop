package com.example.barbershop.model

import java.io.Serializable

data class Service(
    val image: Int,
    val name: String,
    val describe: String,
    val price: String


) : Serializable