package com.example.traineeandleveli.app.dagger.module

import android.app.Application
import android.content.Context
import com.example.traineeandleveli.app.TraineeAndLevelIApplication
import com.example.traineeandleveli.app.dagger.AppScope

import dagger.Module
import dagger.Provides

/***
 * Clase encargada de proveer informacion
 * El cual contiene informacion o datos puros que
 * se desee inyectar
 */
@Module
class AppModule(private val application: TraineeAndLevelIApplication) {
    private val context: Context = application.applicationContext

    @Provides
    @AppScope
    fun application(): Application {
        return application
    }

    @AppScope
    @Provides
    fun context(): Context {
        return context
    }

}
