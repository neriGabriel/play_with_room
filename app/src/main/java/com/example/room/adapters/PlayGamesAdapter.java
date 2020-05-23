package com.example.room.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.room.R;
import com.example.room.model.PlayGame;

import java.util.List;

public class PlayGamesAdapter extends RecyclerView.Adapter<PlayGamesAdapter.ViewHolder> {

    private List<PlayGame> playGameList;

    public PlayGamesAdapter(List<PlayGame> playGameList) {
        this.playGameList = playGameList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.playgames_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textId.setText(String.valueOf(this.playGameList.get(position).getId()));
        holder.textName.setText(this.playGameList.get(position).getName());
        holder.textDescription.setText(this.playGameList.get(position).getDescription());
        holder.textPlayers.setText(String.valueOf(this.playGameList.get(position).getPlayers()));
    }

    @Override
    public int getItemCount() {
        return this.playGameList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textName;
        TextView textDescription;
        TextView textId;
        TextView textPlayers;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textName = itemView.findViewById(R.id.textViewName);
            this.textDescription = itemView.findViewById(R.id.textViewDescription);
            this.textId = itemView.findViewById(R.id.textViewId);
            this.textPlayers = itemView.findViewById(R.id.textViewPlayers);
        }
    }
}
