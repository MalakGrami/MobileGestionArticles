package com.example.gestiondesarticles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ajouter extends AppCompatActivity {

    MyDB myDB; // Assuming you have already defined MyDB class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter);

        myDB = new MyDB(this); // Initialize MyDB instance

        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouterArticle();
            }
        });
    }

    private void ajouterArticle() {
        EditText articleNameEditText = findViewById(R.id.articleNameEditText);
        EditText quantityEditText = findViewById(R.id.quantityEditText);
        EditText priceEditText = findViewById(R.id.priceEditText);

        String articleName = articleNameEditText.getText().toString().trim();
        int quantity = Integer.parseInt(quantityEditText.getText().toString().trim());
        float price = Float.parseFloat(priceEditText.getText().toString().trim());

        // Call ajouter method from MyDB class to add the article
        myDB.ajouter(articleName, quantity, price);

        Toast.makeText(this, "Article added successfully", Toast.LENGTH_SHORT).show();
    }
    public void openMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}