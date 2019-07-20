package com.example.wisatajogja.activity

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.wisatajogja.R
import com.example.wisatajogja.adapters.WisataAdapter
import com.example.wisatajogja.viewModel.DataWisataViewModel
import kotlinx.android.synthetic.main.layout_detail_wisata.*

class ActivityDetailWisata : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_detail_wisata)

        val x=intent.getStringExtra("ids")
        Toast.makeText(this, "Pantai ${x} ", Toast.LENGTH_SHORT).show()
        val modelize = ViewModelProviders.of(this).get(DataWisataViewModel::class.java)
        modelize.datadata.observeForever {
            for (data in it!!){
                if (data.idWisata.equals(x)){
                    Glide.with(this).load("http://172.16.10.11:8000/"+data.imgWisata).error(R.mipmap.ic_launcher).into(imgDetail)
                    tvNmWisata.setText(data.nmWisata)
                    tvDesc.setText(data.deskripsi)
                    tvAlamat.setText(data.alamat)
                    break
                } else{
                    Toast.makeText(this, "Data Tidak Tersedia", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}