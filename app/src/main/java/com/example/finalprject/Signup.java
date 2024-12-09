package com.example.finalprject;


import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Signup extends AppCompatActivity {

    private EditText edtusername;
    private EditText edtpassword;
    private Button btnToSignUp;
    private EditText edtEmail;
    private String username,password,Email;

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
        password=edtpassword.getText().toString();
        Email = edtEmail.getText().toString();
        username = edtusername.getText().toString();


        btnToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (isPaswordValid())
                    showErrorPasword();
               else if (isInputValid()) {
                   Signupuser();
                   navigateToDataEntry();
                } else {
                    showErrorMessage();
                }

            }
        });

    }





    public void Signupuser (){

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> user = new HashMap<>();
        user.put("UserName", username);
        user.put("Password", password);
        user.put("Email", Email);

// Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });

        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference myRef = database.getReference("user");
        //user = new User(password,username,Email);
        //myRef.setValue(user);
    }

    private void navigateToDataEntry() {
        Intent intent = new Intent(Signup.this, DataEntry.class);
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
