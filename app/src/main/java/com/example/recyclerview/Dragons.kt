package com.example.recyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dragons(
    val imgDragons: Int,
    val nameDragons: String,
    val descDragons: String
) : Parcelable
