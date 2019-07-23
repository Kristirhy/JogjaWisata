package com.example.wisatajogja.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.util.Log.e
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.wisatajogja.R
import com.example.wisatajogja.activity.ActivityDetailWisata
import com.example.wisatajogja.model.WisataAlamModel

class WisataAdapter : BaseAdapter{
    lateinit var listWisata:List<WisataAlamModel>
    lateinit var ctx:Context

    constructor(){}
    constructor(ctx:Context, listWisata:List<WisataAlamModel>){
        this.listWisata=listWisata
        this.ctx=ctx
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var viewss = convertView
        var x : String
        if(viewss ==null) {
            viewss = LayoutInflater.from(ctx).inflate(R.layout.layout_item_adapter, parent, false)
        }
        val imgList:ImageView
        val tv_wisata:TextView

        val wisata = listWisata.get(position)
        x = wisata.idWisata
        val y = wisata.idKategori

        imgList=viewss!!.findViewById(R.id.imgList)
        tv_wisata=viewss.findViewById(R.id.tv_wisata)

        tv_wisata.text=wisata.nmWisata
        e("testt", "cek ${wisata.imgWisata}")
        Glide.with(ctx).load("http://172.16.10.11:8000/"+wisata.imgWisata).error(R.mipmap.ic_launcher).into(imgList)
        viewss.setOnClickListener {
//            Toast.makeText(ctx, "Coba Lagi ${x} ", Toast.LENGTH_SHORT).show()
            val b = Bundle()
            b.putString("ids", x)
        var intent = Intent(ctx, ActivityDetailWisata::class.java)
//            intent.putExtra("ids", x)
//            intent.putExtra("id", y)
            intent.putExtras(b)
            ctx.startActivity(intent)
        }
        return viewss

    }

    override fun getItem(position: Int): Any {
       return listWisata.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return listWisata.size
    }


//    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): WisataViewHolder {
//        val view=LayoutInflater.from(ctx).inflate(R.layout.layout_item_adapter, p0, false)
//        return WisataViewHolder(view)
//    }
//
//    override fun onBindViewHolder(p0: WisataViewHolder, p1: Int) {
//        val wisata = listWisata.get(p0.adapterPosition)
//        p0.tv_wisata.text=wisata.nmWisata
//        Glide.with(ctx).load(wisata.imgWisata).error(R.mipmap.ic_launcher).into(p0.imgList)
//    }
//
//    inner class WisataViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
//        var imgList:ImageView
//        var tv_wisata:TextView
//        init {
//            imgList=itemView.findViewById(R.id.imgList)
//            tv_wisata=itemView.findViewById(R.id.tv_wisata)
//        }
//    }
}