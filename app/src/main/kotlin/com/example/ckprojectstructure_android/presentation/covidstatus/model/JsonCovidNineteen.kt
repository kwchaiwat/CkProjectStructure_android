package com.example.ckprojectstructure_android.presentation.covidstatus.model

import com.google.gson.annotations.SerializedName

data class JsonCovidNineteen(

    @SerializedName("Confirmed")
    var Confirmed: Int = -1,

    @SerializedName("Recovered")
    var Recovered: Int = -1,

    @SerializedName("Hospitalized")
    var Hospitalized: Int = -1,

    @SerializedName("Deaths")
    var Deaths: Int = -1,

    @SerializedName("NewConfirmed")
    var NewConfirmed: Int = -1,

    @SerializedName("NewRecovered")
    var NewRecovered: Int = -1,

    @SerializedName("NewHospitalized")
    var NewHospitalized: Int = -1,

    @SerializedName("NewDeaths")
    var NewDeaths: Int = -1,

    @SerializedName("UpdateDate")
    var UpdateDate: String = "",

    @SerializedName("Source")
    var Source: String = "",

    @SerializedName("DevBy")
    var DevBy: String = "",

    @SerializedName("SeverBy")
    var SeverBy: String = ""

)