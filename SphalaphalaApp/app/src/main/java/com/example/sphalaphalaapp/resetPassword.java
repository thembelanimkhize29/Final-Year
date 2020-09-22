package com.example.sphalaphalaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class resetPassword extends AppCompatActivity {
 Button btnReset;
 EditText email;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        fAuth = FirebaseAuth.getInstance();
        btnReset=(Button)findViewById(R.id.button);
        email=(EditText)findViewById(R.id.resetPass);
btnReset.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String useremail=email.getText().toString();
        if(TextUtils.isEmpty(useremail)){
            Toast.makeText(resetPassword.this, "Write a valid email address first", Toast.LENGTH_SHORT).show();
        }else{
            fAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
if(task.isSuccessful()){
    Toast.makeText(resetPassword.this, "Please check your email account... ", Toast.LENGTH_SHORT).show();
    startActivity(new Intent(resetPassword.this,MainActivity.class));
}else{
    String message=task.getException().getMessage();
    Toast.makeText(resetPassword.this, "Error occured... "+message, Toast.LENGTH_SHORT).show();
}
                }
            });
        }
    }
});
    }
}