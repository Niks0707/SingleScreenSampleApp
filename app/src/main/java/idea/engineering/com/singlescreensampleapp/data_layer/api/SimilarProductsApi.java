package idea.engineering.com.singlescreensampleapp.data_layer.api;

import idea.engineering.com.singlescreensampleapp.data_layer.model.SimilarProducts;
import retrofit2.Call;
import retrofit2.http.GET;

public interface SimilarProductsApi {
    @GET("59b382d0100000da02236b2a/")
    Call<SimilarProducts> getSimilarProducts();
}
