package me.donedone.android.sample.achitecture

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import me.donedone.android.sample.achitecture.model.FlowerProvider
import me.donedone.android.sample.anko.layoutOptions
import me.donedone.android.sample.anko.text
import me.donedone.android.sample.anko.verticalLayout

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
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
