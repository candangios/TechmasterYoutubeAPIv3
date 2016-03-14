package Model;

/**
 * Created by thanhnv on 3/14/16.
 */
public class VideoObj {
    String video_ID;
    String video_thumb;
    String video_title;

    public VideoObj(String id,String title,String thumb) {
        this.video_ID = id;
        this.video_title = title;
        this.video_thumb = thumb;
    }
}
