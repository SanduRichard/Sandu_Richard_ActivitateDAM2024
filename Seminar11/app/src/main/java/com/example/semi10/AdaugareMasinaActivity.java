package com.example.semi10;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class AdaugareMasinaActivity extends AppCompatActivity {

    private MasinaDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaugare_masina);

        database = MasinaDatabase.getDatabase(this);

        EditText marcaEditText = findViewById(R.id.editTextMarca);
        EditText modelEditText = findViewById(R.id.editTextModel);
        EditText anEditText = findViewById(R.id.editTextAn);
        Button saveButton = findViewById(R.id.buttonSave);

        saveButton.setOnClickListener(v -> {
            String marca = marcaEditText.getText().toString();
            String model = modelEditText.getText().toString();
            int anFabricatie = Integer.parseInt(anEditText.getText().toString());

            Masina masina = new Masina(marca, model, anFabricatie, true);

            new Thread(() -> {
                database.masinaDao().insert(masina);
                runOnUiThread(() -> Toast.makeText(this, "Masina adaugata!", Toast.LENGTH_SHORT).show());
            }).start();
        });
    }
}
