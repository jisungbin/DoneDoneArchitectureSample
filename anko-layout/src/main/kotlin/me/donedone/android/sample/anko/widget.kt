package me.donedone.android.sample.anko

import android.graphics.Color

interface Text : Widget {
    val value: String
    val color: Int
}

fun Layout.text(
    value: String,
    color: Int = Color.BLACK,
) {
    views += object : Text {
        override val value = value
        override val color = color
    }
}