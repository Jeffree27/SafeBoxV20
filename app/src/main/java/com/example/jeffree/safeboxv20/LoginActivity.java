package com.example.jeffree.safeboxv20;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText user;
    EditText pass;
    Button login_btn;
    int counter = 5;
    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (EditText)findViewById(R.id.username);
        pass = (EditText)findViewById(R.id.password);
        login_btn = (Button)findViewById(R.id.login);
        spinner = (ProgressBar)findViewById(R.id.progressBar) ;

        login_btn.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             spinner.setVisibility(spinner.VISIBLE);
                                             if (user.getText().toString().equals("admin") && pass.getText().toString().equals("admin")) {
                                                 Handler handler = new Handler() {
                                                     @Override
                                                     public void handleMessage(Message msg) {
                                                         spinner.setVisibility(spinner.GONE);
                                                         Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
                                                         startActivity(loginIntent);
                                                         finish();
                                                     }
                                                 };
                                                 handler.sendEmptyMessageDelayed(0, 2500);
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

