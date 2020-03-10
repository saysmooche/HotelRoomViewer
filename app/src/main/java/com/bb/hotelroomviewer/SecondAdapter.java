package com.bb.hotelroomviewer;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SecondAdapter extends RecyclerView.Adapter<com.bb.hotelroomviewer.SecondAdapter.DataObjectHolder>
    {
        private static String LOG_TAG = "MyRecyclerViewAdapter";
        private ArrayList<DataObject> mDataset;
        private static com.bb.hotelroomviewer.SecondAdapter.MyClickListener myClickListener;
        
        private Context context;

        String [] room = {"Two Doubles\nNon Smoking", "King_Queen\nNon Smoking",
                "Two Doubles\nSmoking", "King_Queen\nSmoking", "Jacuzzi\nNon Smoking"};

        public static class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener
        {
            EditText editText1;
            EditText editText2;
            Button buttoni;

        public DataObjectHolder(View itemView)
        {
            super(itemView);
            editText1 = (EditText) itemView.findViewById(R.id.editText1);
            editText2 = (EditText) itemView.findViewById(R.id.editText2);
            buttoni = (Button) itemView.findViewById(R.id.button123);


            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
        }
        }
        void setOnItemClickListener(com.bb.hotelroomviewer.SecondAdapter.MyClickListener myClickListener) {
            SecondAdapter.myClickListener = myClickListener;
        }
        SecondAdapter(ArrayList<DataObject> myDataset) {
            mDataset = myDataset;
        }
        @NonNull
        @Override
        public com.bb.hotelroomviewer.SecondAdapter.DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                                                                       int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_layout, parent, false);
            com.bb.hotelroomviewer.SecondAdapter.DataObjectHolder dataObjectHolder = new com.bb.hotelroomviewer.SecondAdapter.DataObjectHolder(view);
            return dataObjectHolder;
        }
        @Override
        public void onBindViewHolder(final com.bb.hotelroomviewer.SecondAdapter.DataObjectHolder holder, final int position) {

            holder.editText1.setText(context.toString());
            holder.editText2.setText(context.toString());

            holder.buttoni.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, SecondActivity.class);
                    context.startActivity(intent);
                    Toast.makeText(view.getContext(), holder.editText1.getText().toString(), Toast.LENGTH_LONG).show();
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
            public void onItemClick(int position, View v);
        }
    }

