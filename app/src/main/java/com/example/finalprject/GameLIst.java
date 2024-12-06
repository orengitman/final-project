package com.example.finalprject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class GameLIst extends AppCompatActivity {
    private RecyclerView gamesRecyclerView;
    private GameAdapter gameAdapter;
    private  List<ScouterGame> games = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);

        // Initialize RecyclerView
        gamesRecyclerView = findViewById(R.id.gamesRecyclerView);
        gamesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize game list
        // Add sample data
        games.add(new ScouterGame(2, 1690, "blue"));
        games.add(new ScouterGame(3, 11, "blue"));
        games.add(new ScouterGame(5, 1690, "blue"));
        games.add(new ScouterGame(6, 1690, "red"));

        // Initialize and set adapter
        gameAdapter = new GameAdapter((ArrayList<ScouterGame>) games);
        gamesRecyclerView.setAdapter(gameAdapter);
    }

    private void navigateToDataEntry() {
        Intent intent = new Intent(GameLIst.this, DataEntry.class);
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


        }
        return false;
    }
}
