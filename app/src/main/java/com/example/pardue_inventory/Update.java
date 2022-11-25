package com.example.pardue_inventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;

public class Update extends AppCompatActivity {
    private Button backView;
    GridView gridview;
    String[] number = new String[200];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);
        backView = findViewById(R.id.Backview);
        backView.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Update.this, CRUDmenu.class);
                startActivity(intent);
            }
        });

        for(int i = 0; i<number.length; i++) {
            number[i] = " Item " + i ;

        }

        gridview = (GridView) findViewById(R.id.gridView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>( this, android.R.layout.simple_selectable_list_item,number);
        gridview.setAdapter(adapter);

    }
}
