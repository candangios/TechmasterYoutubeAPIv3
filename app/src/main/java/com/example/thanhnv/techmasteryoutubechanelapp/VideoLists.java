package com.example.thanhnv.techmasteryoutubechanelapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import Asynctask.LoadListVideoAsys;
import Asynctask.OntaskVideoCompleted;
import CustomAdapter.VideoListAdapter;
import Model.VideoObj;

public class VideoLists extends AppCompatActivity implements OntaskVideoCompleted {

    ListView lvVideo;


    String NEXT_PAGE_TOKEN = "";
    ProgressDialog progress;
    int total = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_lists);
        new LoadListVideoAsys(DataManager.selectChannelID,false,this, this).execute();

        // anh sa

        lvVideo = (ListView) findViewById(R.id.lv_video);

    }
//    implement interface

    @Override
    public void onTaskCompleted(ArrayList<VideoObj> videoLists) {

        VideoListAdapter videoAdapter = new VideoListAdapter(getApplicationContext(), videoLists);


        lvVideo.setAdapter(videoAdapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_video_lists, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
