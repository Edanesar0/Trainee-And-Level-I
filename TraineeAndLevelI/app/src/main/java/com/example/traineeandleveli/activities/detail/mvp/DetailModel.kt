package com.example.traineeandleveli.activities.detail.mvp

import android.content.Context
import com.example.traineeandleveli.app.network.TraineeAndLevelINetwork
import com.example.traineeandleveli.app.utils.Session
import com.example.traineeandleveli.entities.Track
import com.example.traineeandleveli.entities.TrackX
import com.google.gson.Gson


class DetailModel(private val network: TraineeAndLevelINetwork) {
    fun loadTrack(id: String?,context: Context): TrackX? {
        val element = Gson().fromJson<Track>(Session(context).getData("tracks"), Track::class.java)
        val text = element.tracks.track.first { dat -> dat.attr.rank == id }
        return text
    }
}