package idea.engineering.com.singlescreensampleapp.data_layer.requests;

import idea.engineering.com.singlescreensampleapp.data_layer.api.ProductApi;
import idea.engineering.com.singlescreensampleapp.data_layer.model.Product;
import idea.engineering.com.singlescreensampleapp.data_layer.model.ProductInfo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadProductRequest extends BaseRequest<Product> {

    ProductApi service;

    public void resumeWithCompletionHandler(final BaseRequest.CompletionHandler<ProductInfo> handler) {
        Call<ProductInfo> call = service.getProduct();

        call.enqueue(new Callback<ProductInfo>() {
            @Override
            public void onResponse(Call<ProductInfo> call, Response<ProductInfo> response) {
                if (response.body() != null) {
                    ProductInfo productInfo = response.body();
                    handler.completionHandler(productInfo);
                }
                handler.completionHandlerWithError("Response is empty");
            }

            @Override
            public void onFailure(Call<ProductInfo> call, Throwable t) {
                handler.completionHandlerWithError(t.getMessage());
            }
        });
    }

    @Override
    public void setupService() {
        service = getRetrofit().create(ProductApi.class);
    }
}
