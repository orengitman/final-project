package com.example.finalprject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Masteruser extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private ArrayList<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masteruser);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        userList = new ArrayList<>();
        userList.add(new User("userD", "userD@dd.dd", "000000000"));
        userList.add(new User("userC", "userC@cc.cc", "000000000"));
        userList.add(new User("chad", "chad@000.000", "000000000"));

        userAdapter = new UserAdapter(userList);
        recyclerView.setAdapter(userAdapter);
    }
}