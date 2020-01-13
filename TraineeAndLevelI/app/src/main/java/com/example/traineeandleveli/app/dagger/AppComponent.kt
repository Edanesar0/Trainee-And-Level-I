package com.example.traineeandleveli.app.dagger

import android.content.Context
import com.example.traineeandleveli.app.dagger.module.AppModule
import com.example.traineeandleveli.app.dagger.module.ContextModule
import com.example.traineeandleveli.app.dagger.module.GsonModule
import com.example.traineeandleveli.app.dagger.module.NetworkModule
import com.example.traineeandleveli.app.network.TraineeAndLevelINetwork
import dagger.Component

/**
 * interface que contiene las dependencia que se van a inyectar en la apicacclion
 * igual que lo metodos que se van a inyectar
 */
@AppScope
@Component(
    modules = arrayOf(
        AppModule::class,
        ContextModule::class,
        NetworkModule::class,
        GsonModule::class
    )
)
interface AppComponent {
    fun context(): Context
    fun network(): TraineeAndLevelINetwork
}
