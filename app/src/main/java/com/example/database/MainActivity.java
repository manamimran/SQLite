package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
DatabaseHelper db;                               //define database helper
EditText names, phone, address;
Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db =new DatabaseHelper(this);

        names=findViewById(R.id.etname);
        phone=findViewById(R.id.etphone);
        address=findViewById(R.id.etaddress);
        submit=findViewById(R.id.btsubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Boolean check =  db.insertData( names.getText().toString(), phone.getText().toString(), address.getText().toString());

                if( check==true){
                    Toast.makeText(getApplicationContext(),"submit successfully",Toast.LENGTH_SHORT).show();
                }
                else{
                  Toast.makeText(getApplicationContext(),"failure",Toast.LENGTH_SHORT).show();
                }
            }
   });



    }
}