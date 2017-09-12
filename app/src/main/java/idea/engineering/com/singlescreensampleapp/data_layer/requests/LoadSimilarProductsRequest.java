package idea.engineering.com.singlescreensampleapp.data_layer.requests;

import java.util.List;

import idea.engineering.com.singlescreensampleapp.data_layer.api.SimilarProductsApi;
import idea.engineering.com.singlescreensampleapp.data_layer.model.Product;
import idea.engineering.com.singlescreensampleapp.data_layer.model.SimilarProducts;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadSimilarProductsRequest extends BaseRequest<List<Product>> {

    SimilarProductsApi service;

    public void resumeWithCompletionHandler(final CompletionHandler<SimilarProducts> handler) {
        Call<SimilarProducts> call = service.getSimilarProducts();

        call.enqueue(new Callback<SimilarProducts>() {
            @Override
            public void onResponse(Call<SimilarProducts> call, Response<SimilarProducts> response) {
                if (response.body() != null) {
                    SimilarProducts similarProducts = response.body();
                    handler.completionHandler(similarProducts);
                }
                handler.completionHandlerWithError("Response is empty");
            }

            @Override
            public void onFailure(Call<SimilarProducts> call, Throwable t) {
                handler.completionHandlerWithError(t.getMessage());
            }
        });
    }

    @Override
    public void setupService() {
        service = getRetrofit().create(SimilarProductsApi.class);
    }
}
