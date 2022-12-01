package com.example.pardue_inventory;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class View_TEST extends AppCompatActivity {

    private Button btnviewAll;
    DBmenuHelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_test);
        myDb = new DBmenuHelper(this);
        btnviewAll = findViewById(R.id.button_viewAll);

    }



}