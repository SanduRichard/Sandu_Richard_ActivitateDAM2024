package com.example.seminar9;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class cautareOras extends AppCompatActivity {
    private static final String API_KEY = "yLui0AF1KAGJLpR0821tE6r5wXAqiKyQ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cautare);

        EditText oras = findViewById(R.id.et_nume_oras); // EditText for entering city name
        Button cautareButon = findViewById(R.id.btn_cauta_oras); // Button for search

        cautareButon.setOnClickListener(v -> {
            String numeOras = oras.getText().toString().trim(); // Get city name from EditText
            if (!numeOras.isEmpty()) {
                codulOrasului(numeOras); // Call the method to fetch the city code
            } else {
                Toast.makeText(this, "Introduceți numele orașului", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void codulOrasului(String numeOras) {
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... voids) {
                try {

                    String urlString = "http://dataservice.accuweather.com/locations/v1/cities/search?apikey="
                            + API_KEY + "&q=" + numeOras;

                    URL url = new URL(urlString);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");

                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }
                    reader.close();


                    JSONArray jsonArray = new JSONArray(result.toString());
                    if (jsonArray.length() > 0) {
                        JSONObject cityData = jsonArray.getJSONObject(0);
                        return cityData.getString("Key");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String cityCode) {
                if (cityCode != null) {

                    Toast.makeText(cautareOras.this, "Cod oraș: " + cityCode, Toast.LENGTH_LONG).show();
                } else {

                    Toast.makeText(cautareOras.this, "Orașul nu a fost găsit!", Toast.LENGTH_SHORT).show();
                }
            }
        }.execute();
    }
}
