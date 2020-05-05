package com.example.foodology;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MyAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        this.setTitle("My Account");
    }

    public void updateInfo(View view) {
        Intent intent = new Intent(this, UpdateInfo.class);
        startActivity(intent);
    }
}
