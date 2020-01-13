package com.example.traineeandleveli.adapters.top.dagger

import com.example.traineeandleveli.adapters.top.TopAdapter
import com.example.traineeandleveli.app.dagger.AppComponent
import dagger.Component

@TopAdapterScope
@Component(modules = arrayOf(TopAdapterModule::class), dependencies = [(AppComponent::class)])
interface TopAdapterComponent {
    fun inject(topAdapter: TopAdapter)
}