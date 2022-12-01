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

public class Add extends AppCompatActivity {

    DBmenuHelper myDb;
    private Button ViewInventory, btnAddData;
    private EditText editName, editSupplier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        myDb = new DBmenuHelper(this);

        editName = (EditText) findViewById(R.id.ItemLine1);
        editSupplier = (EditText) findViewById(R.id.ItemLine2);
        btnAddData = (Button) findViewById(R.id.button_add);
        ViewInventory =(Button) findViewById(R.id.viewInventory);
        AddData();
        ViewInventory();
        ViewInventory.setOnClickListener(new android.view.View.OnClickListener()

        {
            @Override
            public void onClick (View view){
                Intent intent = new Intent(Add.this, ViewInventory.class);
                startActivity(intent);
            }
        });
    }

    //Inserts data into Inventory.db
    public void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        boolean isInserted = myDb.insertData(editName.getText().toString(),
                                editSupplier.getText().toString());

                        //verifies if added successfully.
                        if (isInserted = true)
                            Toast.makeText(Add.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Add.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                }


        );


        ViewInventory.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Add.this, ViewInventory.class);
                startActivity(intent);
            }
        });


    }

    public void ViewInventory() {
        ViewInventory.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor cursor = myDb.getAlldata();
                        if (cursor.getCount() == 0) {
                            //show message
                            showMessage("Error", "No Items Found");
                            return;

                        }

                        StringBuffer buffer = new StringBuffer();
                        while (cursor.moveToNext()) {
                            buffer.append("Name :" + cursor.getString(0) + "\n");
                            buffer.append("Supplier :" + cursor.getString(1) + "\n\n");

                        }

                        //Show all data
                        showMessage("Item", buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}