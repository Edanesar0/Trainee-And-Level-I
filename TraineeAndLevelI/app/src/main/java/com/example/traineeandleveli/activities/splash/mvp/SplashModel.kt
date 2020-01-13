package com.example.traineeandleveli.activities.splash.mvp

import com.example.traineeandleveli.app.network.TraineeAndLevelINetwork
import com.google.gson.JsonObject
import io.reactivex.Observable


class SplashModel(private val network: TraineeAndLevelINetwork) {


    fun loadTopTracks(api_key: String): Observable<JsonObject> {
        return network.sendTop(api_key)
    }


}