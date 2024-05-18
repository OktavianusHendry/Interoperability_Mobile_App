package com.okta.interoperability.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okta.interoperability.local.remote.response.Produk
import com.okta.interoperability.local.remote.response.ProdukResponse
import com.okta.interoperability.local.remote.response.ProdukResponseItem
import com.okta.interoperability.local.remote.retrofit.ApiConfig
import kotlinx.coroutines.Dispatchers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    private val _listData = MutableStateFlow<List<ProdukResponseItem>>(emptyList())
    val listData: StateFlow<List<ProdukResponseItem>> = _listData

    private val _listBonangData = MutableStateFlow<List<Produk>>(emptyList())
    val listBonangData: StateFlow<List<Produk>> = _listBonangData

    companion object {
        private const val TAG = "MainViewModel"
    }

    init {
        getData()
        getBonangData()
    }

    fun getData() = viewModelScope.launch {
        try {
            val response = withContext(Dispatchers.IO) { ApiConfig.getApiService().getAllData().execute() }
            if (response.isSuccessful) {
                val responseBody = response.body()
                if (responseBody != null) {
                    _listData.value = responseBody
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "onFailure: ${e.message}")
        }
    }

    fun getBonangData() = viewModelScope.launch {
        try {
            val response = withContext(Dispatchers.IO){ ApiConfig.getBonangApiService().getAllDataXML().execute()}
            if (response.isSuccessful){
                val responseBody = response.body()
                if (responseBody != null) {
                    _listBonangData.value = responseBody.produk ?: emptyList()
                } else{
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "onFailure: ${e.message}")
        }

    }
}