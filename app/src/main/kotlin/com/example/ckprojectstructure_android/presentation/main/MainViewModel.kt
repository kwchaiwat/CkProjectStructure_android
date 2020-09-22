package com.example.ckprojectstructure_android.presentation.main

import androidx.lifecycle.MutableLiveData
import com.example.ckprojectstructure_android.data.api.ApiState
import com.example.ckprojectstructure_android.data.repository.ApiRepository
import com.example.ckprojectstructure_android.presentation.BaseViewModel
import com.example.ckprojectstructure_android.presentation.main.model.JsonCovidNineteen
import com.example.ckprojectstructure_android.util.extension.addTo
import com.example.ckprojectstructure_android.util.extension.toLiveData

class MainViewModel(private val repository: ApiRepository) : BaseViewModel() {

    private val _apiStateCovidNineteen = MutableLiveData<ApiState<JsonCovidNineteen>>()
    val apiStateCovidNineteen = _apiStateCovidNineteen.toLiveData()

    fun getCovidNineteen() {
        repository.getCovidNineteen()
            .doOnSubscribe { _apiStateCovidNineteen.value = ApiState.Loading }
            .doOnTerminate { _apiStateCovidNineteen.value = ApiState.Done }
            .subscribe({ data ->
                _apiStateCovidNineteen.value = ApiState.Success(data)
            }, {
                it.printStackTrace()
                _apiStateCovidNineteen.value = ApiState.Error(it)
            })
            .addTo(compositeDisposable)
    }

}