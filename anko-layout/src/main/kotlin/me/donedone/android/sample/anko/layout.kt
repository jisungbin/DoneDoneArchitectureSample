package me.donedone.android.sample.anko

import android.app.Activity
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

@AnkoDsl
abstract class Layout {
    abstract val widgets: MutableList<Widget>
    var layoutOptions: LayoutOptions? = null

    operator fun Widget.unaryPlus() {
        this@Layout.widgets += this
    }
}

interface LayoutOptions {
    val height: Int
    val width: Int
    val align: Int
}

fun Layout.layoutOptions(
    height: Int = ViewGroup.LayoutParams.WRAP_CONTENT,
    width: Int = ViewGroup.LayoutParams.WRAP_CONTENT,
    align: Int = Gravity.START,
) {
    layoutOptions = object : LayoutOptions {
        override val height = height
        override val width = width
        override val align = align
    }
}

fun Activity.verticalLayout(builder: Layout.() -> Unit) {
    val layout = object : Layout() {
        override val widgets = mutableListOf<Widget>()
    }.also(builder)
    val linearLayout = LinearLayout(this).apply {
        layout.layoutOptions?.let { options ->
            with(options) {
                layoutParams = LinearLayout.LayoutParams(width, height)
                gravity = align
            }
        }
    }
    for (widget in layout.widgets) {
        @Suppress("IntroduceWhenSubject")
        when {
            widget is Text -> {
                val textView = TextView(this).apply {
                    with(widget) {
                        text = value
                        setTextColor(color)
                    }
                }
                linearLayout.addView(textView)
            }
        }
    }
    setContentView(linearLayout)
}
