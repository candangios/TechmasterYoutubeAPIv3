package CustomAdapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thanhnv.techmasteryoutubechanelapp.R;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import Model.VideoObj;

/**
 * Created by thanhnv on 3/14/16.
 */
public class VideoListAdapter  extends BaseAdapter{
    private ArrayList<VideoObj> videoLists;
    private LayoutInflater mInflater;
    public VideoListAdapter(Context context, ArrayList<VideoObj> videoLists) {
        mInflater = LayoutInflater.from(context);
        this.videoLists = videoLists;

    }

    @Override
    public int getCount() {
        return videoLists.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      ViewHolder holder;
        if (convertView == null){

            convertView =  mInflater.inflate(R.layout.row_video_list, null);
             holder = new ViewHolder();
            holder.txt_title = (TextView)convertView.findViewById(R.id.txttitle);
            holder.img_thumbnail = (ImageView)convertView.findViewById(R.id.img);

            convertView.setTag(holder);

        }else {
            holder = (ViewHolder)convertView.getTag();

        }
        VideoObj video = videoLists.get(position);
        holder.txt_title.setText("" + video.getVideo_title());
        if (position ==0) {
            holder.img_thumbnail.setTag(video.getVideo_thumb());
            new DownloadImagesTask().execute(holder.img_thumbnail);
        }


        return convertView;
    }

    class ViewHolder{
        TextView txt_title;
        ImageView img_thumbnail;
    }


    public class DownloadImagesTask extends AsyncTask<ImageView, Void, Bitmap> {

        ImageView imageView = null;

        @Override
        protected Bitmap doInBackground(ImageView... imageViews) {
            this.imageView = imageViews[0];
            return download_Image("https://java.sogeti.nl/JavaBlog/wp-content/uploads/2009/04/android_icon_256.png");
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }

        private Bitmap download_Image(String url) {

            Bitmap bmp =null;
            try{
                URL ulrn = new URL(url);
                HttpURLConnection con = (HttpURLConnection)ulrn.openConnection();
                InputStream is = con.getInputStream();
                bmp = BitmapFactory.decodeStream(is);
                if (null != bmp)
                    return bmp;

            }catch(Exception e){}
            return bmp;
        } }


}
