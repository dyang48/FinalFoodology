package com.example.foodology;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Customization extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customization);

        this.setTitle("Customization");
    }

    public void clickSubmitSurvey(View view) {
        Intent intent = new Intent(this, SubmitSurvey.class);
        startActivity(intent);
    }
}
