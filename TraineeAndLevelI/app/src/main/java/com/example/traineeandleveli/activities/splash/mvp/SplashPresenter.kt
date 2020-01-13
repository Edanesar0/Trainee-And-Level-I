package com.example.traineeandleveli.activities.splash.mvp

import android.util.Log
import android.widget.Toast
import com.example.traineeandleveli.R
import com.example.traineeandleveli.app.utils.Session
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class SplashPresenter(private val view: SplashView, private val model: SplashModel) {
    private val disposable = CompositeDisposable()

    fun onCreate() {
        disposable.add(loadData())
    }

    fun onDestroy() {
        disposable.clear()
    }

    private fun loadData(): Disposable {
        return view.onEnterView()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { getTopTracks() }
    }

    private fun getTopTracks(): Disposable {
        return model.loadTopTracks("829751643419a7128b7ada50de590067")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ top ->
                if (top != null) {
                    Session(view.context).setData("tracks", top.toString())
                    view.changeActivity()
                } else {
                    Toast.makeText(
                        view.context,
                        view.context.getString(R.string.error_load_top),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }, { throwable ->
                Log.e("observer", throwable.toString())
            }
            )
    }


}
