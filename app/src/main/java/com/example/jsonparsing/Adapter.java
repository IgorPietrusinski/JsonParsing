package com.example.jsonparsing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> implements Filterable {

    private Context mContext;
    private ArrayList<Product> mProductArrayList;
    private ArrayList<Product> mProductArrayListFull;
/*   private OnItemClickListener mClickListener;


    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mClickListener = listener;
    }*/
    //public Adapter(){}

    public Adapter(Context context, ArrayList<Product> productArrayList){
        this.mContext = context;
        this.mProductArrayList = productArrayList;
        this.mProductArrayListFull = new ArrayList<>(mProductArrayList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.product_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Product currentProduct = mProductArrayList.get(position);

        String name = currentProduct.getName();
        String description = currentProduct.getDescription();
        String imageUrl = currentProduct.getImageURL();

        holder.textViewProductName.setText(name);
        holder.textViewProductDescription.setText(description);
        Picasso.get().load(imageUrl).into(holder.imageViewProductImage);

  /*      holder.textViewProductName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentProduct.setSelected(!currentProduct.isSelected());;
                Toast.makeText(mContext, "test", Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mProductArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewProductName;
        public TextView textViewProductDescription;
        public ImageView imageViewProductImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewProductImage = itemView.findViewById(R.id.image_view_product);
            textViewProductName = itemView.findViewById(R.id.text_view_name);
            textViewProductDescription = itemView.findViewById(R.id.text_view_description);

/*            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mClickListener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            mClickListener.onItemClick(position);
                        }
                    }
                }
            });*/
        }
    }

    @Override
    public Filter getFilter() {
        return mFilter;
    }

    private Filter mFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Product> filteredList = new ArrayList<>();

            if(constraint == null || constraint.length() < 3){
                filteredList.addAll(mProductArrayListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Product product : mProductArrayListFull){
                    if(product.getName().toLowerCase().contains(filterPattern) || product.getDescription().toLowerCase().contains(filterPattern)){
                        filteredList.add(product);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
                mProductArrayList.clear();
                mProductArrayList.addAll((ArrayList) results.values);
                notifyDataSetChanged();
        }
    };
}
