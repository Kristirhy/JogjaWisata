package com.example.wisatajogja.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.wisatajogja.R
import com.example.wisatajogja.activity.ActivityWisataAlam
import com.example.wisatajogja.activity.ActivityWisataKuliner
import com.example.wisatajogja.activity.ActivityWisataPantai
import com.example.wisatajogja.activity.ActivityWisataSejarah
import kotlinx.android.synthetic.main.fragment_beranda.*
import kotlinx.android.synthetic.main.layout_adapter.view.*

class BerandaFragment : Fragment() {
    var adapter: ImageAdapter? = null
    var homeAdapter = ArrayList<HomeScreenAdapter>()

    internal lateinit var views: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        views = inflater.inflate(R.layout.fragment_beranda, container, false)

        activity!!.title = "Selamat Datang"

        return views
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeAdapter.add(HomeScreenAdapter("Wisata Alam", R.drawable.alam))
        homeAdapter.add(HomeScreenAdapter("Wisata Pantai", R.drawable.pantai))
        homeAdapter.add(HomeScreenAdapter("Wisata Sejarah", R.drawable.sejarah))
        homeAdapter.add(HomeScreenAdapter("Wisata Kuliner", R.drawable.kuliner))
        adapter = ImageAdapter(context!!.applicationContext, homeAdapter)

        gvWisata.adapter = adapter
        gvWisata.setOnItemClickListener { parent, view, position, id ->
            if (position == 0) {
                //Toast.makeText(this, "Anda memilih: 0",Toast.LENGTH_SHORT).show()
                val intent = Intent(context!!.applicationContext, ActivityWisataAlam::class.java)
                startActivity(intent)
            } else if (position == 1) {
//                Toast.makeText(this, "Anda memilih: 1", Toast.LENGTH_SHORT).show()
                val intent = Intent(context!!.applicationContext, ActivityWisataPantai::class.java)
                startActivity(intent)
            } else if (position == 2) {
                //Toast.makeText(this, "Anda memilih: 2", Toast.LENGTH_SHORT).show()
                val intent = Intent(context!!.applicationContext, ActivityWisataSejarah::class.java)
                startActivity(intent)
            } else if (position == 3) {
//                Toast.makeText(this, "Anda memilih: 3", Toast.LENGTH_SHORT).show()
                val intent = Intent(context!!.applicationContext, ActivityWisataKuliner::class.java)
                startActivity(intent)
            }
        }
//        imgList.alpha = 0.7F
    }

    class ImageAdapter : BaseAdapter {
        var homeAdapter = ArrayList<HomeScreenAdapter>()
        var context: Context? = null

        constructor(context: Context, homeAdapter: ArrayList<HomeScreenAdapter>) : super() {
            this.context = context
            this.homeAdapter = homeAdapter
        }

        override fun getCount(): Int {
            return homeAdapter.size
        }

        override fun getItem(position: Int): Any {
            return homeAdapter[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val list = this.homeAdapter[position]

            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var homeView = inflator.inflate(R.layout.layout_adapter, null)
            homeView.imgList.setImageResource(list.image!!)
            homeView.tvName.text = list.name!!

            return homeView
        }
    }
}

