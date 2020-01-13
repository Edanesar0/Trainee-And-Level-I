package com.example.traineeandleveli.activities.main.dagger

import com.example.traineeandleveli.activities.main.MainActivity
import com.example.traineeandleveli.app.dagger.AppComponent
import dagger.Component

@MainActivityScope
@Component(modules = arrayOf(MainActivityModule::class), dependencies = [(AppComponent::class)])
interface MainActivityComponent {
    fun inject(splashActivity: MainActivity)

}
