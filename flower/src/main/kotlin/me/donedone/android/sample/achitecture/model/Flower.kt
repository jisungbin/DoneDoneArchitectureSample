package me.donedone.android.sample.achitecture.model

import javax.inject.Inject
import javax.inject.Named

class FlowerProvider {
    @Inject
    @Named("network")
    lateinit var network: String

    @Inject
    @Named("calendar")
    lateinit var calendar: String

    fun get(): Pair<String, String> {
        return network to calendar
    }
}
