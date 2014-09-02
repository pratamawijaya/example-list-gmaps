
package com.pratama.examplelistgooglemaps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.pratama.examplelistgooglemaps.entity.Lokasi;

public class MapViewActivity extends ActionBarActivity implements OnClickListener {

    private Lokasi lokasi;
    private GoogleMap map;
    private Bundle data;

    private Button btnDirection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_view);

        // get data from previous activity
        data = getIntent().getExtras();
        lokasi = data.getParcelable("object");

        btnDirection = (Button) findViewById(R.id.btn_direction);

        setupMapIfNeeded();

        btnDirection.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnDirection) {
            Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                    .parse("http://maps.google.com/maps?daddr=" + lokasi.getLat() + ","
                            + lokasi.getLng()));
            startActivity(i);
        }
    }

    /**
     * initialize map
     */
    private void setupMapIfNeeded() {
        if (map == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            SupportMapFragment supportMapFragment = (SupportMapFragment) fragmentManager
                    .findFragmentById(R.id.maps);
            map = supportMapFragment.getMap();

            if (map != null) {
                setupMap();
            }
        }
    }

    /**
     * Setup Map
     */
    private void setupMap() {
        map.setMyLocationEnabled(true);

        // add marker
        map.addMarker(new MarkerOptions()
                .position(new LatLng(lokasi.getLat(), lokasi.getLng()))
                .title(lokasi.getName()));

        // animate camera to location position
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lokasi.getLat(), lokasi.getLng()), 14));
    }

}
