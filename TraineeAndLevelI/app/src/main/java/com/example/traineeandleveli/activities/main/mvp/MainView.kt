package com.example.traineeandleveli.activities.main.mvp

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.widget.FrameLayout
import com.example.traineeandleveli.R
import com.example.traineeandleveli.activities.main.MainActivity
import com.example.traineeandleveli.fragments.top.FragmentTop
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable


@SuppressLint("ViewConstructor")
class MainView(private val activity: Activity) : FrameLayout(activity) {
    init {
        View.inflate(context, R.layout.main_activity, this)
        (activity as MainActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.container, FragmentTop.newInstance())
            .commitNow()


    }

    fun onEnterView(): Observable<Any> {
        return RxView.attaches(this)
    }

}
