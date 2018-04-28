package com.lifeistech.android.todo_naribay;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class New_Activity extends AppCompatActivity {
    EditText titleText,contentText;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    FloatingActionButton fab2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_);

        titleText=(EditText)findViewById(R.id.titleText);
        contentText=(EditText)findViewById(R.id.contentText);
        fab2=(FloatingActionButton)findViewById(R.id.fab2);
         pref=getSharedPreferences("pref_memo",MODE_PRIVATE);


    }
    public void newA(View v){
        Intent intent=getIntent();
        int n=intent.getIntExtra("arrayListSize",0);

        Log.d("fab2Clicked","listSize="+n);
        String title=titleText.getText().toString();
        String content=contentText.getText().toString();

        editor=pref.edit();
        editor.putString("titleText"+n,title);
        editor.putString(title,content);
        editor.commit();

        setResult(RESULT_OK);


        finish();
    }
}
