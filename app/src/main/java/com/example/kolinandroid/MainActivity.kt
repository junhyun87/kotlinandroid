package com.example.kolinandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener {
            // code
            Log.i("MainActivity", "Button was clicked !")

            Toast.makeText(this, "Button was clicked  !", Toast.LENGTH_SHORT).show()
        }

        btnSendMsgToNextActivity.setOnClickListener {
            val message : String = etUserMessage.text.toString()
            Toast.makeText(this, "Second Button was testclicked !", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, SecondAcivity::class.java)

            intent.putExtra( "user_message", message)

            startActivity(intent)

        }

        btnShareToOtherApps.setOnClickListener{

            val message : String = etUserMessage.text.toString()

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Please Select App :  "))

        }

        btnRecyclerViewDemo.setOnClickListener {
            val intent = Intent( this, HobbiesActivity::class.java)
            startActivity(intent)
        }
    }
}
