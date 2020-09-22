package com.example.ckprojectstructure_android.presentation.main

import android.os.Bundle
import android.os.Handler
import android.view.View
import com.example.ckprojectstructure_android.R
import com.example.ckprojectstructure_android.data.api.ApiState
import com.example.ckprojectstructure_android.presentation.BaseActivity
import com.example.ckprojectstructure_android.presentation.main.model.JsonCovidNineteen
import com.example.ckprojectstructure_android.util.extension.gone
import com.example.ckprojectstructure_android.util.extension.visible
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Thread.sleep
import kotlin.random.Random

class MainActivity : BaseActivity() {

    private var confirmed: Int = -1
    private var recovered: Int = -1
    private var hospitalized: Int = -1
    private var deaths: Int = -1
    private var newConfirmed: Int = -1
    private var newRecovered: Int = -1
    private var newHospitalized: Int = -1
    private var newDeaths: Int = -1
    private var updateDate: String = ""
    private var isRuning = true

//    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpView()
        setUpViewModel()
//        viewModel.getCovidNineteen()
    }

    override fun setUpView() {
        randomCovid()

    }

    private fun randomCovid() {
        confirmed = Random.nextInt(99999)
        recovered = Random.nextInt(99999)
        hospitalized = Random.nextInt(99999)
        deaths = Random.nextInt(99999)
        newConfirmed = Random.nextInt(confirmed)
        newRecovered = Random.nextInt(recovered)
        newHospitalized = Random.nextInt(hospitalized)
        newDeaths = Random.nextInt(deaths)
        updateDate = "อัพเดตล่าสุดวันที่ 9/23/2020"
        setStatusCovid()
    }

    override fun setUpViewModel() {
//        with(viewModel) {
//            observe(apiStateCovidNineteen) { processGetCovidNineteen(it) }
//        }
    }

    fun onButtonClick(v: View) {
        if (v == btn_runstop) {
            if (isRuning) {
                isRuning = false
                btn_runstop.text = "Click Stop"
                shimmerLayout.stopShimmer()
                shimmerLayout.gone()
            } else {
                isRuning = true
                randomCovid()
                btn_runstop.text = "Click Run"
                shimmerLayout.startShimmer()
                shimmerLayout.visible()
            }

        }
    }

    private fun setStatusCovid() {
        text_infected.text = "${confirmed} [+ ${newConfirmed}]"
        text_recovery.text = "${recovered} [+ ${newRecovered}]"
        text_getwell.text = "${hospitalized} [+ ${newHospitalized}]"
        text_die.text = "${deaths} [+ ${newDeaths}]"
        text_update.text = "อัพเดตวันที่ ${updateDate}"
    }

    private fun processGetCovidNineteen(apiState: ApiState<JsonCovidNineteen>) {
        when (apiState) {
            is ApiState.Success -> {
                confirmed = apiState.data.Confirmed
                recovered = apiState.data.Recovered
                hospitalized = apiState.data.Hospitalized
                deaths = apiState.data.Deaths
                newConfirmed = apiState.data.NewConfirmed
                newRecovered = apiState.data.NewRecovered
                newHospitalized = apiState.data.NewHospitalized
                newDeaths = apiState.data.NewDeaths
                updateDate = apiState.data.UpdateDate
                setStatusCovid()
            }
            is ApiState.Fail -> showDialogMessage("", apiState.message)
        }
    }

}