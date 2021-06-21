package com.app.infinitesystem.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.app.infinitesystem.R;

public class Splash extends AppCompatActivity {

    String TAG = "Meu App";
    int tempoDeEspera = 1000 * 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Log.d(TAG, "trocarTela: Tels Splash carregada...");

        trocarTela();
    }

    public void trocarTela(){

        Log.d(TAG, "trocarTela: Mudando para tela principal...");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Log.d(TAG, "trocarTela: Esperando o tempo...");

                Intent trocarDeTela = new Intent(Splash.this, Login.class);
                startActivity(trocarDeTela);
                finish();

            }
        },tempoDeEspera);

    }
}