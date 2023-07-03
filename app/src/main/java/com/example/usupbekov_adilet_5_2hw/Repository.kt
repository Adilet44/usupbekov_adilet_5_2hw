package com.example.usupbekov_adilet_5_2hw

import android.telecom.Call
import androidx.lifecycle.MutableLiveData
import com.example.usupbekov_adilet_5_2hw.remote.LoveModel
import com.example.usupbekov_adilet_5_2hw.remote.RetrofitServic
import okhttp3.Response
import javax.security.auth.callback.Callback

class Repository {
    fun getLove(fName: String, sName: String): MutableLiveData<LoveModel> {
        val liveLove = MutableLiveData<LoveModel>()

        RetrofitServic().api.percentageName(fName, sName).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful) {
                    liveLove.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {

            }
        })
        return liveLove
    }
}