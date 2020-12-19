package com.ChibiKev.to_do_application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> items;

    Button toDoAdd;
    EditText textItem;
    RecyclerView showItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toDoAdd = findViewById(R.id.toDoAdd);
        textItem = findViewById(R.id.textItem);
        showItems = findViewById(R.id.showItems);

        items = new ArrayList<>();
        items.add("Hello");
        items.add("test");

        ItemsAdapter itemsAdapter = new ItemsAdapter(items);
        showItems.setAdapter(itemsAdapter);
        showItems.setLayoutManager(new LinearLayoutManager(this));
    }
}