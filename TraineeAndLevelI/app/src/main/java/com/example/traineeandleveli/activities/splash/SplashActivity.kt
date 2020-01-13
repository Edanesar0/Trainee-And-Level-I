package com.example.traineeandleveli.activities.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.traineeandleveli.activities.splash.dagger.DaggerSplashActivityComponent
import com.example.traineeandleveli.activities.splash.dagger.SplashActivityModule
import com.example.traineeandleveli.activities.splash.mvp.SplashPresenter
import com.example.traineeandleveli.activities.splash.mvp.SplashView
import com.example.traineeandleveli.app.TraineeAndLevelIApplication
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var splashView: SplashView
    @Inject
    lateinit var splashPresenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerSplashActivityComponent
            .builder()
            .appComponent(TraineeAndLevelIApplication[this].component())
            .splashActivityModule(SplashActivityModule(this))
            .build().inject(this)
        setContentView(splashView)
        splashPresenter.onCreate()

    }

    override fun onDestroy() {
        super.onDestroy()
        splashPresenter.onDestroy()
    }
}
