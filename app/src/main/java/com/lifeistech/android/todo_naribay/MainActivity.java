package com.lifeistech.android.todo_naribay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void detail(View v){
        Intent intent=new Intent(this,Detail_Activity.class);
        startActivity(intent);
    }
}
