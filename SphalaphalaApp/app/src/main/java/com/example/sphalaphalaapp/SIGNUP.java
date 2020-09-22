package com.example.sphalaphalaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SIGNUP extends AppCompatActivity implements View.OnClickListener {

    TextView txtFname,lName,phone;
    TextView txt;
    EditText email,password,confirmPass;
    Button btnCreate;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_i_g_n_u_p2);

        txtFname = findViewById(R.id.textView5);
        txt =(TextView)findViewById(R.id.textView3);
        phone = findViewById(R.id.textView);
        email =findViewById(R.id.editTextTextEmailAddress);
        password =findViewById(R.id.editTextTextPassword2);
        confirmPass = findViewById(R.id.cPassword);
        btnCreate=findViewById(R.id.button2);

        fAuth = FirebaseAuth.getInstance();
        txt.setOnClickListener(this);
if(fAuth.getCurrentUser() !=null){
    startActivity(new Intent(getApplicationContext(),MainActivity.class));
    finish();
}
        btnCreate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String editTextTextEmailAddress= email.getText().toString().trim();
                String editTextTextPassword2= password.getText().toString().trim();
if(TextUtils.isEmpty(editTextTextEmailAddress)){
    email.setError("Email is required");
    return;
    }
    if(TextUtils.isEmpty(editTextTextPassword2)){
        password.setError("password is required");
        return;
}
    if(editTextTextPassword2.length()<6){
        password.setError("password is too short");
        return;
    }
//    //regist user
                fAuth.createUserWithEmailAndPassword(editTextTextEmailAddress,editTextTextPassword2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                      if(task.isSuccessful()){
                          Toast.makeText(SIGNUP.this, "User Created", Toast.LENGTH_SHORT).show();
                          startActivity(new Intent(getApplicationContext(),MainActivity.class));
                      }else{
                          Toast.makeText(SIGNUP.this, "Error occurred" +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                      }
                    }
                });
           }
      });
    }


    @Override
    public void onClick(View view) {
        Intent intent=new Intent(SIGNUP.this,MainActivity.class);
        startActivity(intent);
    }
}