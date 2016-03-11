package Asynctask;

import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.util.Log;

import com.example.thanhnv.techmasteryoutubechanelapp.DataManager;


import org.apache.http.params.HttpConnectionParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by thanhnv on 3/11/16.
 */
public class LoadListChannelAsys extends AsyncTask<Void,Void,Void> {
    @Override
    protected Void doInBackground(Void... params) {
        try {
            URL url = new URL("https://www.googleapis.com/youtube/v3/search?part=snippet&channelId="
                    + "UC0f1bHxXmTHq6FIuDV7oV5w"

                    + "&maxResults="
                    + 20 + "&key=" + DataManager.ANDROID_YOUTUBE_API_KEY +"&order=date");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                String str = "";
                while ((line = bufferedReader.readLine()) != null) {
                    str +=line;
                }
                System.out.println("url---" + str);
            }
            finally{
                urlConnection.disconnect();
            }
        }
        catch(Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return null;
        }


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
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
