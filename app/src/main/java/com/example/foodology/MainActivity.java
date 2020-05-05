package com.example.foodology;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private FirebaseAuth mrAuth;
    private  FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailEditText = (EditText) findViewById(R.id.edit_text_email);
        passwordEditText = (EditText) findViewById(R.id.edit_text_password);
        mrAuth = FirebaseAuth.getInstance();
        mAuthStateListener=new FirebaseAuth.AuthStateListener() {


            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser=mrAuth.getCurrentUser();
                if (mFirebaseUser !=null) {
                    Toast.makeText(MainActivity.this,"You are logged in",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(MainActivity.this,Act2.class);
                    startActivity(i);
                }
                else{}
                Toast.makeText(MainActivity.this,"Please Login",Toast.LENGTH_SHORT).show();

            }

    };
        Button button=(Button)findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if ((email.isEmpty())){
                    emailEditText.setError("Please enter email id");
                    emailEditText.requestFocus();
                }
                else if (password.isEmpty()){
                    passwordEditText.setError("Please enter your password");
                    passwordEditText.requestFocus();
                }
                else if (email.isEmpty()&& password.isEmpty()){
                    Toast.makeText(MainActivity.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else if (email.isEmpty()&&password.isEmpty()){
                    mrAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>()
                            {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task)
                                {
                                    if (!task.isSuccessful())
                                    {
                                        Toast.makeText(MainActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                                        Log.v("Error",task.getException().toString());
                                    }
                                    else
                                    {
                                        Toast.makeText(MainActivity.this, task.getResult().getUser().getEmail() + " signed up successful",
                                                Toast.LENGTH_SHORT).show();
                                        Intent i= new Intent(MainActivity.this,Act2.class);
                                        startActivity(i);
                                    }
                                }
                            });
                }
                else {
                    Toast.makeText(MainActivity.this,"Error Occured", Toast.LENGTH_SHORT).show();
                }



            }
        });
    Button button1=(Button)findViewById(R.id.signup);
    button1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(MainActivity.this,Act2.class);
            startActivity(intent);

        }
    });}}









//public class MainActivity extends AppCompatActivity {

    //@Override
   // protected void onCreate(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
    //}

    //public void clickAsianFood(View view) {
        //Intent intent = new Intent(this, AsianFoodActivity.class);
      //  startActivity(intent);
    //}

    //public void clickCustomization(View view) {
       // Intent intent = new Intent(this, Customization.class);
       // startActivity(intent);
   // }

    //public void clickNearMe(View view) {
       // Intent intent = new Intent(this, NearMe.class);
        //startActivity(intent);
    //}

   // public void clickMyFavorite(View view) {
      //  Intent intent = new Intent(this, MyFavorite.class);
      //  startActivity(intent);
    //}

   // public void clickMyAccount(View view) {
      //  Intent intent = new Intent(this, MyAccount.class);
     //   startActivity(intent);
   // }
//}
