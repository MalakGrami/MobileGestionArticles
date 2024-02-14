package com.example.gestiondesarticles;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDB extends SQLiteOpenHelper {
    private static final String dbName = "article";
    private static final int dbVersion = 1;
    private static final String tabelName = "articles";
    private static final String idCol = "id";
    private static final String nameCol = "name";
    private static final String quantiteCol = "quantite";
    private static final String prixCol = "prix";

    public MyDB(Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + tabelName + "(" + idCol + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + nameCol + " TEXT, "
                + quantiteCol + " INTEGER, "
                + prixCol + " REAL)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tabelName);
        onCreate(db);
    }

    public void ajouter(String nom, int quantite, float prix) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(nameCol, nom);
        values.put(quantiteCol, quantite);
        values.put(prixCol, prix);
        db.insert(tabelName, null, values);
        db.close();
    }

    public void delete(int articleId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tabelName, idCol + "=?", new String[]{String.valueOf(articleId)});
        db.close();
    }

    public Cursor getList() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + tabelName, null);
    }
}
