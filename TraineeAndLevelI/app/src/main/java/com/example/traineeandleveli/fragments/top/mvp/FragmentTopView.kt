package com.example.traineeandleveli.fragments.top.mvp

//import com.example.traineeandleveli.adapters.top.TopAdapter
import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.traineeandleveli.R
import com.example.traineeandleveli.adapters.top.TopAdapter
import com.example.traineeandleveli.entities.TrackX
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.main_fragment.view.*

@SuppressLint("ViewConstructor")
class FragmentTopView(private val activity: Activity) : FrameLayout(activity) {
    init {
        View.inflate(context, R.layout.main_fragment, this)
    }

    fun cargarDatosRecicler(lista: List<TrackX>) {
        val linear = LinearLayoutManager(activity)
        rootView.recicler.layoutManager = linear
        rootView.recicler.adapter = TopAdapter(activity, lista)
    }

    fun onEnterView(): Observable<Any> {
        return RxView.attaches(this)
    }
}