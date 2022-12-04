package com.example.pardue_inventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

public class Delete extends AppCompatActivity {

    DBmenuHelper db;
    private Button delete, back;
    private EditText id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);
        delete = (Button) findViewById(R.id.deleteButton);
        id = (EditText) findViewById(R.id.editTextID);
        db = new DBmenuHelper(this);
        back = (Button) findViewById(R.id.Backview);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CRUDmenu.class);
                startActivity(intent);
            }
        });

        delete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Integer deletedRows = db.deleteData(id.getText().toString());
                        //verifies if deleted successfully.
                        if (deletedRows > 0)
                            Toast.makeText(Delete.this, "Data Deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Delete.this, "Data Not Deleted", Toast.LENGTH_LONG).show();
                    }
                }


        );

    }



}





