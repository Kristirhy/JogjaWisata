package com.example.wisatajogja.service

import com.example.wisatajogja.model.WisataAlamModel
import retrofit2.Call
import retrofit2.http.GET


interface Api  {
    @GET("wisata")
    fun getData() : Call<List<WisataAlamModel>>

}