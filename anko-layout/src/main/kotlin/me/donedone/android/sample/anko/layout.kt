package me.donedone.android.sample.anko

import android.app.Activity
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout

@AnkoDsl
interface Widget

@AnkoDsl
interface Layout {
    val views: MutableList<Widget>
    val layoutOption: LayoutOption
}

interface LayoutOption {
    val height: Int
    val width: Int
    val align: Int
}

fun layoutOption(
    height: Int = ViewGroup.LayoutParams.WRAP_CONTENT,
    width: Int = ViewGroup.LayoutParams.WRAP_CONTENT,
    align: Int = Gravity.START,
): LayoutOption = object : LayoutOption {
    override val height = height
    override val width = width
    override val align = align
}

operator fun Layout.plusAssign(widget: Widget) {
    views += widget
}

fun Activity.verticalLayout(
    option: LayoutOption,
    builder: Layout.() -> Unit,
) {
    setContentView(LinearLayout(this).apply(linearLayoutScope))
}

