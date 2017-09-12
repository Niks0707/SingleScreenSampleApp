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

    private TextView nameTextView;
    private TextView priceTextView;
    private TextView salePriceTextView;
    private ImageView imageView;

    public SimilarProductViewHolder(View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.view_similar_product_name_text_view);
        priceTextView = itemView.findViewById(R.id.view_similar_product_price_text_view);
        salePriceTextView = itemView.findViewById(R.id.view_similar_product_sale_price_text_view);
        imageView = itemView.findViewById(R.id.view_similar_product_image_view);

        priceTextView.setPaintFlags(priceTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

    public void onBind(ProductInfo productInfo) {
        if (productInfo.getProduct() != null) {
            nameTextView.setText(productInfo.getProduct().getRetailer());
            priceTextView.setText(productInfo.getProduct().getPrice());
            salePriceTextView.setText(productInfo.getProduct().getSalePrice());
            if (productInfo.getProduct().getPrimaryPhotos() != null
                    && productInfo.getProduct().getPrimaryPhotos().size() > 0) {
                imageView.setBackgroundColor(0);
                Picasso.with(imageView.getContext())
                        .load(productInfo.getProduct().getPrimaryPhotos().get(0).getWebUrl())
                        .transform(new RoundedCornersTransformation(30, 5))
                        .into(imageView);
            }
        }
    }
}
