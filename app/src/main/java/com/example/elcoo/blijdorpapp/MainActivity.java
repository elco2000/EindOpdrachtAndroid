package com.example.elcoo.blijdorpapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        SQLiteDatabase blijdorpDB = this.openOrCreateDatabase("blijdorpDB", MODE_PRIVATE, null);
//
//        File dbFile = getDatabasePath("blijdorpDB");
//        if(dbFile.exists()) {
//            Log.i("Database", "bestaat");
//        } else {
//            Log.i("Database", "bestaat niet");
//        }
//
//        blijdorpDB.execSQL("CREATE TABLE IF NOT EXISTS "
//                + "animal"
//                + " (Id INTEGER, Name VARCHAR, Description VARCHAR );");
//
//        blijdorpDB.execSQL("INSERT INTO "
//        + "animal"
//        + " (Id, Name, Description)"
//        + " VALUES (0 ,'vissen', 'Vissen zijn in het water levende gewervelde dieren die in de regel ademhalen met kieuwen')");


//        Cursor c = blijdorpDB.rawQuery("SELECT * FROM animal WHERE Name = 'Vissen'",
//                null);
//        int Column1 = c.getColumnIndex("Name");
//        int Column2 = c.getColumnIndex("Description");
//        c.moveToLast();
//        String Name = c.getString(Column1);
//        String Description = c.getString(Column2);
//        Log.i("Dier: " , Name + ": " + Description);
    }

    public void onClickMaps(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void onClickRoutes(View view) {
        Intent intent = new Intent(this, RoutesActivity.class);
        startActivity(intent);
    }
}
