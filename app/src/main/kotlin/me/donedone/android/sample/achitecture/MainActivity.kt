package me.donedone.android.sample.achitecture

import android.app.Activity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import me.donedone.android.sample.achitecture.model.FlowerProvider
import me.donedone.android.sample.anko.layoutOptions
import me.donedone.android.sample.anko.text
import me.donedone.android.sample.anko.verticalLayout

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            layoutOptions(
                height = ViewGroup.LayoutParams.MATCH_PARENT,
                width = ViewGroup.LayoutParams.MATCH_PARENT,
                align = Gravity.CENTER,
            )
            +text {
                value = FlowerProvider().get().toString()
            }
        }
    }
}
