package com.example.foodology;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateInfo extends AppCompatActivity {

    EditText nameET;
    EditText addressET;
    EditText genderET;
    EditText ageET;
    String name;
    String address;
    String gender;
    String age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_info);

        nameET=findViewById(R.id.name_info);
        addressET=findViewById(R.id.address_info);
        genderET=findViewById(R.id.gender_info);
        ageET=findViewById(R.id.age_info);
        name=nameET.getText().toString();
        address=addressET.getText().toString();
        gender=genderET.getText().toString();
        age=ageET.getText().toString();

    }

    public void submitUpdate(View view){
        Toast.makeText(getApplicationContext(),"SUCCESSFULLY UPDATED",Toast.LENGTH_SHORT).show();
    }
}
