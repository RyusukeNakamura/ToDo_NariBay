package com.lifeistech.android.todo_naribay;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static com.lifeistech.android.todo_naribay.Detail_Activity.REQUEST_CODE_EDIT;

public class MainActivity extends AppCompatActivity {


    ArrayList<Card> arrayList;
    CardAdapter cardAdapter;
    ListView listView;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    static final int REQUEST_CODE_NEW = 1;
    static final int REQUEST_CODE_DETAIL=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        arrayList = new ArrayList<Card>();


        pref = getSharedPreferences("pref_memo", MODE_PRIVATE);
        editor = pref.edit();

        Log.d("arrayList size", "" + arrayList.size());

        for (int i = 0; i < pref.getInt("array_size",1); i++) {
            Log.d("for", "arraySize=" + pref.getInt("array_size",1));
            arrayList.add(new Card(pref.getString("titleText" + i, null)));
        }

        cardAdapter = new CardAdapter(this, R.layout.card, arrayList);
        listView.setAdapter(cardAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getApplicationContext(),Detail_Activity.class);
                editor.putInt("clickedId",i);
                editor.commit();
                startActivityForResult(intent,REQUEST_CODE_DETAIL);

            }
        });

    }

    public void add(View v) {
        Intent intent = new Intent(this, New_Activity.class);
        intent.putExtra("arrayListSize", arrayList.size());
        startActivityForResult(intent, REQUEST_CODE_NEW);
    }


   /* public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }*/



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == REQUEST_CODE_NEW && resultCode == RESULT_OK) {
            int size = arrayList.size();
            Log.d("addList", "arraySize=" + size);
            arrayList.add(new Card(pref.getString("titleText" + size, null)));
            cardAdapter = new CardAdapter(this, R.layout.card, arrayList);
            listView.setAdapter(cardAdapter);
            //新しくaddされたsizeを保存
            editor.putInt("array_size",arrayList.size());
            editor.commit();
        }

        if(requestCode==REQUEST_CODE_DETAIL&&resultCode==RESULT_OK){
            int id=pref.getInt("clickedId",100);
            Log.d("requestCodeEdit","id="+id);


            arrayList.set(id,new Card(pref.getString("titleText"+id,null)));
            cardAdapter = new CardAdapter(this, R.layout.card, arrayList);
            listView.setAdapter(cardAdapter);}

    }
}
