package com.example.traineeandleveli.activities.detail.dagger


import com.example.traineeandleveli.activities.detail.DetailActivity
import com.example.traineeandleveli.app.dagger.AppComponent
import dagger.Component

@DetailActivityScope
@Component(modules = arrayOf(DetailActivityModule::class), dependencies = [(AppComponent::class)])
interface DetailActivityComponent {
    fun inject(detailActivity: DetailActivity)

}
