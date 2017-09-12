package idea.engineering.com.singlescreensampleapp.presentation_layer.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import idea.engineering.com.singlescreensampleapp.R;
import idea.engineering.com.singlescreensampleapp.data_layer.model.Size;
import idea.engineering.com.singlescreensampleapp.presentation_layer.adapter.viewHolder.ProductSizeViewHolder;

public class ProductSizeAdapter extends RecyclerView.Adapter<ProductSizeViewHolder> {

    private List<Size> sizes;

    public ProductSizeAdapter() {
        sizes = new ArrayList<>();
    }

    public void addSizes(List<Size> sizes) {
        this.sizes.addAll(sizes);
        this.notifyDataSetChanged();
    }

    public void clearSizes() {
        sizes.clear();
    }

    @Override
    public ProductSizeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_size, parent, false);
        return new ProductSizeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductSizeViewHolder holder, int position) {
        holder.onBind(sizes.get(position));
    }

    @Override
    public int getItemCount() {
        return sizes.size();
    }
}
