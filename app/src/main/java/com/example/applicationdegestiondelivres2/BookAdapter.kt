package com.example.applicationdegestiondelivres2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.installations.Utils
import com.squareup.picasso.Picasso

class BookAdapter: RecyclerView.Adapter<BookAdapter.MyViewHolder>() {
    var listbook = listOf<ModelBook>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return(MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.book_item, parent, false)
        ))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val createbook : ModelBook = listbook[position]
        holder.bookView.setText(createbook.bookNom.toString())
        holder.auteurView.setText(createbook.auteurNom.toString())
        Picasso.get().load(createbook.image.toString()).into(holder.imageView);
    }

    override fun getItemCount(): Int = listbook.size

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.image)
        val bookView: TextView = itemView.findViewById(R.id.bookNom)
        val auteurView : TextView = itemView.findViewById(R.id.auteurNom)
    }

}