package com.ChibiKev.to_do_application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> items;

    Button toDoAdd;
    EditText textItem;
    RecyclerView showItems;
    ItemsAdapter itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toDoAdd = findViewById(R.id.toDoAdd);
        textItem = findViewById(R.id.textItem);
        showItems = findViewById(R.id.showItems);

        items = new ArrayList<>();

        ItemsAdapter.onLongClickListener onLongClickListener = new ItemsAdapter.onLongClickListener() {
            @Override
            public void onItemLongClicked(int position) {
                // Delete item from the model
                items.remove(position);
                // Notify the adapter
                itemsAdapter.notifyItemRemoved(position);
                Toast.makeText(getApplicationContext(),"Item Successfully Removed",Toast.LENGTH_SHORT).show();
            }
        };

        itemsAdapter = new ItemsAdapter(items, onLongClickListener);
        showItems.setAdapter(itemsAdapter);
        showItems.setLayoutManager(new LinearLayoutManager(this));

        toDoAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toDoItem = textItem.getText().toString();
                // Add Item to Model
                items.add(toDoItem);
                // Modify adapter that an item is inserted
                itemsAdapter.notifyItemInserted(items.size() - 1);
                textItem.setText("");
                Toast.makeText(getApplicationContext(),"Item Successfully Added",Toast.LENGTH_SHORT).show();
            }
        });
    }
}