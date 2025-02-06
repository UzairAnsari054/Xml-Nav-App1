package com.example.xmlnavapp1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class User(
    val name: String,
    val age: Int
) : Parcelable
