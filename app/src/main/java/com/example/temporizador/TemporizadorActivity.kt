package com.example.temporizador

import android.app.Activity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView

class TemporizadorActivity : Activity() {

    private var timer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temporizador)

        val textoTiempo = findViewById<TextView>(R.id.textoTiempo)

        findViewById<Button>(R.id.botonIniciar).setOnClickListener {
            timer?.cancel()
            timer = object : CountDownTimer(10000, 1000) {
                override fun onTick(ms: Long) {
                    textoTiempo.text = ((ms + 999) / 1000).toString()
                }

                override fun onFinish() {
                    textoTiempo.text = "Terminado"
                }
            }.start()
        }

        findViewById<Button>(R.id.botonVolver).setOnClickListener {
            finish()
        }
    }

    override fun onDestroy() {
        timer?.cancel()
        super.onDestroy()
    }
}
