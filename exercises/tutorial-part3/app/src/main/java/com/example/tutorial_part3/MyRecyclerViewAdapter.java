package com.example.tutorial_part3;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import org.xml.sax.DTDHandler;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    Context context;
    ListRowData listRowData;

    public MyRecyclerViewAdapter(Context context, ListRowData listRowData) {
        this.context = context;
        this.listRowData = listRowData;
    }



    @NonNull
    @Override
    public MyRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate our layout (Giving look to our rows)

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.relative_layout_row, parent, false);

        return new MyRecyclerViewAdapter.MyViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.MyViewHolder holder, int position) {
        // Assign values to the view we created in the layout/....xml
        // based on the position of the recycler view

        holder.nameTextView.setText(listRowData.getNames()[position]);
        holder.priceTextView.setText(listRowData.getPrices()[position]);
        holder.descriptionTextView.setText(listRowData.getDescriptions()[position]);
    }

    @Override
    public int getItemCount() {
        // the recycler view wants to know the number of items you want displayed
        return listRowData.getCount();
    }

    // HAS TO BE STATIC
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // grabbing views from the layout/relative_layout_row.xml and assigning them to variables

        Context context;
        TextView nameTextView, priceTextView, descriptionTextView;

        public MyViewHolder(@NonNull View itemView, Context context) {
            super(itemView);

            this.context = context;
            nameTextView = itemView.findViewById(R.id.nameTextView);
            priceTextView = itemView.findViewById(R.id.priceTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent showDetailActivity = new Intent(context.getApplicationContext(), DetailActivity.class);
            showDetailActivity.putExtra("com.mySite.ITEM_INDEX", getAdapterPosition());
            context.startActivity(showDetailActivity);
        }
    }
}


