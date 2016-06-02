package com.example.bay.listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by BAY on 6/2/2016.
 */
public class NamaAdapter extends ArrayAdapter<String> {
    Context context;
    int resourceId;
    List<String> textList;

    public NamaAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resourceId=resource;
        this.textList=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View root=convertView;


        if(root==null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            root = inflater.inflate(resourceId, parent, false);
            TextView textView = (TextView) root.findViewById(R.id.text_item);
            textView.setText(textList.get(position));
        }
        return root;
    }

    static class NameHolder{
        TextView textView;
    }
}
