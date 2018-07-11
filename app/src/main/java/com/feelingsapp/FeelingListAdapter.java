package com.feelingsapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class FeelingListAdapter extends RecyclerView.Adapter<FeelingListAdapter.FeelingViewHolder> {


    class FeelingViewHolder extends RecyclerView.ViewHolder {
        private final TextView feelingItemView;

        private FeelingViewHolder(View itemView) {
            super(itemView);
            feelingItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater inflater;
    private List<Feeling> feelings;

    FeelingListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }


    @Override
    public FeelingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.recycleview_history_feelings, parent, false);
        return new FeelingViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FeelingViewHolder holder, int position) {
        if (feelings != null) {
            Feeling current = feelings.get(position);
            holder.feelingItemView.setText(current.getName());
        } else {
            // Covers the case of data not being ready yet.
            holder.feelingItemView.setText("No feelings");
        }
    }

    void setFeelings(List<Feeling> feelings){
        this.feelings = feelings;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(feelings != null)
            return feelings.size();
        else
            return 0;
    }

}
