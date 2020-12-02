package com.example.application5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {
    private ArrayList<HistoryItem> history;


    public void initialize(ArrayList<HistoryItem> history) {
        this.history = history;
        notifyDataSetChanged();
    }

    /*private fun removeExpect(item: HistoryItem) {
        this.history.removeIf { t -> t != item }
        notifyDataSetChanged()
    }*/

    @Override
    public HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType)  {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.history_list_item, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HistoryViewHolder holder, int position) {
        HistoryItem item = this.history.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return history.size();
    }

    class HistoryViewHolder extends RecyclerView.ViewHolder {
        TextView historyText;
        Button historyButton;
        //CheckBox historyCheckBox;

        public HistoryViewHolder(View itemView) {
            super(itemView);

            historyText = itemView.findViewById(R.id.history_text);
            historyButton = itemView.findViewById(R.id.history_button);
            //CheckBox historyCheckBox = itemView.findViewById(R.id.history_checkbox);
        }

        void bind(HistoryItem historyItem) {
            historyText.setText(historyItem.getTextRepresentation());
            historyButton.setOnClickListener(v ->
                            Snackbar.make(itemView,
                                    historyItem.getTextRepresentation(),
                                    Snackbar.LENGTH_LONG)
                                    .show()
                    /*Toast.makeText(historyButton.getContext(),
                            historyItem.getTextRepresentation(),
                            Toast.LENGTH_SHORT)
                            .show()*/);
        }
    }
}
