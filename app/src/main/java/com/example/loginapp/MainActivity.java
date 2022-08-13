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

public class MainActivity extends AppCompatActivity {
    EditText email,password;
    Button login;
    TextView reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.email_login);
        password=findViewById(R.id.password_login);
        login=findViewById(R.id.button_login);
        reg=findViewById(R.id.to_register);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i1);
                finish();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                varifyLogin();
            }
        });
    }

    private void varifyLogin() {
        String semail,spassword;
        int ec=0,pc=0;
        semail=email.getText().toString();
        spassword=password.getText().toString();

        if (semail.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(semail).matches()){
            email.setError("INVALID EMAIL-ID");
            ec=0;
        }
        else {
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
        if(pc==1 && ec==1 && semail.contentEquals("xyz123@gmail.com") && spassword.contentEquals("12345678")){
            Intent i=new Intent(MainActivity.this,Welcome.class);
            startActivity(i);
            finish();
        }
        else{
            Toast.makeText(MainActivity.this,"LOGIN FAILED!!",Toast.LENGTH_SHORT).show();
        }
    }
}