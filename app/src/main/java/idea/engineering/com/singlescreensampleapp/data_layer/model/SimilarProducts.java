package idea.engineering.com.singlescreensampleapp.data_layer.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SimilarProducts {

    @SerializedName("similar_products")

    private List<ProductInfo> similarProducts = null;

    public void setSimilarProducts(List<ProductInfo> similarProducts) {
        this.similarProducts = similarProducts;
    }

    public List<ProductInfo> getSimilarProducts() {
        return similarProducts;
    }
}