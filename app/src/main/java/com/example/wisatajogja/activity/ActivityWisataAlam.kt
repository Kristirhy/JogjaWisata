package com.example.wisatajogja.activity

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.GridView
import com.example.wisatajogja.R
import com.example.wisatajogja.adapters.WisataAdapter
import com.example.wisatajogja.model.WisataAlamModel
import com.example.wisatajogja.viewModel.DataWisataViewModel
import kotlinx.android.synthetic.main.activity_wisata_alam.*

class ActivityWisataAlam : AppCompatActivity() {
    var gvWisataAlam : GridView? = null
    var dataWisataAdapter : WisataAdapter? = null
    var dataWisata : MutableList<WisataAlamModel>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wisata_alam)
        tv_idwisata.text="Wisata Alam"

        gvWisataAlam = findViewById(R.id.gvWisataAlam)

        val modelize = ViewModelProviders.of(this).get(DataWisataViewModel::class.java)
        modelize.datadata.observeForever {
            dataWisata = ArrayList<WisataAlamModel>()
            for (data in it!!){
                if (data.idKategori.equals("1")){
                    dataWisata!!.add(data)
                }else{
                    continue
                }
            }
            dataWisataAdapter = WisataAdapter(this@ActivityWisataAlam, dataWisata!!)
            gvWisataAlam!!.adapter = dataWisataAdapter
        }
    }
}