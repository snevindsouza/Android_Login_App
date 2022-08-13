package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText email,password,name, phone;
    Button register;
    TextView log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        email=findViewById(R.id.email_register);
        password=findViewById(R.id.password_register);
        name=findViewById(R.id.name_register);
        phone=findViewById(R.id.phone_register);
        register=findViewById(R.id.button_register);
        log=findViewById(R.id.to_login);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(i2);
                finish();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifySignUp();
            }
        });
    }

    private void verifySignUp() {
        String semail,spassword,sname,sphone;
        int pc=0,ec=0,nc=0,phc=0;

        semail=email.getText().toString();
        sname=name.getText().toString();
        sphone=phone.getText().toString();
        spassword=password.getText().toString();

        if(semail.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(semail).matches()){
            email.setError("INVALID EMAIL-ID");
            ec=0;
        }
        else{
            email.setError(null);
            ec=1;
        }
        if(spassword.isEmpty() || spassword.length()<8){
            password.setError("INVALID PASSWORD");
            pc=0;
        }
        else{
            password.setError(null);
            pc=1;
        }
        if(sname.isEmpty() || sname.length()<6){
            name.setError("INVAILD NAME");
            nc=0;
        }
        else{
            name.setError(null);
            nc=1;
        }
        if(sphone.isEmpty() || sphone.length()!=10){
            phone.setError("INVALID PHONE NUMBER");
            phc=0;
        }
        else{
            phone.setError(null);
            phc=1;
        }

        if(ec==1 && phc==1 && nc==1 && pc==1){
            Intent reg=new Intent(MainActivity2.this,Welcome.class);
            startActivity(reg);
            finish();
        }
        else{
            Toast.makeText(MainActivity2.this,"REGISTER FAILED!!", Toast.LENGTH_SHORT).show();
        }
    }
}