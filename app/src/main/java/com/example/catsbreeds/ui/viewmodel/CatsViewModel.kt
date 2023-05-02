package com.example.catsbreeds.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catsbreeds.domain.model.Cat
import com.example.catsbreeds.domain.usecases.GetCatsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatsViewModel @Inject constructor(private val getCatsUseCase: GetCatsUseCase):ViewModel() {

    val catModel = MutableLiveData<List<Cat>>()
    val isLoading = MutableLiveData<Boolean>()
    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getCatsUseCase()
            if(!result.isNullOrEmpty()){
                catModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }
}