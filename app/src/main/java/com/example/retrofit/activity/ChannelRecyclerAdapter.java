package com.example.retrofit.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.example.retrofit.R;
import com.example.retrofit.network.model.channel.Datum;

public class ChannelRecyclerAdapter extends ListAdapter<Datum, ChannelRecyclerAdapter.CategoriesItemViewHolder> {

    public ChannelRecyclerAdapter() {
        super(Datum.DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public CategoriesItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.channel, parent, false);
        return new CategoriesItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesItemViewHolder holder, int position) {
        Datum datum = getItem(position);
        if(datum != null) {
            holder.bindTo(datum);
        }
    }

    protected static class CategoriesItemViewHolder extends RecyclerView.ViewHolder {
        TextView category;

        public CategoriesItemViewHolder(View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.showCategories);

        }

        public void bindTo(Datum datum) {
            category.setText(datum.getId()+" " + datum.getTitle() + " ");


        }
    }
}
