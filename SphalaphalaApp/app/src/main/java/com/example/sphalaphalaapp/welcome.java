package com.example.sphalaphalaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class welcome extends AppCompatActivity  implements View.OnClickListener{
TextView txt;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        btn=(Button)findViewById(R.id.button3);
        btn.setOnClickListener(this);
        txt= (TextView)findViewById(R.id.textView7);
        txt.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
       Intent intent=new Intent(welcome.this,Home.class);
        startActivity(intent);
        Intent inten=new Intent(welcome.this,homeOfnav.class);
        startActivity(inten);
    }
}