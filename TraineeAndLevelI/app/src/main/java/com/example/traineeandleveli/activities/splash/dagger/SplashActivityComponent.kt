package com.example.traineeandleveli.activities.splash.dagger

import com.example.traineeandleveli.activities.splash.SplashActivity
import com.example.traineeandleveli.app.dagger.AppComponent
import dagger.Component

@SplashActivityScope
@Component(modules = arrayOf(SplashActivityModule::class), dependencies = [(AppComponent::class)])
interface SplashActivityComponent {
    fun inject(splashActivity: SplashActivity)

}
