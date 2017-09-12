package idea.engineering.com.singlescreensampleapp.data_layer.model;

import com.google.gson.annotations.SerializedName;

public class Photo {

    @SerializedName("web_url")
    private String mWebUrl;

    public String getWebUrl() {
        return mWebUrl;
    }

    public void setWebUrl(String webUrl) {
        mWebUrl = webUrl;
    }

}
