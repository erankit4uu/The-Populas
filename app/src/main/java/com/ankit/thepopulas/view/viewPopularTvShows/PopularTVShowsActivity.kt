package com.ankit.thepopulas.view.viewPopularTvShows

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.ankit.thepopulas.R
import com.ankit.thepopulas.databinding.ActivityCommonRecyclerBinding
import com.ankit.thepopulas.view.base.BaseViewActivity
import com.ankit.thepopulas.view.viewPopularTvShows.viewModel.PopularTvShowsViewModel


class PopularTVShowsActivity : BaseViewActivity(){

    lateinit var viewModel : PopularTvShowsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = binding(R.layout.activity_common_recycler) as ActivityCommonRecyclerBinding

        viewModel = ViewModelProviders.of(this).get(PopularTvShowsViewModel::class.java)

        binding.recyclerCommon.layoutManager = LinearLayoutManager(this)

        viewModel.tvShowsList.observe(this, Observer { tvList ->
            if (tvList != null){
                binding.recyclerCommon.adapter = PopularTVShowsAdapter(this, tvList.results)
                binding.textViewMoreShows.text = "Popular TV Shows"

            }
        })
    }

}