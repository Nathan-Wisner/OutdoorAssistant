package com.example.wisne.outdoorapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.jsoup.Jsoup;
import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    public int KP = 0;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {


            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent myIntent = new Intent(Main2Activity.this, MapsActivity.class);
                    myIntent.putExtra("result", KP);
                    startActivity(myIntent);
                    return true;
                case R.id.navigation_dashboard:
                    Intent etc = new Intent(Main2Activity.this, MeteorShower.class);
                    startActivity(etc);
                    return true;
                case R.id.navigation_notifications:
                    Intent more = new Intent(Main2Activity.this, MeteorShower.class);
                    startActivity(more);
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        new northern().execute();
    }


    public class northern extends AsyncTask<Void, Void, Void> {

        String detail = "";
        private GoogleMap mMap;


        TextView textView;

        protected Void doInBackground(Void... params) {
            try {
                org.jsoup.nodes.Document Doc;
                String url = "http://www.aurora-service.org/aurora-forecast/";
                Doc = Jsoup.connect(url).get();
                detail = Doc.text();

                for (int i = 0; i != 1; i++) {
                    String parse = "";
                    String two;
                    String Extra[];
                    String brand[];
                    String safe[];
                    String MaxString = "There is no good time to view the Norhtern Lights today";

                    String NoonToThree[];
                    String ThreeToSix[];
                    String NineToMid[];

                    int MidToThree = 0;
                    int ThreeAmToSix = 0;
                    int NinePMToMid = 0;
                    int together = 0;


                    brand = detail.split("06-09UT");
                    safe = brand[0].split("\\s+");
                    //brand = detail.split("03-06UT");

                    brand = detail.split("06-09UT");
                    NoonToThree = brand[1].split("\\s+");

                    brand = detail.split("09-12UT");
                    safe = brand[1].split("\\s+");

                    brand = detail.split("09-12UT");
                    ThreeToSix = brand[1].split(("\\s+"));

                    brand = detail.split("12-15UT");
                    safe = brand[1].split("\\s+");

                    brand = detail.split("12-15UT");
                    NineToMid = brand[1].split(("\\s+"));

                    MidToThree = Integer.valueOf(NoonToThree[1]);
                    ThreeAmToSix = Integer.valueOf(ThreeToSix[1]);
                    NinePMToMid = Integer.valueOf(NineToMid[1]);

                    int Max = 0;

                    if (MidToThree > Max) {
                        KP = MidToThree;
                        Max = MidToThree;
                        MaxString = "The Best time to view the Northern Lights today is from 12AM - 3AM with a KP of " + KP;

                    } if (ThreeAmToSix >= Max) {
                        KP = ThreeAmToSix;
                        if(ThreeAmToSix != Max) {
                            Max = ThreeAmToSix;
                            MaxString = "The Best time to view the Northern Lights today is from 3AM - 6AM with a KP of " + KP;
                        }
                        else {
                            MaxString = "The Best time to view the Northern Lights today is from 12AM - 6AM  with a KP of " + KP;
                            together = 1;
                        }
                    }
                    if(NinePMToMid >= Max) {
                        KP = NinePMToMid;
                        if (Max != NinePMToMid) {
                            Max = NinePMToMid;
                            MaxString = "The Best time to view the Northern Lights today is from 9PM - 12AM PST with a KP of " + KP;
                        } else if (together == 1) {
                            MaxString = "The Best time to view the Northern Lights today is from 9PM - 6AM PST with a KP of " + KP;
                        } else {
                            MaxString = "The Best time to view the Northern Lights today is from 9PM - 12AM and 3AM - 6AM PST with a KP of " + KP;
                        }
                        textView.setText(MaxString);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;


        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //textView.setText(detail);
        }


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

                LatLng ArtistPoint = new LatLng(48.846700, -121.692324);
                LatLng ChainLakes = new LatLng(48.8469, -121.6925);
                LatLng OysterDome = new LatLng(48.6096, -122.4264);
                LatLng Wallace = new LatLng(47.8669, -121.6820);
                LatLng Lakes = new LatLng(48.8469, -121.6925);
                LatLng Enchantments = new LatLng(47.5279, -120.8207);


       /* try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
          //  boolean success = googleMap.setMapStyle(
                 ////   MapStyleOptions.loadRawResourceStyle(
                       //     this, R.raw.style_json));

            if (!success) {
                Log.e("l", "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e("l", "Can't find style. Error: ", e);
        }*/

       /* mMap.addMarker(new MarkerOptions().position(ChainLakes).title("Words")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.addMarker(new MarkerOptions().position(ArtistPoint).title("Artist Point")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.addMarker(new MarkerOptions().position(OysterDome).title("OysterDome")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.addMarker(new MarkerOptions().position(Lakes).title("Heather Lake")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.addMarker(new MarkerOptions().position(Enchantments).title("Enchantments")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.addMarker(new MarkerOptions().position(Wallace).title("Wallace Lake")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
*/

                // Add a marker in Sydney and move the camera
//
            }
        }
    }

}