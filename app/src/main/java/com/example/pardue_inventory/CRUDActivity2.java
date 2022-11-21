package com.example.pardue_inventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CRUDActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crudactivity2);

        defineButtons();
    }

    private void defineButtons() {

        findViewById(R.id.View).setOnClickListener(buttonClickListener);
        findViewById(R.id.AddInventory).setOnClickListener(buttonClickListener);
        findViewById(R.id.UpdateInventory).setOnClickListener(buttonClickListener);
        findViewById(R.id.DeleteInventory).setOnClickListener(buttonClickListener);
        findViewById(R.id.Logout).setOnClickListener(buttonClickListener);

    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.View:
                    Intent look = new Intent(CRUDActivity2.this, GridActivity3.class);
                    startActivity(look);
                    break;
                case R.id.AddInventory:
                    Intent add = new Intent(CRUDActivity2.this, AddActivity2.class);
                    startActivity(add);
                    break;
                case R.id.UpdateInventory:
                    Intent update = new Intent(CRUDActivity2.this, UpdateActivity2.class);
                    startActivity(update);
                    break;
                case R.id.DeleteInventory:
                    Intent delete = new Intent(CRUDActivity2.this, DeleteActivity2.class);
                    startActivity(delete);
                    break;
                case R.id.Logout:
                    Intent logout = new Intent(CRUDActivity2.this, MainActivity.class);
                    startActivity(logout);
                    break;
            }

        }
    };

}