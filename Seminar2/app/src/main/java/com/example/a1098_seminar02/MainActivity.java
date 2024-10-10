package com.example.a1098_seminar02;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Log.d("Activitate", "OnCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Activitate", "OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w("Activitate", "OnResume");
        Toast.makeText(this,R.string.Mesaj, Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Activitate", "OnPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Activitate", "OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("Activitate", "OnDestroy");
    }


}