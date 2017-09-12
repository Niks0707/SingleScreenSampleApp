package idea.engineering.com.singlescreensampleapp.data_layer.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductInfo {

    @SerializedName("product")
    private Product product;
    @SerializedName("retailer_logo")
    private String retailerLogo;
    @SerializedName("recommendation_logic")
    private List<String> recommendationLogic = null;

    public List<String> getRecommendationLogic() {
        return recommendationLogic;
    }

    public Product getProduct() {
        return product;
    }

    public String getRetailerLogo() {
        return retailerLogo;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setRecommendationLogic(List<String> recommendationLogic) {
        this.recommendationLogic = recommendationLogic;
    }

    public void setRetailerLogo(String retailerLogo) {
        this.retailerLogo = retailerLogo;
    }
}
