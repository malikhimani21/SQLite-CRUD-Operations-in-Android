package com.example.sqlitecrud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by malik on 07/01/2017.
 */

public class ListDataAdapter extends ArrayAdapter {

    List list = new ArrayList();

    public ListDataAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        row = layoutInflater.inflate(R.layout.row_layout, parent, false);
        TextView NAME = (TextView) row.findViewById(R.id.text_user_name);
        TextView MOB = (TextView) row.findViewById(R.id.text_user_mobile);
        TextView EMAIL = (TextView) row.findViewById(R.id.text_user_email);

        DataProvider dataProvider = (DataProvider) this.getItem(position);
        NAME.setText(dataProvider.getName());
        MOB.setText(dataProvider.getMob());
        EMAIL.setText(dataProvider.getEmail());

        return row;
    }
}
