package com.example.gestiondesarticles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Liste extends AppCompatActivity {
    MyDB myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);

        ListView listView = findViewById(R.id.listView);
        myDB = new MyDB(this);

        ArrayList<String> listeData = new ArrayList<>();
        Cursor data = myDB.getList();

        if (data.getCount() == 0) {
            Toast.makeText(this, "La liste est vide", Toast.LENGTH_SHORT).show();
        } else {
            while (data.moveToNext()) {
                // Assuming the data structure is as follows: id (index 0), name (index 1), quantity (index 2), price (index 3)
                String item = "ID: " + data.getString(0) + "\n" +
                        "Name: " + data.getString(1) + "\n" +
                        "Quantity: " + data.getString(2) + "\n" +
                        "Price: " + data.getString(3);
                listeData.add(item);
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listeData);
            listView.setAdapter(adapter);
        }
    }
    public void openMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}