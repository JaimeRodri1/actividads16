package com.example.actividads16

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import android.content.ContentValues.TAG

class MainActivity2 : AppCompatActivity() {
    lateinit var gmail2: EditText
    lateinit var Password: EditText
    private lateinit var confirmpassword: EditText
    private lateinit var btnR: Button
    lateinit var Tv2 : TextView
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Tv2 = findViewById(R.id.tv2)
        btnR = findViewById(R.id.boton2)
        gmail2 = findViewById(R.id.nameR)
        Password = findViewById(R.id.contra2)
        confirmpassword = findViewById(R.id.contra2confirm)
        auth = Firebase.auth
        btnR.setOnClickListener { registremely() }
        Tv2.setOnClickListener { val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) }
    }
    private fun registremely(){
        val emeyl2 = gmail2.text.toString()
        val contraemely2 = Password.text.toString()
        val contraemelyC = confirmpassword.text.toString()
        if (emeyl2.isBlank() || contraemely2.isBlank() || contraemelyC.isBlank()){
            Toast.makeText(this, "Faltan datos", Toast.LENGTH_SHORT).show()
            return
        }
        if (contraemely2 != contraemelyC){
            Toast.makeText(this, "La contra esta mal escrita", Toast.LENGTH_SHORT)
                .show()
            return
        }
        auth.createUserWithEmailAndPassword(emeyl2,contraemely2).addOnCompleteListener(this){
            task->
            if (task.isSuccessful){
                Log.d(TAG, "createUserWithEmail:success")
                val user = auth.currentUser
                Toast.makeText(baseContext, "¡Usuario Registrado!",
                    Toast.LENGTH_SHORT).show()
            }
            else{
                Log.w(TAG, "createUserWithEmail:failure", task.exception)
                Toast.makeText(baseContext, "Fallo de Autenticacion",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}