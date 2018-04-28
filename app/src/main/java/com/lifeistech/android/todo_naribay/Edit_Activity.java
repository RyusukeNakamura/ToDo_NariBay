package com.lifeistech.android.todo_naribay;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Edit_Activity extends AppCompatActivity {
    EditText editTitle,editContent;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_);

        editTitle=(EditText)findViewById(R.id.editTitle);
        editContent=(EditText)findViewById(R.id.editContent);

        pref=getSharedPreferences("pref_memo",MODE_PRIVATE);
        editor=pref.edit();

        id=pref.getInt("clickedId",0);
        Log.d("idNumber","id="+id);

        editTitle.setText(pref.getString("titleText"+id,null));
        editContent.setText(pref.getString("contentText"+id,null));


    }
    public void doneEdit(View v){
        String t=editTitle.getText().toString();
        String c=editContent.getText().toString();

        //編集内容保存
        editor.putString("titleText"+id,t);
        editor.putString("contentText"+id,c);
        editor.commit();

        setResult(RESULT_OK);
        finish();
    }

}
