package com.pseudo.open2you

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class SplashActvity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, MainActivity().javaClass))
        finish()
    }
}
