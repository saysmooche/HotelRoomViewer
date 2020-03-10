package com.bb.hotelroomviewer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = -1;

    private RecyclerView tRecyclerView;
    private RecyclerView.Adapter tAdapter;
    private RecyclerView.LayoutManager tLayoutManager;
    private static String LOG_TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tRecyclerView = (RecyclerView) findViewById(R.id.recycl);
        tRecyclerView.setHasFixedSize(true);
        tLayoutManager = new LinearLayoutManager(this);
        tRecyclerView.setLayoutManager(tLayoutManager);
        tAdapter = new SecondAdapter(getDataSet());
        tRecyclerView.setAdapter(tAdapter);

    }
    @Override
    protected void onResume()
    {
        super.onResume();
        ((SecondAdapter)tAdapter).setOnItemClickListener(new SecondAdapter.MyClickListener()
        {
            @Override
            public void onItemClick(int position, View v) {
                Log.i(LOG_TAG, " Clicked on Item " + position);
            }
        });
    }
    private ArrayList<DataObject> getDataSet() {
        ArrayList results = new ArrayList<DataObject>();
        for (int index = 0; index < 20; index++) {
            DataObject obj = new DataObject("Some Primary Text " + index,
                    "Secondary " + index);
            results.add(index, obj);
        }
        return results;
    }
    public void capturePhoto() {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }
    }
}