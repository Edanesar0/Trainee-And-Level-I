package com.example.traineeandleveli.fragments.top.dagger

import com.example.traineeandleveli.app.dagger.AppComponent
import com.example.traineeandleveli.fragments.top.FragmentTop
import dagger.Component

@FragmentTopScope
@Component(modules = arrayOf(FragmentTopModule::class), dependencies = [(AppComponent::class)])
interface FragmentTopComponent {
    fun inject(fragmentTop: FragmentTop)
}
