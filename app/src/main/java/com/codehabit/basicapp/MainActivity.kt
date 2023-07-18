package com.codehabit.basicapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        if(intent.action == Intent.ACTION_SEND){
            val monster = intent?.getStringExtra(Intent.EXTRA_TEXT)
            Log.i("Intent","You Selected monster $monster")
            val monsterId = resources.getIdentifier(monster?.trim(),"drawable", packageName)
            imageView2.setImageResource(monsterId)
            return
        }
        Log.i("Intents","Action =${intent.action}")
        val lastPart = intent.data?.lastPathSegment
        if(lastPart!!.equals("view")){
            val monsterId = intent.data?.getQueryParameter("id")
            Log.i("Intents","Query parameter =$monsterId")
        }

        val extraId = intent.extras!!.getInt("monsterId")
        Log.i("Intents","Extra value =$extraId")

        imageView2.setImageResource(extraId)
    }
}