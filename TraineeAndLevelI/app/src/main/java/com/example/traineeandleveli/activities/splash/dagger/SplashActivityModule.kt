package com.example.traineeandleveli.activities.splash.dagger

import android.app.Activity
import com.example.traineeandleveli.activities.splash.mvp.SplashModel
import com.example.traineeandleveli.activities.splash.mvp.SplashPresenter
import com.example.traineeandleveli.activities.splash.mvp.SplashView
import com.example.traineeandleveli.app.network.TraineeAndLevelINetwork
import dagger.Module
import dagger.Provides

@Module
class SplashActivityModule(private val activity: Activity) {
    @Provides
    @SplashActivityScope
    fun view(): SplashView {
        return SplashView(activity)
    }

    @Provides
    @SplashActivityScope
    fun model(network: TraineeAndLevelINetwork): SplashModel {
        return SplashModel(network)
    }

    @Provides
    @SplashActivityScope
    fun presenter(view: SplashView, model: SplashModel): SplashPresenter {
        return SplashPresenter(view, model)
    }
}