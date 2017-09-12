package idea.engineering.com.singlescreensampleapp.data_layer.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductColor {

    @SerializedName("available_sizes")
    private List<String> mAvailableSizes;
    @SerializedName("name")
    private String mName;
    @SerializedName("swatch_url")
    private String mSwatchUrl;

    public List<String> getAvailableSizes() {
        return mAvailableSizes;
    }

    public void setAvailableSizes(List<String> availableSizes) {
        mAvailableSizes = availableSizes;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getSwatchUrl() {
        return mSwatchUrl;
    }

    public void setSwatchUrl(String swatchUrl) {
        mSwatchUrl = swatchUrl;
    }

}
