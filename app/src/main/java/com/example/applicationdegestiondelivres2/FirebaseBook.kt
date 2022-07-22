package com.example.applicationdegestiondelivres2

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.ktx.Firebase
import com.google.firebase.firestore.ktx.firestore

interface OnGetBook {
    fun getBooks(books: List<ModelBook>)
}

class FirebaseBook {
    val db = Firebase.firestore
    var listener: OnGetBook? = null

    private fun retrieveBooks(book: List<ModelBook>){
        listener?.getBooks(book)
    }

    fun book(){

        db.collection("Auteurs")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                }
                retrieveBooks(result.documents.map { document ->
                    ModelBook(
                        id = document?.id,
                        bookNom = document?.data?.get("NomBook"),
                        auteurNom = document?.data?.get("NomAuteur"),
                        image = document?.data?.get("Image")
                    )
                })
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
    }
}