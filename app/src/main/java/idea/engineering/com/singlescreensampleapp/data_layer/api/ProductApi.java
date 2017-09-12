package idea.engineering.com.singlescreensampleapp.data_layer.api;

import idea.engineering.com.singlescreensampleapp.data_layer.model.ProductInfo;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductApi {
    @GET("59b351b4120000310d89253e/")
    Call<ProductInfo> getProduct();
}