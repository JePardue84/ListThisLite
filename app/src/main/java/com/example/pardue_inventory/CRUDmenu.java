package com.example.pardue_inventory;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CRUDmenu extends AppCompatActivity {

    DBmenuHelper myDb;
    private Button view, logout, addInventory,updateInventory,deleteInventory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crudmenu);

        addInventory = (Button) findViewById(R.id.AddInventory);
        logout = (Button) findViewById(R.id.Logout);
        view = (Button) findViewById(R.id.buttonViewALL);
        addInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdd();
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openView();
            }
        });
    }

    public void openAdd() {
        Intent intent = new Intent(this, Add.class);
        startActivity(intent);
    }

    public void logout() {
        Intent intent = new Intent(this, MainLogin.class);
        startActivity(intent);
    }

    public void openView() {
        Intent intent = new Intent(this, View_TEST.class);
        startActivity(intent);
    }



}


