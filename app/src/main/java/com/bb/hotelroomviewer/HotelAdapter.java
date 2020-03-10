package com.bb.hotelroomviewer;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.DataObjectHolder>
{
    private static String LOG_TAG = "HotelViewAdapter";
    private ArrayList<DataObject> mDataset;
    private static MyClickListener myClickListener;

    private Context context;

    String [] room = {"Two Doubles\nNon Smoking", "King_Queen\nNon Smoking",
            "Two Doubles\nSmoking", "King_Queen\nSmoking", "Jacuzzi\nNon Smoking"};

    public static class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView label;
        TextView dateTime;
        TextView descrip1;
        TextView descrip2;
        TextView descrip3;
        ImageView image1;
        ImageView image2;
        ImageView image3;
        ImageView image4;
        ImageView image5;
        Button button5;
        Button button1;
        Button button2;
        Button button3;
        Button button4;


        public DataObjectHolder(View itemView) {
            super(itemView);
            descrip1 = itemView.findViewById(R.id.descriptiontxt6);
            descrip2 = itemView.findViewById(R.id.descriptiontxt5);
            descrip3 = itemView.findViewById(R.id.descriptiontxt4);
            label = itemView.findViewById(R.id.descriptiontxt3);
            dateTime = itemView.findViewById(R.id.descriptiontxt2);
            image1 = itemView.findViewById(R.id.myImageView);
            image2 = itemView.findViewById(R.id.myImageView4);
            image3 = itemView.findViewById(R.id.myImageView3);
            image4 = itemView.findViewById(R.id.myImageView2);
            image5 = itemView.findViewById(R.id.myImageView5);
            button1 = itemView.findViewById(R.id.button);
            button2 = itemView.findViewById(R.id.button1);
            button3 = itemView.findViewById(R.id.button2);
            button4 = itemView.findViewById(R.id.button4);
            button5 = itemView.findViewById(R.id.button6);

            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
        }
    }
    public void setOnItemClickListener(MyClickListener myClickListener)
    {
        HotelAdapter.myClickListener = myClickListener;
    }
    public HotelAdapter(ArrayList<DataObject> myDataset) {
        mDataset = myDataset;
    }
    @NonNull
    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_layout, parent, false);
        return new DataObjectHolder(view);
    }
    @Override
    public void onBindViewHolder(DataObjectHolder holder, final int position) {
        holder.label.setText(room[position]);
        holder.dateTime.setText(room[position]);
        holder.descrip1.setText(room[position]);
        holder.descrip2.setText(room[position]);
        holder.descrip3.setText(room[position]);
        holder.image1.setImageResource(R.drawable.htr1);
        holder.image2.setImageResource(R.drawable.htr2);
        holder.image3.setImageResource(R.drawable.htr3);
        holder.image4.setImageResource(R.drawable.htr4);
        holder.image5.setImageResource(R.drawable.ht5);

        holder.button1.setOnClickListener(new View.OnClickListener() {
            @NonNull
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondActivity.class);
                context.startActivity(intent);
                Toast.makeText(view.getContext(),"click on item: "+room[position],Toast.LENGTH_LONG).show();
            }
        });
        holder.button2.setOnClickListener(new View.OnClickListener() {
            @NonNull
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondActivity.class);
                context.startActivity(intent);
                Toast.makeText(view.getContext(),"click on item: "+room[position],Toast.LENGTH_LONG).show();
            }
        });
        holder.button3.setOnClickListener(new View.OnClickListener() {
            @NonNull
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondActivity.class);
                context.startActivity(intent);
                Toast.makeText(view.getContext(),"click on item: "+room[position],Toast.LENGTH_LONG).show();
            }
        });
        holder.button4.setOnClickListener(new View.OnClickListener() {
            @NonNull
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondActivity.class);
                context.startActivity(intent);
                Toast.makeText(view.getContext(),"click on item: "+room[position],Toast.LENGTH_LONG).show();
            }
        });
        holder.button5.setOnClickListener(new View.OnClickListener() {
            @NonNull
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondActivity.class);
                context.startActivity(intent);
                Toast.makeText(view.getContext(),"click on item: "+room[position],Toast.LENGTH_LONG).show();
            }
        });
    }
    public void addItem(DataObject dataObj, int index) {
        mDataset.add(index, dataObj);
        notifyItemInserted(index);
    }
    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
    public interface MyClickListener {
        void onItemClick(int position, View v);
    }
}

