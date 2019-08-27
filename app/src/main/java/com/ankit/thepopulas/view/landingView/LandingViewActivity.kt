package com.ankit.thepopulas.view.landingView

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.ankit.thepopulas.R
import com.ankit.thepopulas.databinding.LandingViewActivityBinding
import com.ankit.thepopulas.view.base.BaseViewActivity
import com.ankit.thepopulas.view.viewPopularTvShows.PopularTVShowsActivity

class LandingViewActivity: BaseViewActivity() {
    lateinit var viewModel: LandingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = binding(R.layout.landing_view_activity) as LandingViewActivityBinding

        viewModel = ViewModelProviders.of(this).get(LandingViewModel::class.java)
        binding.recyclerShows.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerMovie.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerPeople.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)

        viewModel.tvShowsList.observe(this, Observer { list ->
            binding.recyclerShows.adapter = LandingViewAdapter(this, list.results)
            binding.textViewMoreShows.text = "Popular Tv Shows view more..."
        })
        viewModel.movieShowsList.observe(this, Observer { list ->
            binding.recyclerMovie.adapter = LandingViewAdapter(this, list.results)
            binding.textViewMoreTop.text = "Popular Movies view more..."
        })
        viewModel.peopleShowsList.observe(this, Observer { list ->
            binding.recyclerPeople.adapter = LandingPersonAdapter(this, list.results)
            binding.textViewMoreMovies.text = "Popular Peoples view more..."
        })

        binding.textViewMoreShows.setOnClickListener {
            val intent = Intent(this, PopularTVShowsActivity::class.java)
            startActivity(intent)
        }
    }

}