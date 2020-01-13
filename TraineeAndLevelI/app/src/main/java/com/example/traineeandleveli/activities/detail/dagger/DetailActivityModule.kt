package com.example.traineeandleveli.activities.detail.dagger

import android.app.Activity
import com.example.traineeandleveli.activities.detail.mvp.DetailModel
import com.example.traineeandleveli.activities.detail.mvp.DetailPresenter
import com.example.traineeandleveli.activities.detail.mvp.DetailView

import com.example.traineeandleveli.app.network.TraineeAndLevelINetwork
import dagger.Module
import dagger.Provides

@Module
class DetailActivityModule(private val activity: Activity) {
    @Provides
    @DetailActivityScope
    fun view(): DetailView {
        return DetailView(activity)
    }

    @Provides
    @DetailActivityScope
    fun model(network: TraineeAndLevelINetwork): DetailModel {
        return DetailModel(network)
    }

    @Provides
    @DetailActivityScope
    fun presenter(view: DetailView, model: DetailModel): DetailPresenter {
        return DetailPresenter(view, model)
    }
}