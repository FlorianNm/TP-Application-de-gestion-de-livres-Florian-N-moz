package com.example.applicationdegestiondelivres2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EcranPrincipal:AppCompatActivity(), View.OnClickListener, OnGetBook {

    var adapter : BookAdapter? = null
    val db = FirebaseBook()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db.listener = this
        db.book()
        setContentView(R.layout.ecran_principal)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        adapter = BookAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this@EcranPrincipal)
        recyclerView.adapter = adapter
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    override fun getBooks(books: List<ModelBook>) {
        adapter?.listbook = books
        adapter?.notifyDataSetChanged()
    }
}