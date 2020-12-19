package com.ChibiKev.to_do_application;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder>{
    List<String> items;

    public ItemsAdapter(List<String> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // Use layout inflator to inflate a view
        View todoView = LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_list_item_1,viewGroup,false);
        // Wrap it inside a View Holder and return it
        return new ViewHolder(todoView);
    }

    // Responsible for binding data to a particular view holder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        // Grab the item at the position
        String item = items.get(i);
        // Bind the item into the specified view holder
        viewHolder.bind(item);
    }

    // Tells the RV how many items are in the list
    @Override
    public int getItemCount() {
        return items.size();
    }

    // Container to provide easy access to view that represent each row of the list
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewItems;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewItems = itemView.findViewById(android.R.id.text1);
        }

        // Update the view inside of the view holder with this data
        public void bind(String item){
            textViewItems.setText(item);
        }
    }
}
