package com.example.ithunnathorn.tututaxi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

/**
 * Created by ithunnathorn on 7/1/2017 AD.
 */

public class ContentAdapter extends ArrayAdapter<String> {

    Context context;
    String[] objects;
    LayoutInflater layoutInflater;

    public ContentAdapter(@NonNull Context context, String[] objects) {
        super(context, R.layout.row_listview,objects);

        this.context = context;
        this.objects = objects;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.row_listview, parent, false);
            }
            TextView contextTextView = (TextView) convertView.findViewById(R.id.textView3);
            contextTextView.setText(objects[position]);
            return convertView;

        }

    }

