package com.example.finalprject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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
    private void navigateToDataEntry() {
        Intent intent = new Intent(Masteruser.this, DataEntry.class);
        startActivity(intent);
    }

    private void navigateToGameList() {
        Intent intent = new Intent(Masteruser.this, GameLIst.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menuDataEntry:
                navigateToDataEntry();
            case R.id.menuGameList:
                navigateToGameList();



        }
        return false;
    }
}