package com.example.wisatajogja.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.wisatajogja.model.WisataAlamModel
import com.example.wisatajogja.service.Api
import com.example.wisatajogja.service.Const
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataWisataViewModel : ViewModel() {
    var listWisata : MutableLiveData<List<WisataAlamModel>>? = null
    val datadata : LiveData<List<WisataAlamModel>>
        get() {
            if(listWisata == null){
                listWisata = MutableLiveData()
                loadDataBuku()
            }
            return listWisata!!
        }

    fun loadDataBuku(){
        val retrofit = Retrofit.Builder()
            .baseUrl(Const.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apidata = retrofit.create(Api::class.java)
        val calldata = apidata.getData()

        calldata.enqueue(object : Callback<List<WisataAlamModel>> {
            override fun onResponse(call: Call<List<WisataAlamModel>>, response: Response<List<WisataAlamModel>>) {
                listWisata!!.value = response.body()
            }

            override fun onFailure(call: Call<List<WisataAlamModel>>, t: Throwable) {

            }

        })
    }
}
