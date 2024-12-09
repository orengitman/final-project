package com.example.finalprject;


import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {

    private EditText edtusername;
    private EditText edtpassword;
    private Button btnToSignUp;
    private EditText edtEmail;

    private User user;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        edtpassword = findViewById(R.id.edtPassword);
        edtusername = findViewById(R.id.edtUsername);
        edtEmail = findViewById(R.id.edtEmail);

        btnToSignUp = findViewById(R.id.btnToSignUp);

        btnToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (isPaswordValid())
                    showErrorPasword();
               else if (isInputValid()) {
                   saveuser(view);
                    //navigateToGameList();
                } else {
                    showErrorMessage();
                }

            }
        });

    }



    public void saveName(View view){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("user");
        myRef.setValue(edtusername.getText().toString());
    }

    public void savepassword(View view){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("user");
        myRef.setValue(edtpassword.getText().toString());
    }

    public void saveEmail(View view){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("user");
        myRef.setValue(edtEmail.getText().toString());
    }

    public void saveuser (View view){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("user");
        user = new User(edtpassword.getText().toString(),edtusername.getText().toString()
        ,edtEmail.getText().toString());
        myRef.setValue(user);
    }

    private void navigateToGameList() {
        Intent intent = new Intent(Signup.this, GameLIst.class);
        startActivity(intent);
    }



    private boolean isInputValid() {
        return (!edtpassword.getText().toString().trim().isEmpty())&&(!edtusername.getText().toString().trim().isEmpty()&&
                (!edtEmail.getText().toString().trim().isEmpty()));
    }


    private void showErrorMessage() {
        Toast.makeText(this, "לא מילאת את אחד מהשדות", Toast.LENGTH_SHORT).show();
    }
    private void showErrorPasword() {
        Toast.makeText(this, "הסיסמה לא תקינה", Toast.LENGTH_SHORT).show();
    }
    private boolean isPaswordValid() {
        return !(8 > edtpassword.getText().length() && 3 < edtpassword.getText().length());
    }


    }
