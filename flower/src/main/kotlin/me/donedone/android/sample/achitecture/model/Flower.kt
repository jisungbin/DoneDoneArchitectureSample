package me.donedone.android.sample.achitecture.model

import javax.inject.Named

class FlowerProvider {
    @Named("network")
    lateinit var network: String

    @Named("calendar")
    lateinit var calendar: String

    fun get(): Pair<String, String> {
        return network to calendar
    }
}
