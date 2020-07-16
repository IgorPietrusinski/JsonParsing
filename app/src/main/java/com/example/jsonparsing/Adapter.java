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

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Product> mProductArrayList;


    public Adapter(Context context, ArrayList<Product> productArrayList){
        this.mContext = context;
        this.mProductArrayList = productArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.custom_list_layout, parent);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product currentProduct = mProductArrayList.get(position);

        String imageUrl = currentProduct.getImageURL();
        String name = currentProduct.getName();
        String description = currentProduct.getDescription();

        holder.textViewProductName.setText(name);
        holder.textViewProductDescription.setText(description);
        Picasso.get().load(imageUrl).fit().centerInside().into(holder.imageViewProductImage);
    }

    @Override
    public int getItemCount() {
        return mProductArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewProductName, textViewProductDescription;
        ImageView imageViewProductImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewProductName = itemView.findViewById(R.id.text_product_name);
            textViewProductDescription = itemView.findViewById(R.id.text_product_description);
            imageViewProductImage = itemView.findViewById(R.id.image_product_view);
        }
    }

}
