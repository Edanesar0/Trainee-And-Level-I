package com.example.traineeandleveli.adapters.top.mvp

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.traineeandleveli.activities.detail.DetailActivity
import com.example.traineeandleveli.entities.TrackX
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.card_tracks.view.*

class TopViewHolder(itemView: View, items: List<TrackX>, val activity: Activity) :
    RecyclerView.ViewHolder(itemView) {

    fun clickDetalle(): Observable<Any> {
        return RxView.clicks(itemView.rootView.cardTrack)

    }

    fun getId(): Int {
        return Integer.parseInt(itemView.txtPosition?.text.toString().replace("# ","")) - 1
    }

    fun changeActivity() {
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra("ID", getId().toString())
        activity.startActivity(intent)
    }

}