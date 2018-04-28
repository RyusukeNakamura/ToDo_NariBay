package com.lifeistech.android.todo_naribay;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Detail_Activity extends AppCompatActivity {
    EditText editTitle,editContent;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_);
        editTitle=(EditText)findViewById(R.id.editTitle);
        editContent=(EditText)findViewById(R.id.editContent);

        Intent intent=getIntent();
        pref=getSharedPreferences("pref_memo",MODE_PRIVATE);
        editor=pref.edit();

        int id=intent.getIntExtra("id",0);
        editTitle.setText(pref.getString("titleText"+id,null));
        String t=editTitle.getText().toString();
        editContent.setText(pref.getString(t,null));


    }
}
