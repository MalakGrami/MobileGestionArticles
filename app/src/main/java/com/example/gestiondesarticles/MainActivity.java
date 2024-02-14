package com.example.gestiondesarticles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openListArtcles(View view) {
        Intent intent = new Intent(this, Liste.class);
        startActivity(intent);
    }

    public void openAjouterArtcles(View view) {
        Intent intent = new Intent(this, Ajouter.class);
        startActivity(intent);
    }

    public void openSupprimerArtcles(View view) {
        Intent intent = new Intent(this, Supprimer.class);
        startActivity(intent);
    }
}