package idea.engineering.com.singlescreensampleapp.data_layer.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product {

    @SerializedName("description")
    private String mDescription;
    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("price")
    private Float mPrice;
    @SerializedName("primary_photos")
    private List<Photo> mPrimaryPhotos;
    @SerializedName("product_colors")
    private List<ProductColor> mProductColors;
    @SerializedName("recommendation_logic")
    private List<String> mRecommendationLogic;
    @SerializedName("retailer")
    private String mRetailer;
    @SerializedName("retailer_logo")
    private String mRetailerLogo;
    @SerializedName("return_policy")
    private String mReturnPolicy;
    @SerializedName("sale_price")
    private Float mSalePrice;
    @SerializedName("secondary_photos")
    private List<Photo> mSecondaryPhotos;
    @SerializedName("shipping_cost")
    private Double mShippingCost;
    @SerializedName("sizes")
    private List<Size> mSizes;

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Float getPrice() {
        return mPrice;
    }

    public void setPrice(Float price) {
        mPrice = price;
    }

    public List<Photo> getPrimaryPhotos() {
        return mPrimaryPhotos;
    }

    public void setPrimaryPhotos(List<Photo> photos) {
        mPrimaryPhotos = photos;
    }

    public List<ProductColor> getProductColors() {
        return mProductColors;
    }

    public void setProductColors(List<ProductColor> productColors) {
        mProductColors = productColors;
    }

    public List<String> getRecommendationLogic() {
        return mRecommendationLogic;
    }

    public void setRecommendationLogic(List<String> recommendationLogic) {
        mRecommendationLogic = recommendationLogic;
    }

    public String getRetailer() {
        return mRetailer;
    }

    public void setRetailer(String retailer) {
        mRetailer = retailer;
    }

    public String getRetailerLogo() {
        return mRetailerLogo;
    }

    public void setRetailerLogo(String retailerLogo) {
        mRetailerLogo = retailerLogo;
    }

    public String getReturnPolicy() {
        return mReturnPolicy;
    }

    public void setReturnPolicy(String returnPolicy) {
        mReturnPolicy = returnPolicy;
    }

    public Float getSalePrice() {
        return mSalePrice;
    }

    public void setSalePrice(Float salePrice) {
        mSalePrice = salePrice;
    }

    public List<Photo> getSecondaryPhotos() {
        return mSecondaryPhotos;
    }

    public void setSecondaryPhotos(List<Photo> secondaryPhotos) {
        mSecondaryPhotos = secondaryPhotos;
    }

    public Double getShippingCost() {
        return mShippingCost;
    }

    public void setShippingCost(Double shippingCost) {
        mShippingCost = shippingCost;
    }

    public List<Size> getSizes() {
        return mSizes;
    }

    public void setSizes(List<Size> sizes) {
        mSizes = sizes;
    }

}
