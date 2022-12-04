package com.example.pardue_inventory;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CRUDmenu extends AppCompatActivity {

    DBmenuHelper DB;
    private Button view, logout, addInventory,updateInventory,deleteInventory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crudmenu);

        DB = new DBmenuHelper(this);

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
            public void onClick(View view) {
                Cursor cursor = DB.getAlldata();
                if(cursor.getCount()==0){
                    Toast.makeText(CRUDmenu.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(cursor.moveToNext()){
                    buffer.append("Id :"+cursor.getString(0)+"\n");
                    buffer.append("Name :"+cursor.getString(1)+"\n");
                    buffer.append("Supplier :"+cursor.getString(2)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(CRUDmenu.this);
                builder.setCancelable(true);
                builder.setTitle("Inventory Items");
                builder.setMessage(buffer.toString());
                builder.show();
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





}


