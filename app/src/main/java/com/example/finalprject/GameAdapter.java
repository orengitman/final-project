package com.example.finalprject;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameViewHolder> {

    private ArrayList<ScouterGame> games;

    public GameAdapter(ArrayList<ScouterGame> games){
    this.games=games;
    }

    @NonNull
    @Override
    public GameAdapter.GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View gamesView = LayoutInflater.from(parent.getContext()).inflate(R.layout.scoutergame,parent,false);

        return new GameViewHolder(gamesView);
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {


    ScouterGame currentgame = games.get(position);
        holder.gameNumberText.setText(currentgame.getGameNumber()
        );
        holder.teamNumberText.setText(currentgame.getTeamNumber());
        holder.teamColorText.setText(currentgame.getTeamColor());

        int backgroundColor = currentgame.getTeamColor().equals("red") ?
                Color.parseColor("#FF4444") : Color.parseColor("#4444FF");
        holder.cardView.setCardBackgroundColor(backgroundColor);

    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    static class GameViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView gameNumberText;
        TextView teamNumberText;
        TextView teamColorText;

        GameViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.gameCardView);
            gameNumberText = itemView.findViewById(R.id.gameNumberText);
            teamNumberText = itemView.findViewById(R.id.teamNumberText);
            teamColorText = itemView.findViewById(R.id.teamColorText);
        }
    }
}



