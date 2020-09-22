package com.example.sphalaphalaapp;
import android.annotation.SuppressLint;
import android.content.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txt,reset;
    EditText email,password;
    Button btnLogin;
    FirebaseAuth fAuth;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email =findViewById(R.id.editTextTextEmailAddress);
       password =findViewById(R.id.editTextTextPassword);
        btnLogin=findViewById(R.id.button2);
       fAuth = FirebaseAuth.getInstance();

     txt=(TextView)findViewById(R.id.txtRegister);
     txt.setOnClickListener(this);
        reset=(TextView)findViewById(R.id.textView2);
        reset.setOnClickListener(this);
     btnLogin.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             String editTextTextEmailAddress= email.getText().toString().trim();
             String editTextTextPassword= password.getText().toString().trim();
             if(TextUtils.isEmpty(editTextTextEmailAddress)){
                 email.setError("Email is required");
                 return;
             }
             if(TextUtils.isEmpty(editTextTextPassword)){
                 password.setError("password is required");
                 return;
             }
             fAuth.signInWithEmailAndPassword(editTextTextEmailAddress,editTextTextPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                 @Override
                 public void onComplete(@NonNull Task<AuthResult> task) {
                     if(task.isSuccessful()){
                         Toast.makeText(MainActivity.this, "Logged in sucessfuly", Toast.LENGTH_SHORT).show();
                         //startActivity(new Intent(getApplicationContext(),home.class));
                     }else{
                          Toast.makeText(MainActivity.this, "Error occurred" +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                     }
                 }
             });
         }
     });
    }

    @Override
    public void onClick(View view) {
   Intent intent=new Intent(MainActivity.this,SIGNUP.class);
   startActivity(intent);
   Intent inten=new Intent(MainActivity.this,resetPassword.class);
   startActivity(inten);
    }
}