package com.example.pardue_inventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CRUDmenu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crudmenu);

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
                    Intent look = new Intent(CRUDmenu.this, GridActivity3.class);
                    startActivity(look);
                    break;
                case R.id.AddInventory:
                    Intent add = new Intent(CRUDmenu.this, Add.class);
                    startActivity(add);
                    break;
                case R.id.UpdateInventory:
                    Intent update = new Intent(CRUDmenu.this, Update.class);
                    startActivity(update);
                    break;
                case R.id.DeleteInventory:
                    Intent delete = new Intent(CRUDmenu.this, DeleteActivity2.class);
                    startActivity(delete);
                    break;
                case R.id.Logout:
                    Intent logout = new Intent(CRUDmenu.this, MainLogin.class);
                    startActivity(logout);
                    break;
            }

        }
    };

}