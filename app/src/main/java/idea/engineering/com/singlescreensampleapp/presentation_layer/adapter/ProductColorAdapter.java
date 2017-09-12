package idea.engineering.com.singlescreensampleapp.presentation_layer.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import idea.engineering.com.singlescreensampleapp.R;
import idea.engineering.com.singlescreensampleapp.data_layer.model.ProductColor;
import idea.engineering.com.singlescreensampleapp.presentation_layer.adapter.viewHolder.ProductColorViewHolder;

public class ProductColorAdapter extends RecyclerView.Adapter<ProductColorViewHolder> {

    private List<ProductColor> colors;

    public ProductColorAdapter() {
        colors = new ArrayList<>();
    }

    public void addColors(List<ProductColor> colors) {
        this.colors.addAll(colors);
        this.notifyDataSetChanged();
    }

    public void clearColors() {
        colors.clear();
    }

    @Override
    public ProductColorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_color, parent, false);
        return new ProductColorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductColorViewHolder holder, int position) {
        holder.onBind(colors.get(position));
    }

    @Override
    public int getItemCount() {
        return colors.size();
    }
}
