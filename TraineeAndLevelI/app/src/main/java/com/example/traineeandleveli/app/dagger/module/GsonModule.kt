package com.example.traineeandleveli.app.dagger.module

import com.example.traineeandleveli.app.dagger.AppScope
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides

@Module
/**
 * Modulo encargado convertir datos string en
 * POJOS gson
 */
class GsonModule {

    @AppScope
    @Provides
    fun gson(): Gson {
        return GsonBuilder()
            .serializeNulls()
            .create()
    }
}
