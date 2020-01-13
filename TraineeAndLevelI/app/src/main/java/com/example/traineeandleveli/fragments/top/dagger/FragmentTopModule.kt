package com.example.traineeandleveli.fragments.top.dagger

import android.app.Activity
import com.example.traineeandleveli.app.network.TraineeAndLevelINetwork
import com.example.traineeandleveli.fragments.top.mvp.FragmentTopModel
import com.example.traineeandleveli.fragments.top.mvp.FragmentTopPresenter
import com.example.traineeandleveli.fragments.top.mvp.FragmentTopView
import dagger.Module
import dagger.Provides

@Module
class FragmentTopModule(private val activity: Activity) {


    @Provides
    @FragmentTopScope
    fun view(): FragmentTopView {
        return FragmentTopView(activity)
    }

    @Provides
    @FragmentTopScope
    fun model(network: TraineeAndLevelINetwork): FragmentTopModel {
        return FragmentTopModel(network)
    }

    @Provides
    @FragmentTopScope
    fun presenter(view: FragmentTopView, model: FragmentTopModel): FragmentTopPresenter {
        return FragmentTopPresenter(view, model)
    }

}
