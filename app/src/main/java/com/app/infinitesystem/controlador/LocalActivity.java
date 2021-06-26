package com.app.infinitesystem.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.infinitesystem.R;

public class LocalActivity extends AppCompatActivity {

    private Button btnHome;
    private Button btnSobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);

        btnHome = findViewById(R.id.btnHome3);
        btnSobre = findViewById(R.id.btnSobre3);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaHome = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(telaHome);
            }
        });

        btnSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaSobre = new Intent(getApplicationContext(), SobreActivity.class);
                startActivity(telaSobre);
            }
        });

    }
}