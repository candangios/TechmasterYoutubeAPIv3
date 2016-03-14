package Model;

/**
 * Created by thanhnv on 3/14/16.
 */
public class ChannelObj {
    String channelName;
    String channelId;

    public ChannelObj(String name, String id) {
        this.channelName = name;
        this.channelId = id;
    }
    public String getChannelId(){
        return this.channelId;
    }
    public String getChannelName(){
        return this.channelName;
    }
}
