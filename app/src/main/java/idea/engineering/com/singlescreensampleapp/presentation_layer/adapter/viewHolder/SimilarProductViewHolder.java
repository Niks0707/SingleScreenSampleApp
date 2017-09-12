package idea.engineering.com.singlescreensampleapp.presentation_layer.adapter.viewHolder;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import idea.engineering.com.singlescreensampleapp.R;
import idea.engineering.com.singlescreensampleapp.data_layer.model.ProductInfo;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class SimilarProductViewHolder extends RecyclerView.ViewHolder {

    private TextView retailerTextView;
    private TextView priceTextView;
    private TextView salePriceTextView;
    private ImageView imageView;

    public SimilarProductViewHolder(View itemView) {
        super(itemView);
        retailerTextView = itemView.findViewById(R.id.view_similar_product_retailer_text_view);
        priceTextView = itemView.findViewById(R.id.view_similar_product_price_text_view);
        salePriceTextView = itemView.findViewById(R.id.view_similar_product_sale_price_text_view);
        imageView = itemView.findViewById(R.id.view_similar_product_image_view);

        priceTextView.setPaintFlags(priceTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

    public void onBind(ProductInfo productInfo) {
        if (productInfo.getProduct() != null) {
            retailerTextView.setText(productInfo.getProduct().getRetailer());

            priceTextView.setText(priceTextView.getResources().getString(
                    R.string.price,
                    productInfo.getProduct().getPrice()));

            Float sale = productInfo.getProduct().getPrice() != 0
                    ? productInfo.getProduct().getSalePrice() / productInfo.getProduct().getPrice() * 100 :
                    0f;
            salePriceTextView.setText(priceTextView.getResources().getString(
                    R.string.sale_price,
                    productInfo.getProduct().getSalePrice(),
                    sale));

            if (productInfo.getProduct().getPrimaryPhotos() != null
                    && productInfo.getProduct().getPrimaryPhotos().size() > 0) {

                imageView.setBackgroundColor(0);
                Picasso.with(imageView.getContext())
                        .load(productInfo.getProduct().getPrimaryPhotos().get(0).getWebUrl())
                        .fit()
                        .centerCrop()
                        .transform(new RoundedCornersTransformation(15, 5))
                        .into(imageView);
            }
        }
    }
}
