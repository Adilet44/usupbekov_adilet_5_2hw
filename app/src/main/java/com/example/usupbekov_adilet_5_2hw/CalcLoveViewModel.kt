package com.example.usupbekov_adilet_5_2hw

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.usupbekov_adilet_5_2hw.remote.LoveModel

class CalcLoveViewModel: ViewModel() {
    private val repository = Repository()

    fun liveLove(fName: String, sName: String): LiveData<LoveModel> {
        return repository.getLove(fName,sName)
    }
}