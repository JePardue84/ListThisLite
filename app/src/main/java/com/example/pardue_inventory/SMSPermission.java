package com.example.pardue_inventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SMSPermission extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smspermission);

        defineButtons();
    }

    private void defineButtons() {

        findViewById(R.id.Deny).setOnClickListener(buttonClickListener);
        findViewById(R.id.Allow).setOnClickListener(buttonClickListener);

    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.Deny:
                    Intent look = new Intent(SMSPermission.this, CRUDmenu.class);
                    startActivity(look);
                    break;
                case R.id.Allow:
                    Intent logout = new Intent(SMSPermission.this, CRUDmenu.class);
                    startActivity(logout);
                    break;
            }
        }
    };

}