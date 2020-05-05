package com.example.foodology;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MyFavorite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_favorite);

        this.setTitle("My Favorite");
    }
}
