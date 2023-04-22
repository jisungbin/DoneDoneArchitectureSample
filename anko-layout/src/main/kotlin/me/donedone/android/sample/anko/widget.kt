@file:Suppress("UnusedReceiverParameter")

package me.donedone.android.sample.anko

import android.graphics.Color

@AnkoDsl
interface Widget

class Text internal constructor(
    var value: String = "",
    var color: Int = Color.BLACK,
) : Widget

fun Layout.text(builder: Text.() -> Unit): Widget {
    return Text().apply(builder)
}
