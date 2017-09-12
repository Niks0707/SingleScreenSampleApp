package idea.engineering.com.singlescreensampleapp.presentation_layer.adapter.viewHolder;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import idea.engineering.com.singlescreensampleapp.R;
import idea.engineering.com.singlescreensampleapp.data_layer.model.Size;

public class ProductSizeViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;

    public ProductSizeViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.view_size_text_view);
    }

    public void onBind(Size size) {
        textView.setText(size.getName());
    }
}
