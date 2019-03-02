package com.example.jeffree.safeboxv20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText user;
    EditText pass;
    Button login_btn;
    int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (EditText)findViewById(R.id.username);
        pass = (EditText)findViewById(R.id.password);
        login_btn = (Button)findViewById(R.id.login);

        login_btn.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {

                                             if (user.getText().toString().equals("admin") && pass.getText().toString().equals("admin")) {
                                                 Toast.makeText(getApplicationContext(), "Welcome to SAFEBOX", Toast.LENGTH_SHORT).show();
                                                 Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
                                                 startActivity(loginIntent);
                                                 finish();
                                             } else {
                                                 Toast.makeText(getApplicationContext(), "Sorry! Username or Password is incorrect.", Toast.LENGTH_SHORT).show();

                                                 counter--;
                                                 if (counter == 0) {
                                                     Toast.makeText(getApplicationContext(), "Sorry! You have entered wrong credentials five times.", Toast.LENGTH_SHORT).show();
                                                     login_btn.setEnabled(false);
                                                 }
                                             }
                                         }
                                     }
        );



}
    }