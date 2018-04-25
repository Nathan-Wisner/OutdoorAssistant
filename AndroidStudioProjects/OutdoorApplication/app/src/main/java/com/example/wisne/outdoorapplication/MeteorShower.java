package com.example.wisne.outdoorapplication;


import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONObject;
import org.jsoup.Jsoup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MeteorShower extends FragmentActivity implements OnMapReadyCallback {



    TextView textView;

    private GoogleMap mMap;
    String detail = "";
    String Oyster = "";

    LatLng ArtistPoint = new LatLng(48.846700, -121.692324);
    LatLng ChainLakes = new LatLng(48.8469, -121.6925);
    LatLng OysterDome = new LatLng(48.6096, -122.4264);
    LatLng Wallace = new LatLng(47.8669, -121.6820);
    LatLng Lakes = new LatLng(48.8469, -121.6925);
    LatLng Enchantments = new LatLng(47.5279, -120.8207);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent mIntent = getIntent();

        super.onCreate(savedInstanceState);
        // new Meteor().execute();
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        String tag = "Default";
        mMap = googleMap;
        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = mMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.jacob));

            if (!success) {
                Log.e(tag, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(tag, "Can't find style. Error: ", e);
        }

        LatLng ArtistPoint = new LatLng(48.846700, -121.692324);
        LatLng ChainLakes = new LatLng(48.8469, -121.6925);
        LatLng OysterDome = new LatLng(48.6096, -122.4264);
        LatLng Wallace = new LatLng(47.8669, -121.6820);
        LatLng Lakes = new LatLng(48.8469, -121.6925);
        LatLng Enchantments = new LatLng(47.5279, -120.8207);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(OysterDome, 7));

    }
}


