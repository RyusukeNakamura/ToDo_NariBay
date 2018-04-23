package com.lifeistech.android.todo_naribay;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by owner on 2018/04/22.
 */

public class CardAdapter extends ArrayAdapter<Card> {
    List<Card> dCards;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    public CardAdapter(Context content, int layoutResourceId, List<Card> objects) {
        super(content, layoutResourceId, objects);
        dCards = objects;
    }
    @Override
    public Card getItem(int position){
        return dCards.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(convertView);
        }else{
            viewHolder=(ViewHolder)convertView.getTag();
        }
        final Card item=getItem(position);

        if(item!=null){

        }

        return convertView;

    }

    public static class ViewHolder {
        CheckBox checkBox;
        TextView textView;

        public ViewHolder(View v) {
            checkBox = (CheckBox) v.findViewById(R.id.checkBox);
            textView = (TextView) v.findViewById(R.id.textView);
        }
    }
}

