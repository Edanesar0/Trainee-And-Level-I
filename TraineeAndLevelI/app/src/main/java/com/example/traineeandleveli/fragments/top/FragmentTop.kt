package com.example.traineeandleveli.fragments.top

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.traineeandleveli.app.TraineeAndLevelIApplication
import com.example.traineeandleveli.fragments.top.dagger.DaggerFragmentTopComponent
import com.example.traineeandleveli.fragments.top.dagger.FragmentTopModule
import com.example.traineeandleveli.fragments.top.mvp.FragmentTopPresenter
import com.example.traineeandleveli.fragments.top.mvp.FragmentTopView
import javax.inject.Inject

class FragmentTop : Fragment() {

    @Inject
    lateinit var topView: FragmentTopView
    @Inject
    lateinit var topPresenter: FragmentTopPresenter

    companion object {
        fun newInstance() =
            FragmentTop()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        DaggerFragmentTopComponent
            .builder()
            .fragmentTopModule(FragmentTopModule(activity!!))
            .appComponent(TraineeAndLevelIApplication[activity!!].component())
            .build().inject(this)
        topPresenter.onCreate()
        return topView
    }

    override fun onDestroy() {
        topPresenter.onDestroy()
        super.onDestroy()
    }
}