package com.gzeinnumer.recyclerviewdynamic;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DynamicAdapter extends RecyclerView.Adapter<DynamicAdapter.MyHolder> {
    private static final String TAG = "DynamicAdapter";

    public ArrayList<String> list;

    public DynamicAdapter(ArrayList<String> list) {
        this.list = list;
    }

    public void add() {
        list.add("");
        notifyItemInserted(list.size() - 1);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.bindData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {

        public EditText editText;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            editText = itemView.findViewById(R.id.editText);
        }

        public void bindData(String data) {

        }
    }
}
