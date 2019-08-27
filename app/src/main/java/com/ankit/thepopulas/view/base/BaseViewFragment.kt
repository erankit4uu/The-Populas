package com.ankit.thepopulas.view.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment


abstract class BaseViewFragment : Fragment() {
    lateinit var databinding : ViewDataBinding

    fun binding(layout: Int, inflater: LayoutInflater, container: ViewGroup){
        databinding = DataBindingUtil.inflate(inflater, layout , container, false)
    }

}