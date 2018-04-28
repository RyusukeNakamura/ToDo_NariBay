package com.lifeistech.android.todo_naribay;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by owner on 2018/04/22.
 */

public class CardAdapter extends ArrayAdapter<Card> {
    ArrayList<Card> arrayList;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    CheckBox checkBox;
    TextView textView;

    public CardAdapter(Context context, int layoutResourceId, ArrayList<Card> objects) {
        super(context, layoutResourceId, objects);
        arrayList = objects;
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Card getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card, null);
        }
        final Card item = this.getItem(position);

        if (item != null) {
            final TextView textView = (TextView) convertView.findViewById(R.id.textView);
            textView.setText(item.getTitleText());

            final CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);


            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (checkBox.isChecked()) {
                        Toast.makeText(getContext(), "completed", Toast.LENGTH_LONG).show();
                        item.setCheck(true);

                    }else {
                        item.setCheck(false);
                    }
                }
            });


        }

        return convertView;
    }


}