package idea.engineering.com.singlescreensampleapp.presentation_layer.adapter.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import idea.engineering.com.singlescreensampleapp.R;
import idea.engineering.com.singlescreensampleapp.data_layer.model.ProductColor;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class ProductColorViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;

    public ProductColorViewHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.view_color_image_view);
    }

    public void onBind(ProductColor productColor) {
        Picasso.with(imageView.getContext())
                .load(productColor.getSwatchUrl())
                .transform(new RoundedCornersTransformation(90, 10))
                .fit()
                .into(imageView);
    }
}
