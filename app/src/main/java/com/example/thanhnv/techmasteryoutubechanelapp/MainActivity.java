package com.example.thanhnv.techmasteryoutubechanelapp;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.Intent;
import android.provider.DocumentsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.List;

import Model.ChannelObj;

public class MainActivity extends AppCompatActivity {
    ListView lvchannels;
    ProgressDialog pDialog;

   List<ChannelObj> channelList = new ArrayList<ChannelObj>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.main_screen);
        setTitle("Channel");
        lvchannels = (ListView)findViewById(R.id.lv_channels);

        String [] channelsID = getResources().getStringArray(R.array.channel_ID);
        String [] channelsName = getResources().getStringArray(R.array.channel_name);
        for (int i =0; i< channelsID.length; i++) {
            ChannelObj channel = new ChannelObj(channelsName[i],channelsID[i]);
            channelList.add(channel);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,channelsName);
        lvchannels.setAdapter(adapter);

        lvchannels.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                ChannelObj channel = channelList.get(position);
                DataManager.selectChannelID = channel.getChannelId();
                DataManager.channelName = channel.getChannelName();
                Intent i = new Intent(MainActivity.this, VideoLists.class);
                startActivity(i);
                overridePendingTransition(0, 0);
            }
        });










        //



    }

    public void shareapp()
    {


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
