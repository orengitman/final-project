package com.example.finalprject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button btnLogIn;
    private Button btnRegister;
    private EditText edtusername;
    private EditText edtpasword;

    private User user;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtpasword = findViewById(R.id.edtPassword);
        edtusername = findViewById(R.id.edtUsername);

        btnLogIn = findViewById(R.id.btnlogin);
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPaswordValid())
                    showErrorPasword();
                else if (isInputValid()) {
                    navigateToDataEntry();
                } else {
                    showErrorMessage();
                }

            }
        });


        btnRegister = findViewById(R.id.btnToSignUp);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToSignupActivity();
            }
        });
    }


    private void navigateToSignupActivity() {
        Intent intent = new Intent(MainActivity.this, Signup.class);
        startActivity(intent);
    }



    private boolean isInputValid() {
        return (!edtpasword.getText().toString().trim().isEmpty())&&(!edtusername.getText().toString().trim().isEmpty());
    }


    private void showErrorMessage() {
        Toast.makeText(this, "לא מילאת את אחד מהשדות", Toast.LENGTH_SHORT).show();
    }
    private void showErrorPasword() {
        Toast.makeText(this, "הסיסמה לא תקינה", Toast.LENGTH_SHORT).show();
    }
    private boolean isPaswordValid() {

        return !(8 > edtpasword.getText().length() && 3 < edtpasword.getText().length());
    }
    private void navigateTodataentry() {
        Intent intent = new Intent(MainActivity.this, DataEntry.class);
        startActivity(intent);
    }

    private void navigateToDataEntry() {
        Intent intent = new Intent(MainActivity.this, DataEntry.class);
        startActivity(intent);
    }

}
