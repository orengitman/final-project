package com.example.finalprject;

import android.widget.TextView;

public class ScouterGame {
        private int gameNumber;
        private int teamNumber;
        private String teamColor;

        public ScouterGame(int gameNumber, int teamNumber, String teamColor) {
            this.gameNumber = gameNumber;
            this.teamNumber = teamNumber;
            this.teamColor = teamColor;
        }

        // Getters
        public int getGameNumber()
        { return gameNumber; }
        public int getTeamNumber()
        { return teamNumber; }
        public String getTeamColor()
        { return teamColor; }

    public void setTeamNumber(int teamNumber)
    {
        this.teamNumber = teamNumber;
    }

    public void setGameNumber(int gameNumber)
    {
        this.gameNumber = gameNumber;
    }

    public void setTeamColor(String teamColor)
    {
        this.teamColor = teamColor;
    }

}

