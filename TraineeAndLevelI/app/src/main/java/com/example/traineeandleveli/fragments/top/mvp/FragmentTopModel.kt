package com.example.traineeandleveli.fragments.top.mvp

import android.content.Context
import com.example.traineeandleveli.app.network.TraineeAndLevelINetwork
import com.example.traineeandleveli.app.utils.Session
import com.example.traineeandleveli.entities.Track
import com.example.traineeandleveli.entities.TrackX
import com.google.gson.Gson


class FragmentTopModel(private val network: TraineeAndLevelINetwork) {

    fun loadData(context: Context): List<TrackX> {
        val lista: ArrayList<TrackX> = ArrayList()
        val element = Gson().fromJson<Track>(Session(context).getData("tracks"), Track::class.java)
        lista.addAll(element.tracks.track)
        return lista
    }
}