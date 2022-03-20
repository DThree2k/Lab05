package com.example.lab5a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ProductAdapter extends BaseAdapter {

    private Context context;
    private int idLayout;
    private List<Product> listProducts;
    private int positionSelect = -1;
    private AdapterView.OnItemClickListener onItemClickListener;

    public ProductAdapter(Context context, int idLayout, List<Product> listProducts) {
        this.context = context;
        this.idLayout = idLayout;
        this.listProducts = listProducts;
    }

    @Override
    public int getCount() {
        if (listProducts.size() != 0 && !listProducts.isEmpty()) {
            return listProducts.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(idLayout, parent, false);
        }

        TextView tvProductName = (TextView) convertView.findViewById(R.id.tvTitleProduct);
        TextView tvProducer = (TextView) convertView.findViewById(R.id.tvTitleShop);
        TextView tvPrice = (TextView) convertView.findViewById(R.id.tvPrice);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.logo);
        final RelativeLayout relativeLayout = (RelativeLayout) convertView.findViewById(R.id.idRelativeLayout);
        final Product product = listProducts.get(position);

        if (listProducts != null && !listProducts.isEmpty()) {
            tvProductName.setText(product.getTitle());
            tvProducer.setText(product.getShopName());
            tvPrice.setText(product.getPrice());
            int idProduct = product.getId();
            switch (idProduct) {
                case 0:
                    imageView.setImageResource(R.drawable.donut_yellow_1);
                    break;
                case 1:
                    imageView.setImageResource(R.drawable.tasty_donut_1);
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.green_donut_1);
                    break;
                case 3:
                    imageView.setImageResource(R.drawable.donut_red_1);
                    break;
                default:
                    break;
            }
        }

        final View view = convertView;
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null)
                        onItemClickListener.onItemClick(null, view, position, -1);
            }
        });

        return convertView;
    }
    public void setOnItemClickListener( AdapterView.OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public void updateProductssList(List<Product> newlist) {
        listProducts.clear();
        listProducts.addAll(newlist);
        this.notifyDataSetChanged();
    }
}
