package com.example.finalprject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

public class masterScouter extends AppCompatActivity {
    private NumberPicker numberPicker;
    private LinearLayout teamContainer;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_scouter);
        numberPicker = findViewById(R.id.numberPicker);
        teamContainer = findViewById(R.id.teamContainer);

        // Set up NumberPicker
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(99);

        // Set up team and user input views
        for (int i = 0; i < 6; i++) {
            View teamView = getLayoutInflater().inflate(R.layout.userscouting, teamContainer, false);
            AutoCompleteTextView teamName = teamView.findViewById(R.id.teamName);
            AutoCompleteTextView userName = teamView.findViewById(R.id.userName);

            // Set up event listeners and other logic for the views
            // ...

            teamContainer.addView(teamView);
        }
    }

    // Implement methods to retrieve the selected match number and team/user information
    public int getSelectedMatchNumber() {
        return numberPicker.getValue();
    }


}

