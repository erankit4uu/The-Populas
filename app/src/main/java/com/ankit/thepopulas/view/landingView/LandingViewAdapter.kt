package com.ankit.thepopulas.view.landingView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ankit.thepopulas.R
import com.ankit.thepopulas.databinding.LandingRowBinding
import com.ankit.thepopulas.model.Result
import com.squareup.picasso.Picasso

class LandingViewAdapter internal constructor(
    var context: Context,
    var list: List<Result>
) :
    RecyclerView.Adapter<LandingViewAdapter.MyViewAdapter>() {
    lateinit var binding: LandingRowBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewAdapter {

        val layoutInflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.landing_row, parent, false)
        return MyViewAdapter(binding, context)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: MyViewAdapter, position: Int) {
        holder.bindView(list)
    }

    class MyViewAdapter(val binding: LandingRowBinding, context: Context) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(resultList: List<Result>) {
            Picasso.get()
                .load("https://image.tmdb.org/t/p/w780"+resultList[adapterPosition].poster_path)
                .into(binding.image)

        }
    }
}