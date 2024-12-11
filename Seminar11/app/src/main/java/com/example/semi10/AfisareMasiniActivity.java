package com.example.semi10;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class AfisareMasiniActivity extends AppCompatActivity {

    private MasinaDatabase database; // Use the correct type here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afisare_masini);

        ListView listView = findViewById(R.id.listViewMasini);
        database = MasinaDatabase.getDatabase(this);

        new Thread(() -> {
            List<Masina> masini = database.masinaDao().getAllMasini();
            runOnUiThread(() -> {
                ArrayAdapter<Masina> adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, masini);
                listView.setAdapter(adapter);
            });
        }).start();
    }
}
