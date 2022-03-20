package com.example.lab5a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<Product> listProduct;
    private ListView listView;
    private EditText etSearch;
    private ImageButton btnSearch;
    private ProductAdapter adapter;
    private Button btnDonut, btnPinkDonut,btnFloating;
    private List<Product> defaultProducts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.lvProduct);
        listProduct = new ArrayList<>();
        listProduct.add(new Product(0, "Tasty Donut", "Spicy tasty donut family", "$10.00"));
        listProduct.add(new Product(1, "Pink Donut", "Spicy tasty donut family", "$20.00"));
        listProduct.add(new Product(2, "Floating Donut", "Spicy tasty donut family", "$30.00"));
        listProduct.add(new Product(3, "Tasty Donut", "Spicy tasty donut family", "$40.00"));

        defaultProducts = new ArrayList<>();
        defaultProducts.addAll(listProduct);

        adapter = new ProductAdapter(this, R.layout.custom_list_view, listProduct);
        adapter.setOnItemClickListener(this);
        listView.setAdapter(adapter);


        btnSearch = findViewById(R.id.btnSearch);
        etSearch = findViewById(R.id.etSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchContent = etSearch.getText().toString().trim();
                List<Product> listSearch = isTitleInListProduct(searchContent, listProduct);
                adapter.updateProductssList(listSearch);
            }
        });


        btnDonut = findViewById(R.id.btnDonut);
        btnFloating = findViewById(R.id.btnFloating);
        btnPinkDonut = findViewById(R.id.btnPinkDonut);

        setColorButton(btnDonut, btnPinkDonut,btnFloating );

        btnDonut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.updateProductssList(defaultProducts);
                setColorButton(btnDonut, btnPinkDonut,btnFloating );
            }
        });
        btnFloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setColorButton(btnFloating, btnPinkDonut,btnDonut );
                List<Product> listSearch = isTitleInListProduct("Floating", defaultProducts);
                adapter.updateProductssList(listSearch);
            }
        });

        btnPinkDonut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setColorButton(btnPinkDonut, btnFloating,btnDonut );
                List<Product> listSearch = isTitleInListProduct("Pink", defaultProducts);
                adapter.updateProductssList(listSearch);
            }
        });



    }

    public void setColorButton(Button activeButton, Button deactiveButton1,Button deactiveButton2){
        activeButton.setBackgroundTintList(this.getResources().getColorStateList(R.color.yellow_button));
        deactiveButton1.setBackgroundTintList(this.getResources().getColorStateList(R.color.white_button));
        deactiveButton2.setBackgroundTintList(this.getResources().getColorStateList(R.color.white_button));
    }

    public List<Product> isTitleInListProduct(String title, List<Product> list){
        List<Product> products = new ArrayList<>();
        for (Product item : list){
            if (item.getTitle().indexOf(title) >= 0)
                products.add(item);
        }
        return products;
    }



    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(MainActivity.this, SubActivity.class);
        intent.putExtra("id", listProduct.get(i).getId());
        intent.putExtra("title", listProduct.get(i).getTitle());
        intent.putExtra("price", listProduct.get(i).getPrice());
        intent.putExtra("shopname", listProduct.get(i).getShopName());
        startActivity(intent);
    }
}