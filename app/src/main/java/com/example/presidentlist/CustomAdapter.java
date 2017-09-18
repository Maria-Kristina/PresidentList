package com.example.presidentlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by M-K on 23.8.2017.
 */

public class CustomAdapter extends BaseAdapter {
    private Context mContext;
    private List<President> presidentList;
    private LayoutInflater mInflater;
    private TextView nameView;
    private TextView aloitusView;
    private TextView lopetusView;


    public CustomAdapter(Context context, List<President> list) {
        this.mContext = context;
        this.presidentList = list;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount(){
        return presidentList.size();
    }

    @Override
    public President getItem(int position) {
        return presidentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView (int position, View convertView, ViewGroup parent) {

        View rowView = mInflater.inflate(R.layout.list_item_layout, parent, false);
        nameView = (TextView)rowView.findViewById(R.id.PresidentName);
        aloitusView = (TextView)rowView.findViewById(R.id.aloitus);
        lopetusView = (TextView)rowView.findViewById(R.id.lopetus);

        President president = (President) getItem(position);
        nameView.setText(president.lastName + ", "+ president.firstName);
        aloitusView.setText(String.valueOf(president.aloitusVuosi));
        lopetusView.setText(String.valueOf(president.lopetusVuosi));

        return rowView;
    }
}
