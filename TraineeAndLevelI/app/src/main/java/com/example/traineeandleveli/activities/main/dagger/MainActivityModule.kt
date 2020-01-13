package com.example.traineeandleveli.activities.main.dagger

import android.app.Activity
import com.example.traineeandleveli.activities.main.mvp.MainModel
import com.example.traineeandleveli.activities.main.mvp.MainPresenter
import com.example.traineeandleveli.activities.main.mvp.MainView
import com.example.traineeandleveli.app.network.TraineeAndLevelINetwork
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule(private val activity: Activity) {
    @Provides
    @MainActivityScope
    fun view(): MainView {
        return MainView(activity)
    }

    @Provides
    @MainActivityScope
    fun model(network: TraineeAndLevelINetwork): MainModel {
        return MainModel(network)
    }

    @Provides
    @MainActivityScope
    fun presenter(view: MainView, model: MainModel): MainPresenter {
        return MainPresenter(view, model)
    }
}