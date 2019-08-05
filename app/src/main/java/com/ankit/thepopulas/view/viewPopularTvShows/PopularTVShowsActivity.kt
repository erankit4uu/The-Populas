package com.ankit.thepopulas.view.viewPopularTvShows

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ankit.thepopulas.R
import com.ankit.thepopulas.base.BaseViewActivity



class PopularTVShowsActivity : BaseViewActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = binding(R.layout.popular_tv_shows_activity)
        val fragment = PopularTVShowsFragment()
        gotoFrag(fragment)

    }

    fun gotoFrag(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
        fragmentManager.beginTransaction()

    }

}