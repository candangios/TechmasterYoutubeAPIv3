package com.example.thanhnv.techmasteryoutubechanelapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import net.i2p.android.ext.floatingactionbutton.FloatingActionButton;
import net.i2p.android.ext.floatingactionbutton.FloatingActionsMenu;

import Asynctask.LoadListChannelAsys;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        getSupportActionBar().show(); //<< this
        setContentView(R.layout.activity_main);
        setTitle("Channel");
        new LoadListChannelAsys().execute();
//        final FloatingActionsMenu floatingActionsMenu = (FloatingActionsMenu)findViewById(R.id.floatb);
//        final FloatingActionButton ftshare = (FloatingActionButton) findViewById(R.id.ftshare);
//        ftshare.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                shareapp();
//            }
//        });
//
//        final FloatingActionButton ffrate = (FloatingActionButton) findViewById(R.id.ftrate);
//        ffrate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String apppackage = getApplicationContext().getPackageName().toString();
//                String url = "https://play.google.com/store/apps/details?id="+apppackage;
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);
//            }
//        });

    }

    public void shareapp()
    {

        String apppackage = getApplicationContext().getPackageName().toString();
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT,
                DataManager.share + apppackage);
        startActivity(Intent
                .createChooser(sharingIntent, "Share using"));
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
