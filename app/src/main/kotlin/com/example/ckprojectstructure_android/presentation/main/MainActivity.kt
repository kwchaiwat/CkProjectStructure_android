package com.example.ckprojectstructure_android.presentation.main

import android.os.Bundle
import android.view.View
import com.example.ckprojectstructure_android.R
import com.example.ckprojectstructure_android.presentation.BaseActivity
import com.example.ckprojectstructure_android.presentation.covidstatus.CovidStatusActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpView()
        setUpViewModel()
    }

    override fun setUpView() {}

    override fun setUpViewModel() {}

    fun onButtonClick(v: View) {
        if (v === btn_covid) {
            startActivity(CovidStatusActivity.starterIntent(this))
        }
    }

}