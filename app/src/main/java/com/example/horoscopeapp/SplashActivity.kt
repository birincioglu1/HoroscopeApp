package com.example.horoscopeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onResume() {

        var logoDondurAnimasyon= AnimationUtils.loadAnimation(this,R.anim.rotate)

        imgLogo.animation=logoDondurAnimasyon

        object : CountDownTimer(6000, 1000){

            override fun onFinish() {
                var intent= Intent(this@SplashActivity, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                this@SplashActivity.overridePendingTransition(0,0)
                startActivity(intent)
                this@SplashActivity.finish()
            }

            override fun onTick(millisUntilFinished: Long) {

            }


        }.start()
        super.onResume()
    }
}