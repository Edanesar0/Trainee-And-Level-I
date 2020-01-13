package com.example.traineeandleveli.app

import android.app.Activity
import android.app.Application
import android.app.Service
import androidx.fragment.app.Fragment
import com.example.traineeandleveli.app.dagger.AppComponent
import com.example.traineeandleveli.app.dagger.DaggerAppComponent
import com.example.traineeandleveli.app.dagger.module.AppModule
import com.example.traineeandleveli.app.dagger.module.ContextModule

/**
 * Clase de configuracion de la apliacion esta es la primera clase que se ejecuta y tiene toda la configuracion incial
 */
class TraineeAndLevelIApplication : Application() {
    private var component: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .contextModule(ContextModule(this)) // must be injected by dagger look in future.
            .appModule(AppModule(this))
            .build()
    }

    fun component(): AppComponent? {
        return component
    }

    companion object {
        operator fun get(activity: Activity): TraineeAndLevelIApplication {
            return activity.application as TraineeAndLevelIApplication
        }

        operator fun get(fragment: Fragment): TraineeAndLevelIApplication {
            return fragment.activity?.application as TraineeAndLevelIApplication
        }

        operator fun get(service: Service): TraineeAndLevelIApplication {
            return service.application as TraineeAndLevelIApplication
        }
    }
}