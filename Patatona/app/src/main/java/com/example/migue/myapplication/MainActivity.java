package com.example.migue.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {
    Button bt;
    public Firebase Nref;
    EditText Enombre;
    EditText Epassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
//hijoetureputisimamadre ahi muere vato

        Nref= new Firebase("https://trabajo-roy.firebaseio.com/");

        Enombre=(EditText) findViewById(R.id.edit);
        Epassword=(EditText) findViewById(R.id.EdPass);
        bt=(Button) findViewById(R.id.sendData);
        bt.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                adduser();
            }
        });


    }

    private void adduser() {
        String nombre=Enombre.getText().toString().trim();
        String password=Epassword.getText().toString().trim();
        if (!TextUtils.isEmpty(nombre)){
            if (!TextUtils.isEmpty(password)){
                String id=Nref.push().getKey();
                Users us=new Users(nombre, password);
                Firebase nRefChild=Nref.child(id);
                nRefChild.setValue(us);

                Toast.makeText(this,"User created", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"Please enter a password", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this,"Please enter your name", Toast.LENGTH_LONG).show();
        }



    }
}
