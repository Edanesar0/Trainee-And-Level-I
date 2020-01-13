package com.example.traineeandleveli.adapters.top.dagger

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.traineeandleveli.R
import com.example.traineeandleveli.adapters.top.mvp.TopAdapterModel
import com.example.traineeandleveli.adapters.top.mvp.TopAdapterPresenter
import com.example.traineeandleveli.adapters.top.mvp.TopViewHolder
import com.example.traineeandleveli.app.network.TraineeAndLevelINetwork
import com.example.traineeandleveli.entities.TrackX
import dagger.Module
import dagger.Provides

@Module
class TopAdapterModule(
    val activity: Activity,
    val recyclerView: ViewGroup,
    val items: List<TrackX>
) {

    @Provides
    @TopAdapterScope
    fun view(): View {
        return LayoutInflater.from(activity).inflate(R.layout.card_tracks, recyclerView, false)

    }

    @Provides
    @TopAdapterScope
    fun topHolder(view: View): TopViewHolder {
        return TopViewHolder(view, items, activity)
    }

    @Provides
    @TopAdapterScope
    fun model(network: TraineeAndLevelINetwork): TopAdapterModel {
        return TopAdapterModel(network)
    }

    @Provides
    @TopAdapterScope
    fun presenter(view: TopViewHolder, model: TopAdapterModel): TopAdapterPresenter {
        return TopAdapterPresenter(view, model)
    }
}