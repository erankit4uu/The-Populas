package com.ankit.thepopulas.view.base

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseViewActivity : AppCompatActivity(){

    lateinit var binding: ViewDataBinding


    fun binding(layout: Int): ViewDataBinding {
        binding = DataBindingUtil.setContentView(this, layout)
        return binding
    }

    fun showToast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun showSnackbar(msg: String){
    }

    fun getTheFragment(frg : Fragment): Fragment{
        return frg
    }

}