package com.example.gestiondesarticles;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Supprimer extends AppCompatActivity {

    private MyDB myDB;
    private EditText articleIdEditText;
    private Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supprimer);

        myDB = new MyDB(this);
        articleIdEditText = findViewById(R.id.articleIdEditText);
        deleteButton = findViewById(R.id.deleteButton);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String articleIdString = articleIdEditText.getText().toString().trim();

                if (articleIdString.isEmpty()) {
                    Toast.makeText(Supprimer.this, "Please enter an Article ID", Toast.LENGTH_SHORT).show();
                } else {
                    int articleId = Integer.parseInt(articleIdString);
                    myDB.delete(articleId);
                    Toast.makeText(Supprimer.this, "Article with ID " + articleId + " deleted successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void openMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}