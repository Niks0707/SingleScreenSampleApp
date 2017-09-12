package idea.engineering.com.singlescreensampleapp.data_layer.data_source;

import idea.engineering.com.singlescreensampleapp.data_layer.model.SimilarProducts;
import idea.engineering.com.singlescreensampleapp.data_layer.requests.BaseRequest;
import idea.engineering.com.singlescreensampleapp.data_layer.requests.LoadSimilarProductsRequest;

public class SimilarProductsDataSource extends BaseDataSource<SimilarProducts> {

    LoadSimilarProductsRequest loadSimilarProductsRequest;

    @Override
    public void reloadData() {
        notifyListenersWillLoadItems();

        loadSimilarProductsRequest = new LoadSimilarProductsRequest();
        loadSimilarProductsRequest.resumeWithCompletionHandler(
                new BaseRequest.CompletionHandler<SimilarProducts>() {
                    @Override
                    public void completionHandler(SimilarProducts similarProducts) {
                        data = similarProducts;
                        notifyListenersDidLoadItems();
                    }

                    @Override
                    public void completionHandlerWithError(String error) {
                        notifyListenersDidLoadItemsWithError(error);
                    }
                });
    }
}
