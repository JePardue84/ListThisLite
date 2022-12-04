package com.example.pardue_inventory;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

public class Delete extends AppCompatActivity {

    DBmenuHelper db;
    private Button delete, back, view;
    private EditText id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);
        delete = (Button) findViewById(R.id.deleteButton);
        id = (EditText) findViewById(R.id.editTextID);
        db = new DBmenuHelper(this);
        back = (Button) findViewById(R.id.Backview);
        view = (Button) findViewById(R.id.buttonViewALL);

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

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = db.getAlldata();
                if(cursor.getCount()==0){
                    Toast.makeText(Delete.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(cursor.moveToNext()){
                    buffer.append("Id :"+cursor.getString(0)+"\n");
                    buffer.append("Name :"+cursor.getString(1)+"\n");
                    buffer.append("Supplier :"+cursor.getString(2)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(Delete.this);
                builder.setCancelable(true);
                builder.setTitle("Inventory Items");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });


    }



}





