package idea.engineering.com.singlescreensampleapp.data_layer.model;

import com.google.gson.annotations.SerializedName;

public class Size {

    @SerializedName("canonicalSize")
    private CanonicalSize mCanonicalSize;
    @SerializedName("name")
    private String mName;

    public CanonicalSize getCanonicalSize() {
        return mCanonicalSize;
    }

    public void setCanonicalSize(CanonicalSize canonicalSize) {
        mCanonicalSize = canonicalSize;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

}
