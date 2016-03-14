package Asynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.example.thanhnv.techmasteryoutubechanelapp.GoogleProgress;

/**
 * Created by thanhnv on 3/14/16.
 */
public class LoadListVideoAsys extends AsyncTask<Void, Void, Void> {
     private Context context;
     ProgressDialog progress;
    boolean loadmore;
    String channelid;

    public LoadListVideoAsys(String channelID, boolean loadmore, Context context) {
      context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();


        progress = GoogleProgress.ProgressShow(context);
        progress.show();

    }
    @Override
    protected Void doInBackground(Void... params) {

        return null;
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected void onCancelled(Void aVoid) {
        super.onCancelled(aVoid);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }



    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
