package idea.engineering.com.singlescreensampleapp.presentation_layer.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import idea.engineering.com.singlescreensampleapp.R;
import idea.engineering.com.singlescreensampleapp.data_layer.model.Photo;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class ProductImagePageAdapter extends PagerAdapter {

    private List<Photo> imageUrls;

    public ProductImagePageAdapter() {
        imageUrls = new ArrayList<>();
    }

    public void addPhotoList(List<Photo> photoList) {
        this.imageUrls.addAll(photoList);
        this.notifyDataSetChanged();
    }

    public void clearImageUrls() {
        imageUrls.clear();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) container.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewGroup layout = (ViewGroup)
                inflater.inflate(R.layout.view_image_page, container, false);

        final ImageView imageView = layout.findViewById(R.id.view_image_page_image_view);
        imageView.setBackgroundColor(0);
        Picasso.with(imageView.getContext())
                .load(imageUrls.get(position).getWebUrl())
                .fit()
                .centerInside()
                .transform(new RoundedCornersTransformation(30, 5))
                .into(imageView);
        container.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return imageUrls.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
