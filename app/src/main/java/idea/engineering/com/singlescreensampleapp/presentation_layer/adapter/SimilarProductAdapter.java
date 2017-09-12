package idea.engineering.com.singlescreensampleapp.presentation_layer.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import idea.engineering.com.singlescreensampleapp.R;
import idea.engineering.com.singlescreensampleapp.data_layer.model.ProductInfo;
import idea.engineering.com.singlescreensampleapp.presentation_layer.adapter.viewHolder.SimilarProductViewHolder;

public class SimilarProductAdapter extends RecyclerView.Adapter<SimilarProductViewHolder> {

    private List<ProductInfo> products;

    public SimilarProductAdapter() {
        products = new ArrayList<>();
    }

    public void addProducts(List<ProductInfo> products) {
        this.products.addAll(products);
        this.notifyDataSetChanged();
    }

    public void clearProducts() {
        products.clear();
    }

    @Override
    public SimilarProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_similar_product, parent, false);
        return new SimilarProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimilarProductViewHolder holder, int position) {
        holder.onBind(products.get(position));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
