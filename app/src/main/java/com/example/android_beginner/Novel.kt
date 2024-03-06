package com.example.android_beginner

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Novel(
    val tittle: String,
    val sinopsis: String,
    val price: String,
    val publisher: String,
    val cover: Int
) : Parcelable
