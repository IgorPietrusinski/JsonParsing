package com.example.jsonparsing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    LayoutInflater inflater;
    List<Product> products;

    public Adapter (Context ctx, List<Product> products){
        this.inflater = LayoutInflater.from(ctx);
        this.products = products;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView productName, productDescription;
        ImageView productImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productName = itemView.findViewById(R.id.text_product_name);
            productDescription = itemView.findViewById(R.id.text_product_description);
            productImage = itemView.findViewById(R.id.image_product_view);
        }
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_list_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        holder.productName.setText(products.get(position).getName());
        holder.productDescription.setText(products.get(position).getDescription());
        Picasso.get().load(products.get(position).getThumbnailURL()).into(holder.productImage);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
