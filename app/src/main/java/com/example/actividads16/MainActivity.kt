package com.example.actividads16

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var tv: TextView
    lateinit var gmail: EditText
    private lateinit var etpassword: EditText
    lateinit var iniciar: Button
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.Tv)
        iniciar = findViewById(R.id.boton)
        gmail = findViewById(R.id.name)
        etpassword = findViewById(R.id.contra)
        auth = FirebaseAuth.getInstance()
        iniciar.setOnClickListener { sesion() }
        tv.setOnClickListener { val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish() }
    }
    private fun sesion(){
        val emeyl = gmail.text.toString()
        val contraemeyl = etpassword.text.toString()
        auth.signInWithEmailAndPassword(emeyl,contraemeyl).addOnCompleteListener(this){
            if (it.isSuccessful){
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity3::class.java)
                startActivity(intent)
                finish()
            }
            else
                Toast.makeText(this, "Denegate", Toast.LENGTH_SHORT).show()
        }
    }
}