package com.example.semi10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_adaugare = findViewById(R.id.btn_adaugare);
        Button btn_afisare = findViewById(R.id.btn_afisare);

        btn_adaugare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to AdaugareMasinaActivity
                Intent intent = new Intent(MainActivity.this, AdaugareMasinaActivity.class);
                startActivity(intent);
            }
        });

        btn_afisare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to AfisareMasiniActivity
                Intent intent = new Intent(MainActivity.this, AfisareMasiniActivity.class);
                startActivity(intent);
            }
        });
    }
}
