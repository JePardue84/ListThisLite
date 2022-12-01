package com.example.pardue_inventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class Delete extends AppCompatActivity {

    GridView gridview;
    String[] number = new String[200];

    private void defineButtons() {

        findViewById(R.id.deleteButton).setOnClickListener(buttonClickListener);
        findViewById(R.id.Backview).setOnClickListener(buttonClickListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);
        defineButtons();

        for (int i = 0; i < number.length; i++) {
            number[i] = " Item " + i;

        }

        gridview = (GridView) findViewById(R.id.gridView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_selectable_list_item, number);
        gridview.setAdapter(adapter);

        };

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.deleteButton:
                    Intent delete = new Intent(Delete.this, Delete.class);
                    startActivity(delete);
                    break;
                case R.id.Backview:
                    Intent back = new Intent(Delete.this, CRUDmenu.class);
                    startActivity(back);
                    break;

            }

        }


    };
}
