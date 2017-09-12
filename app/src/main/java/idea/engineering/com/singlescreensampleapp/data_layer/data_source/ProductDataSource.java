package idea.engineering.com.singlescreensampleapp.data_layer.data_source;

import idea.engineering.com.singlescreensampleapp.data_layer.model.ProductInfo;
import idea.engineering.com.singlescreensampleapp.data_layer.requests.BaseRequest;
import idea.engineering.com.singlescreensampleapp.data_layer.requests.LoadProductRequest;

public class ProductDataSource extends BaseDataSource<ProductInfo> {

    LoadProductRequest loadProductRequest;

    @Override
    public void reloadData() {
        notifyListenersWillLoadItems();

        loadProductRequest = new LoadProductRequest();
        loadProductRequest.resumeWithCompletionHandler(
                new BaseRequest.CompletionHandler<ProductInfo>() {
                    @Override
                    public void completionHandler(ProductInfo productInfo) {
                        data = productInfo;
                        notifyListenersDidLoadItems();
                    }

                    @Override
                    public void completionHandlerWithError(String error) {
                        notifyListenersDidLoadItemsWithError(error);
                    }
                });
    }
}
