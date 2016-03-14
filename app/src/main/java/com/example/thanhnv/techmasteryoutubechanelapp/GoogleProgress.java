package com.example.thanhnv.techmasteryoutubechanelapp;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by thanhnv on 3/11/16.
 */
public class GoogleProgress {
    public static ProgressDialog progress;
    public static ProgressDialog ProgressShow(Context context){
        progress = new ProgressDialog( context,R.style.MyTheme);
        progress.setCancelable(false);
        progress.getWindow().setBackgroundDrawable(null);
        progress.setIndeterminateDrawable(context.getDrawable(R.anim.progressbar));
        return progress;
    }

}
