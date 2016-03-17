package Asynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.util.Log;

import com.example.thanhnv.techmasteryoutubechanelapp.DataManager;
import com.example.thanhnv.techmasteryoutubechanelapp.GoogleProgress;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import Model.ChannelObj;
import Model.VideoObj;

/**
 * Created by thanhnv on 3/14/16.
 */
public class LoadListVideoAsys extends AsyncTask<Void, Void, Void> {
    private OntaskVideoCompleted listener;
    private URL YOUTUBE_URL;
    private String YOUTUBE_API_KEY = DataManager.ANDROID_YOUTUBE_API_KEY;
    int MAX_RESULT = DataManager.maxResult;
     private Context context;
     ProgressDialog progress;
    boolean loadmore;
    String currentChannelID;
    private ArrayList<VideoObj> videiLists = new ArrayList<VideoObj>();

    public LoadListVideoAsys(String channelID, boolean loadmore, Context context, OntaskVideoCompleted listener) {
        this.context = context;
        this.currentChannelID = channelID;
        this.loadmore = loadmore;
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progress = GoogleProgress.ProgressShow(context);
        progress.show();

    }
    @Override
    protected Void doInBackground(Void... params) {
        try {

            if (!loadmore){
               YOUTUBE_URL = new URL("https://www.googleapis.com/youtube/v3/search?part=snippet&channelId="
                       + this.currentChannelID
                       + "&maxResults=" + MAX_RESULT
                       + "&key=" + YOUTUBE_API_KEY+"&order=date");
            }else {

            }

            HttpURLConnection urlConnection = (HttpURLConnection) YOUTUBE_URL.openConnection();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                String str = "";
                while ((line = bufferedReader.readLine()) != null) {
                    str +=line;
                }
                System.out.println("url---" + str);

                JSONObject json = new JSONObject(str);
                JSONArray arrItems = json.getJSONArray("items");
                for (int i = 0; i < arrItems.length(); i++) {


                    JSONObject youtubeObject = arrItems.getJSONObject(i)
                            .getJSONObject("snippet");

                    String id = arrItems.getJSONObject(i).getJSONObject("id")
                            .getString("videoId");
                    String title = youtubeObject.getString("title");
                    String thumbnail = youtubeObject.getJSONObject("thumbnails").getJSONObject("high").getString("url");

                    VideoObj video = new VideoObj(id,title,thumbnail);
                    videiLists.add(video);
                }




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
        progress.hide();
        listener.onTaskCompleted(this.videiLists);



    }




    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
