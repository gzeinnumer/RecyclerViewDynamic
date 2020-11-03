package com.gzeinnumer.recyclerviewdynamic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DynamicAdapter adapter;

    RecyclerView recyclerView;
    Button addItem;
    Button getAllData;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        addItem = findViewById(R.id.button);
        getAllData = findViewById(R.id.getAllData);
        textView = findViewById(R.id.textView);

        initAdapter();

        getAllData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initGetDataPerIndex();
            }
        });
    }

    private void initAdapter() {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("M");
        arrayList.add("Fadli");
        arrayList.add("Zein");
        adapter = new DynamicAdapter(arrayList);

        adapter.add();

        recyclerView.setAdapter(adapter);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.add();
            }
        });
    }

    private void initGetDataPerIndex() {
        String str = "";

        int countItem = adapter.getItemCount();

        for (int i=0; i<countItem; i++){
            DynamicAdapter.MyHolder holder = (DynamicAdapter.MyHolder) recyclerView.findViewHolderForAdapterPosition(i);

            str = str + holder.editText.getText()+",";
        }

        textView.setText(str);
    }
}