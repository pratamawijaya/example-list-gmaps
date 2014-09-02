
package com.pratama.examplelistgooglemaps;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.pratama.examplelistgooglemaps.adapter.AdapterList;
import com.pratama.examplelistgooglemaps.entity.Lokasi;

public class MainActivity extends ActionBarActivity implements OnItemClickListener {

    private ListView lv;
    private List<Lokasi> listLokasi;
    private AdapterList adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize view
        lv = (ListView) findViewById(R.id.list);

        // geneate some dummy data
        generateData();

        // instance adapter for list
        adapter = new AdapterList(this, listLokasi);

        // set adapter to list
        lv.setAdapter(adapter);

        // set listener list
        lv.setOnItemClickListener(this);
    }

    /**
     * add some data, u can use data from sqlite or whatever..
     */
    private void generateData() {
        listLokasi = new ArrayList<Lokasi>();

        listLokasi.add(new Lokasi("Hotel Grand Aston Jogja", -7.782877, 110.381806));
        listLokasi.add(new Lokasi("Hotel Sahid Rich", -7.75307, 110.361513));

        // add more data, i'm lazzy ~_~, so just copy & paste
        listLokasi.add(new Lokasi("Hotel Grand Aston Jogja", -7.782877, 110.381806));
        listLokasi.add(new Lokasi("Hotel Sahid Rich", -7.75307, 110.361513));
        listLokasi.add(new Lokasi("Hotel Grand Aston Jogja", -7.782877, 110.381806));
        listLokasi.add(new Lokasi("Hotel Sahid Rich", -7.75307, 110.361513));
        listLokasi.add(new Lokasi("Hotel Grand Aston Jogja", -7.782877, 110.381806));
        listLokasi.add(new Lokasi("Hotel Sahid Rich", -7.75307, 110.361513));
        listLokasi.add(new Lokasi("Hotel Grand Aston Jogja", -7.782877, 110.381806));
        listLokasi.add(new Lokasi("Hotel Sahid Rich", -7.75307, 110.361513));
        listLokasi.add(new Lokasi("Hotel Grand Aston Jogja", -7.782877, 110.381806));
        listLokasi.add(new Lokasi("Hotel Sahid Rich", -7.75307, 110.361513));
        listLokasi.add(new Lokasi("Hotel Grand Aston Jogja", -7.782877, 110.381806));
        listLokasi.add(new Lokasi("Hotel Sahid Rich", -7.75307, 110.361513));
        listLokasi.add(new Lokasi("Hotel Grand Aston Jogja", -7.782877, 110.381806));
        listLokasi.add(new Lokasi("Hotel Sahid Rich", -7.75307, 110.361513));
        listLokasi.add(new Lokasi("Hotel Grand Aston Jogja", -7.782877, 110.381806));
        listLokasi.add(new Lokasi("Hotel Sahid Rich", -7.75307, 110.361513));
        listLokasi.add(new Lokasi("Hotel Grand Aston Jogja", -7.782877, 110.381806));
        listLokasi.add(new Lokasi("Hotel Sahid Rich", -7.75307, 110.361513));

    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long arg3) {
        Lokasi loc = (Lokasi) adapter.getItem(pos);
        startActivity(new Intent(this, MapViewActivity.class).putExtra("object", loc));
    }
}
