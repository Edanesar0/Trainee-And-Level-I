package com.example.traineeandleveli.activities.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.traineeandleveli.activities.main.dagger.DaggerMainActivityComponent
import com.example.traineeandleveli.activities.main.dagger.MainActivityModule
import com.example.traineeandleveli.activities.main.mvp.MainPresenter
import com.example.traineeandleveli.activities.main.mvp.MainView
import com.example.traineeandleveli.app.TraineeAndLevelIApplication
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var mainView: MainView
    @Inject
    lateinit var mainPresenter: MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerMainActivityComponent
            .builder()
            .appComponent(TraineeAndLevelIApplication[this].component())
            .mainActivityModule(MainActivityModule(this))
            .build().inject(this)
        setContentView(mainView)
        mainPresenter.onCreate()


    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.onDestroy()
    }

}
