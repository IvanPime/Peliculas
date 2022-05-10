package com.example.laboratorio1.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pelicula(val nombre: String, val anio: String, val genero: String, val video: String, val imagen: String) :
    Parcelable
