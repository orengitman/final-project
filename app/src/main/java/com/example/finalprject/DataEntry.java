package com.example.finalprject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DataEntry extends AppCompatActivity {
        private EditText gameInput, teamInput, notesInput;
        private TextView autonomousScore, teleopScore, penaltyScore;
        private Button sendButton;
        private int autonomousCount = 0;
        private int teleopCount = 0;
        private int penaltyCount = 0;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_data_entry);

            // Initialize EditText fields
            gameInput = findViewById(R.id.gameInput);
            teamInput = findViewById(R.id.teamInput);
            notesInput = findViewById(R.id.notesInput);

            // Initialize Score TextViews
            autonomousScore = findViewById(R.id.autonomousScore);
            teleopScore = findViewById(R.id.teleopScore);
            penaltyScore = findViewById(R.id.penaltyScore);

          //  Button autonomousMinusBtn = findViewById(R.id.autonomousMinusBtn);
          //  Button autonomousPlusBtn = findViewById(R.id.autonomousPlusBtn);
          //  Button teleopMinusBtn = findViewById(R.id.teleopMinusBtn);
          //  Button teleopPlusBtn = findViewById(R.id.teleopPlusBtn);
          //   Button penaltyMinusBtn = findViewById(R.id.penaltyMinusBtn);
          //  Button penaltyPlusBtn = findViewById(R.id.penaltyPlusBtn);
            sendButton = findViewById(R.id.sendButton);

            // Set up counter buttons
            setupCounterButtons();

            // Set up send button
            setupSendButton();
        }

        private void setupCounterButtons() {
            Button autonomousMinusBtn = findViewById(R.id.autonomousMinusBtn);
            Button autonomousPlusBtn = findViewById(R.id.autonomousPlusBtn);
            Button teleopMinusBtn = findViewById(R.id.teleopMinusBtn);
            Button teleopPlusBtn = findViewById(R.id.teleopPlusBtn);
            Button penaltyMinusBtn = findViewById(R.id.penaltyMinusBtn);
            Button penaltyPlusBtn = findViewById(R.id.penaltyPlusBtn);
            sendButton = findViewById(R.id.sendButton);
            // Autonomous Score Buttons
            autonomousMinusBtn.setOnClickListener(v -> {
                autonomousCount--;
                updateScore(autonomousScore, autonomousCount);
            });

            autonomousPlusBtn.setOnClickListener(v -> {
                autonomousCount++;
                updateScore(autonomousScore, autonomousCount);
            });

            // Teleop Score Buttons
            teleopMinusBtn.setOnClickListener(v -> {
                teleopCount--;
                updateScore(teleopScore, teleopCount);
            });

            teleopPlusBtn.setOnClickListener(v -> {
                teleopCount++;
                updateScore(teleopScore, teleopCount);
            });

            // Penalty Score Buttons
            penaltyMinusBtn.setOnClickListener(v -> {
                penaltyCount--;
                updateScore(penaltyScore, penaltyCount);
            });

            penaltyPlusBtn.setOnClickListener(v -> {
                penaltyCount++;
                updateScore(penaltyScore, penaltyCount);
            });
        }

        private void updateScore(TextView scoreView, int score) {
            scoreView.setText(String.valueOf(score));
        }

        private void setupSendButton() {
            sendButton.setOnClickListener(v -> {
                // Get all the input values
                String game = gameInput.getText().toString();
                String team = teamInput.getText().toString();
                String notes = notesInput.getText().toString();

                // Create Intent to pass data back to MainActivity
                Intent resultIntent = new Intent();
                resultIntent.putExtra("game", game);
                resultIntent.putExtra("team", team);
                resultIntent.putExtra("autonomousScore", autonomousCount);
                resultIntent.putExtra("teleopScore", teleopCount);
                resultIntent.putExtra("penaltyScore", penaltyCount);
                resultIntent.putExtra("notes", notes);





                // Set the result and finish
                setResult(Activity.RESULT_OK, resultIntent);
                finish(); // This will return to the previous activity (MainActivity)
            });
        }
//כל הפעולות של התפריט
    private void navigateToGameList() {
        Intent intent = new Intent(DataEntry.this, GameLIst.class);
        startActivity(intent);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menuGameList:
                navigateToGameList();
        }
        return false;
    }
}