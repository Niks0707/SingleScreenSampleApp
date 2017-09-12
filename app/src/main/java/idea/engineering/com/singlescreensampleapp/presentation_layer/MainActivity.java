package idea.engineering.com.singlescreensampleapp.presentation_layer;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.viewpagerindicator.CirclePageIndicator;

import idea.engineering.com.singlescreensampleapp.R;
import idea.engineering.com.singlescreensampleapp.data_layer.data_source.BaseDataSource;
import idea.engineering.com.singlescreensampleapp.data_layer.data_source.ProductDataSource;
import idea.engineering.com.singlescreensampleapp.data_layer.data_source.SimilarProductsDataSource;
import idea.engineering.com.singlescreensampleapp.data_layer.model.ProductInfo;
import idea.engineering.com.singlescreensampleapp.data_layer.model.SimilarProducts;
import idea.engineering.com.singlescreensampleapp.presentation_layer.adapter.ProductColorAdapter;
import idea.engineering.com.singlescreensampleapp.presentation_layer.adapter.ProductImagePageAdapter;
import idea.engineering.com.singlescreensampleapp.presentation_layer.adapter.ProductSizeAdapter;
import idea.engineering.com.singlescreensampleapp.presentation_layer.adapter.SimilarProductAdapter;

public class MainActivity extends AppCompatActivity {

    private static final int NUMBER_SIMILAR_PRODUCTS_IN_LINE = 2;

    private ProductImagePageAdapter productImagePageAdapter;
    private ProductSizeAdapter productSizeAdapter;
    private ProductColorAdapter productColorAdapter;
    private SimilarProductAdapter similarProductAdapter;

    private BaseDataSource.DataSourceListener<ProductInfo> productDataSourceListener;
    private BaseDataSource.DataSourceListener<SimilarProducts> similarProductsDataSourceListener;

    private ProductDataSource productDataSource;
    private SimilarProductsDataSource similarProductsDataSource;

    public MainActivity() {
        productImagePageAdapter = new ProductImagePageAdapter();
        productSizeAdapter = new ProductSizeAdapter();
        productColorAdapter = new ProductColorAdapter();
        similarProductAdapter = new SimilarProductAdapter();

        productDataSource = new ProductDataSource();
        similarProductsDataSource = new SimilarProductsDataSource();

        productDataSourceListener = new BaseDataSource.DataSourceListener<ProductInfo>() {
            @Override
            public void notifyWillLoadItems() {

            }

            @Override
            public void notifyDidLoadItems(ProductInfo productInfo) {
                if (productInfo.getProduct() != null) {
                    setupViews(productInfo);
                    if (productInfo.getProduct().getPrimaryPhotos() != null) {
                        productImagePageAdapter.addPhotoList(productInfo.getProduct().getPrimaryPhotos());
                    }
                    if (productInfo.getProduct().getSecondaryPhotos() != null) {
                        productImagePageAdapter.addPhotoList(productInfo.getProduct().getSecondaryPhotos());
                    }
                    if (productInfo.getProduct().getSizes() != null) {
                        productSizeAdapter.addSizes(productInfo.getProduct().getSizes());
                    }
                    if (productInfo.getProduct().getProductColors() != null) {
                        productColorAdapter.addColors(productInfo.getProduct().getProductColors());
                    }
                }
            }

            @Override
            public void notifyDidLoadItemsWithError(String error) {

            }
        };

        similarProductsDataSourceListener = new BaseDataSource.DataSourceListener<SimilarProducts>() {
            @Override
            public void notifyWillLoadItems() {

            }

            @Override
            public void notifyDidLoadItems(SimilarProducts data) {
                similarProductAdapter.addProducts(data.getSimilarProducts());
            }

            @Override
            public void notifyDidLoadItemsWithError(String error) {

            }
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupImageViewPager();
        setupSizeRecyclerView();
        setupColorsRecyclerView();
        setupSimilarProductRecyclerView();
    }

    @Override
    protected void onStart() {
        productDataSource.addListener(productDataSourceListener);
        productDataSource.reloadData();
        similarProductsDataSource.addListener(similarProductsDataSourceListener);
        similarProductsDataSource.reloadData();
        super.onStart();
    }

    @Override
    protected void onStop() {
        productDataSource.removeListener(productDataSourceListener);
        similarProductsDataSource.removeListener(similarProductsDataSourceListener);

        productImagePageAdapter.clearImageUrls();
        productColorAdapter.clearColors();
        productSizeAdapter.clearSizes();
        similarProductAdapter.clearProducts();

        super.onStop();
    }

    private void setupViews(ProductInfo productInfo) {
        TextView nameTextView = ((TextView) findViewById(R.id.name_text_view));
        nameTextView.setText(productInfo.getProduct().getRetailer());

        TextView priceTextView = ((TextView) findViewById(R.id.price_text_view));
        priceTextView.setPaintFlags(priceTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        priceTextView.setText("$" + productInfo.getProduct().getPrice());

        TextView salePriceTextView = ((TextView) findViewById(R.id.sale_price_text_view));
        salePriceTextView.setText("$" + productInfo.getProduct().getSalePrice());

        TextView returnsPolicyTextView = ((TextView) findViewById(R.id.return_policy_text_view));
        returnsPolicyTextView.setText(productInfo.getProduct().getReturnPolicy());

        TextView recommendationTextView = ((TextView) findViewById(R.id.recommendation_text_view));
        if (productInfo.getRecommendationLogic() != null && productInfo.getRecommendationLogic().size() > 0) {
            recommendationTextView.setText(productInfo
                    .getRecommendationLogic().get(0).replace("U+1", "\\u"));
        }

        TextView descriptionTextView = ((TextView) findViewById(R.id.description_text_view));
        descriptionTextView.setText(productInfo.getProduct().getDescription());
    }

    private void setupSizeRecyclerView() {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(
                MainActivity.this,
                LinearLayoutManager.HORIZONTAL,
                false);
        RecyclerView recyclerView = ((RecyclerView) findViewById(R.id.size_recycler_view));
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(productSizeAdapter);
    }

    private void setupColorsRecyclerView() {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(
                MainActivity.this,
                LinearLayoutManager.HORIZONTAL,
                false);
        RecyclerView recyclerView = ((RecyclerView) findViewById(R.id.color_recycler_view));
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(productColorAdapter);
    }

    private void setupImageViewPager() {
        ViewPager viewPager = ((ViewPager) findViewById(R.id.image_view_pager));
        viewPager.setAdapter(productImagePageAdapter);
        CirclePageIndicator pageIndicator = ((CirclePageIndicator)
                findViewById(R.id.image_view_pager_indicator));
        pageIndicator.setViewPager(viewPager);
    }

    private void setupSimilarProductRecyclerView() {
        GridLayoutManager manager = new GridLayoutManager(
                MainActivity.this,
                NUMBER_SIMILAR_PRODUCTS_IN_LINE);
        RecyclerView recyclerView = ((RecyclerView) findViewById(R.id.similar_recycler_view));
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(similarProductAdapter);
    }
}
