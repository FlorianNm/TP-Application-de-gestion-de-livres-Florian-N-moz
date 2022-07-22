package com.example.applicationdegestiondelivres2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val loginListner =  { view: View -> onLoginClick(view) }
    private val registerListner = { view: View -> registerClick(view) }
    private lateinit var auth: FirebaseAuth


    lateinit var ChanpEmail: EditText
    lateinit var ChanpPassword: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Initialize Firebase Auth
        auth = Firebase.auth

        val ButtonConnection = findViewById<Button>(R.id.button_connection)
        val ButtonInscription = findViewById<Button>(R.id.button_inscription)
        ChanpEmail = findViewById(R.id.TextEmailAddress)
        ChanpPassword = findViewById(R.id.TextPassword)

        ButtonConnection.setOnClickListener {
            val email = ChanpEmail.text.toString()
            val mdp = ChanpPassword.text.toString()
            if(email.isNotEmpty() && mdp.isNotEmpty()) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email,mdp)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val intent = Intent(this@MainActivity, EcranPrincipal::class.java)
                            startActivity(intent)
                            finish()
                        }
                        else {
                            Toast.makeText(
                                this@MainActivity,
                                "L'email ou le mot de passe est incorrect",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    }
            }
            else{
                Toast.makeText(
                    this@MainActivity,
                    "Veuillez remplir les champs",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        ButtonInscription.setOnClickListener {
            val intent = Intent(this@MainActivity, EcranInscription::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    private fun onLoginClick(it: View) {

    }

    private fun registerClick(it: View){

    }
}