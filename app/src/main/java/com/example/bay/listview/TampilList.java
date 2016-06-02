package com.example.bay.listview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by BAY on 6/2/2016.
 */
public class TampilList extends Activity {

    private ArrayList<String> listPerson=new ArrayList<>();

    private ListView listView;
    private NamaAdapter namaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        final DatabaseHelper databaseHelper=new DatabaseHelper(this);
        ArrayList<Person> arrayList=databaseHelper.getAll();
        listView=(ListView)findViewById(R.id.list_view);

        if(!arrayList.isEmpty()){
            int length=arrayList.size();

            for (int i=0;i<length;i++) {
                Person person = arrayList.get(i);
                listPerson.add(person.getName());
                listPerson.add(person.getAddress());
            }
        }

        namaAdapter=new NamaAdapter(this, R.layout.layouts,listPerson);
        listView.setAdapter(namaAdapter);
    }
}
