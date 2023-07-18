package com.example.tutorial_part3;

import static com.example.tutorial_part3.ImageScaler.*;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import org.xml.sax.DTDHandler;

import java.util.HashMap;
import java.util.Map;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    Context context;
    WindowManager wm;
    ListRowData listRowData;

    boolean allowWhiteBellies;

    HashMap<Integer, Bitmap> cachedImages = new HashMap<Integer, Bitmap>();

    public MyRecyclerViewAdapter(Context context, WindowManager wm, ListRowData listRowData, boolean allowWhiteBellies) {
        this.context = context;
        this.listRowData = listRowData;
        this.wm = wm;
        this.allowWhiteBellies = allowWhiteBellies;

        resetCache();
    }

    public void resetCache() {
        cachedImages.clear();
    }



    @NonNull
    @Override
    public MyRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate our layout (Giving look to our rows)

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.relative_layout_row, parent, false);

        return new MyRecyclerViewAdapter.MyViewHolder(view, context, wm);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.MyViewHolder holder, int position) {
        // Assign values to the view we created in the layout/....xml
        // based on the position of the recycler view

        holder.nameTextView.setText(listRowData.getNames()[position]);
        holder.priceTextView.setText(listRowData.getPrices()[position]);
        holder.descriptionTextView.setText(listRowData.getDescriptions()[position]);
        holder.imageId = listRowData.getImageIds()[position];

//        int imagePosition = position + countPastAlreadySkippedWhiteBellies(position, listRowData.getWhiteBelly());
        int imagePosition = listRowData.getImageIds()[position];

        if (cachedImages.containsKey(position)) {
            holder.imagePreview.setImageBitmap(cachedImages.get(position));
        } else {

            Bitmap bitmap = scaleImage(wm, context.getResources(), getImage(imagePosition));
            cachedImages.put(position, bitmap);

            holder.imagePreview.setImageBitmap(bitmap);
        }
    }

    private int countPastAlreadySkippedWhiteBellies(int position, String[] whiteBellies) {
        Log.w("MYTAG", "POSITION: " + position);
        if (allowWhiteBellies) return 0;
        Log.w("MYTAG", "GOING THRO: " + position);

        int endPos = position;
        int positionsToSkip = 0;
        for (int i = 0; i <= endPos; i++) {
            Log.w("MYTAG", "VALUE: " + Boolean.parseBoolean(whiteBellies[i]));
            if (Boolean.parseBoolean(whiteBellies[i])) {
                positionsToSkip++;
                endPos++;
            }
        }
        Log.w("MYTAG", "POSITIONSTOSKIP: " + positionsToSkip);

        return positionsToSkip;
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
        WindowManager wm;
        TextView nameTextView, priceTextView, descriptionTextView;

        int imageId;
        ImageView imagePreview;

        public MyViewHolder(@NonNull View itemView, Context context, WindowManager wm) {
            super(itemView);

            this.context = context;
            this.wm = wm;
            nameTextView = itemView.findViewById(R.id.nameTextView);
            priceTextView = itemView.findViewById(R.id.priceTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            imagePreview = itemView.findViewById(R.id.imagePreview);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent showDetailActivity = new Intent(context.getApplicationContext(), DetailActivity.class);
            showDetailActivity.putExtra("com.mySite.ITEM_INDEX", imageId); //getAdapterPosition()
            showDetailActivity.putExtra("com.mySite.ITEM_NAME", nameTextView.getText()); //getAdapterPosition()
            showDetailActivity.putExtra("com.mySite.ITEM_PRICE", priceTextView.getText()); //getAdapterPosition()
            showDetailActivity.putExtra("com.mySite.ITEM_DESCRIPTION", descriptionTextView.getText()); //getAdapterPosition()
            context.startActivity(showDetailActivity);
        }
    }
}


