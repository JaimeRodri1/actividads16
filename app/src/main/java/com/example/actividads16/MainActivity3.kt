package com.example.actividads16

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity3 : AppCompatActivity() {
    private  var recyclerView: RecyclerView?=null
    private var recyclerViewAdapter:recycler?=null
    private  var emelyst= mutableListOf<clase>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        //aqui se crea un array donde se contendra la lista de datos
        emelyst= ArrayList()
        recyclerView= findViewById(R.id.array) as RecyclerView
        recyclerViewAdapter= recycler(emelyst)
        val layoutManager: RecyclerView.LayoutManager= LinearLayoutManager(this)
        recyclerView!!.layoutManager=layoutManager
        recyclerViewAdapter!!.setOnItemClickListener(object : ClickListener<clase>{
            override fun onItemClick(data: clase) {
                val dialIntent = Intent(Intent.ACTION_DIAL)
                dialIntent.data = Uri.parse("tel:"+data.nume)
                startActivity(dialIntent)
            }
        })
        recyclerView!!.adapter=recyclerViewAdapter
        bro()
    }
    // aqui hacemos un metodo donde colocamos as nuestros amigos con su descripcion
    private fun bro(){
        var amigos= clase("Juan",R.drawable.juan,"7864-3522")
        emelyst.add(amigos)

        recyclerViewAdapter?.notifyDataSetChanged()

    }
}