package com.example.lab5a;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    private int[] donut = {R.drawable.donut_yellow_1, R.drawable.tasty_donut_1, R.drawable.green_donut_1,R.drawable.donut_red_1 };
    private ImageView ivIcon;
    private TextView tvShopName, tvPrice, tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        tvShopName = findViewById(R.id.tvShopName);
        ivIcon = findViewById(R.id.ivIcon);
        tvPrice = findViewById(R.id.tvPrice);
        tvTitle = findViewById(R.id.tvTitle);

        Bundle data = getIntent().getExtras();
        if (data != null){
            ivIcon.setImageResource(donut[data.getInt("id", 0)]);
            tvTitle.setText(data.getString("title"));
            tvPrice.setText(data.getString("price"));
            tvShopName.setText(data.getString("shopname"));
        }

    }
}