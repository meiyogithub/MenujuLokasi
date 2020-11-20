package com.example.android.petamenujulokasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        Button btn_navigasi;
        String goolgeMap = "com.google.android.apps.maps";
        Uri gmmIntentUri;
        Intent mapIntent;
        String rumahSaya = "-6.166234, 107.000954";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            btn_navigasi = (Button) findViewById(R.id.btn_navigasi);
            btn_navigasi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gmmIntentUri = Uri.parse("google.navigation:q=" + rumahSaya);
                    mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage(goolgeMap);
                    if (mapIntent.resolveActivity(getPackageManager()) != null) {
                        startActivity(mapIntent);
                    } else {
                        Toast.makeText(MainActivity.this, "Google Maps Belum Terinstal. Install Terlebih dahulu.", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
}