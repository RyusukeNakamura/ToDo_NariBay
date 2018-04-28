package com.lifeistech.android.todo_naribay;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Detail_Activity extends AppCompatActivity {
    TextView contentTextView;
    SharedPreferences pref;
    ListView oneListView;
    int id;
    int flag=0;

    public static final int REQUEST_CODE_EDIT=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_);
        pref=getSharedPreferences("pref_memo",MODE_PRIVATE);
        id=pref.getInt("clickedId",100);
        oneListView=(ListView)findViewById(R.id.oneListView);
        contentTextView=(TextView)findViewById(R.id.contentTextView);
        String title=pref.getString("titleText"+id,null);

        ArrayList<Card> al=new ArrayList<Card>();
        al.add(new Card(title));
        CardAdapter adapter=new CardAdapter(this,R.layout.card,al);
        oneListView.setAdapter(adapter);
        contentTextView.setText(pref.getString("contentText"+id,null));

    }
    public void edit(View v){
        Intent intent=new Intent(this,Edit_Activity.class);
        startActivityForResult(intent,REQUEST_CODE_EDIT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == REQUEST_CODE_EDIT && resultCode == RESULT_OK) {
            Log.d("detail","id to main");

            setResult(RESULT_OK);
            finish();
        }
    }


}
