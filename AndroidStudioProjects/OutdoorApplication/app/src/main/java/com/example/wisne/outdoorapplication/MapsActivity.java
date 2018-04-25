package com.example.wisne.outdoorapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    int result;
    private GoogleMap mMap;
    String detail = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent mIntent = getIntent();
        result = mIntent.getIntExtra("result", 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);



        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //configureNextButton();
        configureMeteorButton();
        configureStarButton();
    }




    private void configureMeteorButton(){
        Button meteorButton = findViewById(R.id.meteotButton);
        meteorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent firstIntent = new Intent(MapsActivity.this, MeteorShower.class);
                startActivity(firstIntent);
            }
        });
    }


    private void configureStarButton(){
        Button otherButton = findViewById(R.id.button2);
        otherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent firstIntent = new Intent(MapsActivity.this, MainActivity.class);
                startActivity(firstIntent);
            }
        });
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        String tag = "Default";
        String defaultString = "No";

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

        // Add a marker in Sydney and move the camera

        LatLng ArtistPoint = new LatLng(48.846700, -121.692324);
        LatLng ChainLakes = new LatLng(48.8469, -121.6925);
        LatLng OysterDome = new LatLng(48.6096, -122.4264);
        LatLng Wallace = new LatLng(47.8669, -121.6820);
        LatLng Lakes = new LatLng(48.8469, -121.6925);
        LatLng Enchantments = new LatLng( 47.5279, -120.8207);

        LatLng KP7Beginning = new LatLng(46.008157, -118.207812);
        LatLng KP7Mid = new LatLng(46.805568, -122.441448);
        LatLng KP7Coast = new LatLng(47.235285, -124.213467);
        LatLng EndOfUS = new LatLng(57.515910, -167.824159);
        LatLng KP7Ocean = new LatLng(49.136814, -42.782521);
        LatLng MidPK7 = new LatLng(42.002677, -79.738155);

        LatLng MiddleOfUS = new LatLng(41.849205, -90.318018);
        LatLng MiddleOfPK5 = new LatLng(45.891962, -92.877259);
        LatLng CenterOfPK5 = new LatLng(49.003095, -112.941778);
        LatLng EndPK5 = new LatLng(60.398821, -167.427077);
        LatLng KP5Mid = new LatLng(45.703059, -80.622528);
        LatLng KP5Ocean = new LatLng(53.249259, -47.889784);

        LatLng CanadaPK3 = new LatLng(57.393714, -134.931793);
        LatLng MiddleOfPK3 = new LatLng(49.786394, -93.544416);
        LatLng CenterOfPK3 = new LatLng(50.381122, -80.771224);
        LatLng EndPK3 = new LatLng(53.654097, -56.221951);

        LatLng PK3Point = new LatLng(56.79, -123.12);
        LatLng PK5Point = new LatLng(54, -124.87);

        // LatLng KP3Mid = new LatLng( ,-);
        //  LatLng KP3Ocean = new LatLng( ,-);
        //

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(OysterDome, 7));

        if (result >= 7) {

            mMap.addMarker(new MarkerOptions().position(ChainLakes).title("Words").snippet("Good Conditions: " + defaultString)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
            mMap.addMarker(new MarkerOptions().position(ArtistPoint).title("Artist Point").snippet("Good Conditions: " + defaultString)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
            mMap.addMarker(new MarkerOptions().position(OysterDome).title("OysterDome").snippet("Good Conditions: " + defaultString)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
            mMap.addMarker(new MarkerOptions().position(Lakes).title("Heather Lake").snippet("Good Conditions: " + defaultString)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
            mMap.addMarker(new MarkerOptions().position(Enchantments).title("Enchantments").snippet("Good Conditions: " + defaultString)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
            mMap.addMarker(new MarkerOptions().position(Wallace).title("Wallace Lake").snippet("Good Conditions: " + defaultString)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));


            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ArtistPoint, 13));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ChainLakes, 13));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(OysterDome, 7));

            Polyline newPolyline = mMap.addPolyline(new PolylineOptions()
                    .add(KP7Beginning, KP7Mid).width(10));

            Polyline coastLine = mMap.addPolyline(new PolylineOptions()
                    .add(KP7Mid, KP7Coast).width(10));

            Polyline EndofUS = mMap.addPolyline((new PolylineOptions()
                    .add(KP7Coast, EndOfUS).width(10)));

            Polyline MiddlePK7 = mMap.addPolyline((new PolylineOptions()
                    .add(KP7Beginning, MiddleOfUS).width(10)));

            Polyline MiddlePK5 = mMap.addPolyline((new PolylineOptions()
                    .add(MiddleOfPK5, CenterOfPK5)));

            Polyline TipPK5 = mMap.addPolyline((new PolylineOptions()
                    .add(CenterOfPK5, EndPK5)));

            Polyline CenterPK7 = mMap.addPolyline((new PolylineOptions()
                    .add(MiddleOfUS, MidPK7)));

            Polyline EndPK7 = mMap.addPolyline((new PolylineOptions()
                    .add(MidPK7, KP7Ocean)));

            Polyline PK7Something = mMap.addPolyline((new PolylineOptions()
                    .add(MiddleOfPK5, KP5Mid)));

            Polyline PK5Coast = mMap.addPolyline((new PolylineOptions()
                    .add(KP5Mid, KP5Ocean)));

            Polyline MiddlePK3 = mMap.addPolyline((new PolylineOptions()
                    .add(CanadaPK3, MiddleOfPK3)));

            Polyline TipPK3 = mMap.addPolyline((new PolylineOptions()
                    .add(CenterOfPK3, MiddleOfPK3)));

            Polyline PK3Coast = mMap.addPolyline((new PolylineOptions()
                    .add(CenterOfPK3, EndPK3)));

            coastLine.setColor(Color.YELLOW);
            newPolyline.setColor(Color.YELLOW);
            EndofUS.setColor(Color.YELLOW);
            MiddlePK7.setColor(Color.YELLOW);
            MiddlePK5.setColor(Color.GREEN);
            TipPK5.setColor(Color.GREEN);
            CenterPK7.setColor(Color.YELLOW);
            EndPK7.setColor(Color.YELLOW);
            PK7Something.setColor(Color.GREEN);
            PK5Coast.setColor(Color.GREEN);
            MiddlePK3.setColor(Color.BLUE);
            TipPK3.setColor(Color.BLUE);
            PK3Coast.setColor(Color.BLUE);
        }
        else if (result >= 5) {

            mMap.addMarker(new MarkerOptions().position(PK5Point).title("Words").snippet("Good Conditions: " + defaultString)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

            Polyline MiddlePK5 = mMap.addPolyline((new PolylineOptions()
                    .add(MiddleOfPK5, CenterOfPK5)));

            Polyline TipPK5 = mMap.addPolyline((new PolylineOptions()
                    .add(CenterOfPK5, EndPK5)));


            Polyline PK5Coast = mMap.addPolyline((new PolylineOptions()
                    .add(KP5Mid, KP5Ocean)));

            Polyline MiddlePK3 = mMap.addPolyline((new PolylineOptions()
                    .add(CanadaPK3, MiddleOfPK3)));

            Polyline TipPK3 = mMap.addPolyline((new PolylineOptions()
                    .add(CenterOfPK3, MiddleOfPK3)));

            Polyline PK3Coast = mMap.addPolyline((new PolylineOptions()
                    .add(CenterOfPK3, EndPK3)));


            MiddlePK5.setColor(Color.GREEN);
            TipPK5.setColor(Color.GREEN);
            PK5Coast.setColor(Color.GREEN);
            MiddlePK3.setColor(Color.BLUE);
            TipPK3.setColor(Color.BLUE);
            PK3Coast.setColor(Color.BLUE);
        }
        else if (result >= 3) {

            mMap.addMarker(new MarkerOptions().position(PK3Point).title("Grahm park").snippet("Good Conditions: " + defaultString)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

            Polyline MiddlePK3 = mMap.addPolyline((new PolylineOptions()
                    .add(CanadaPK3, MiddleOfPK3)));

            Polyline TipPK3 = mMap.addPolyline((new PolylineOptions()
                    .add(CenterOfPK3, MiddleOfPK3)));

            Polyline PK3Coast = mMap.addPolyline((new PolylineOptions()
                    .add(CenterOfPK3, EndPK3)));


            MiddlePK3.setColor(Color.BLUE);
            TipPK3.setColor(Color.BLUE);
            PK3Coast.setColor(Color.BLUE);
        }


    }


    public class Weather extends AsyncTask<Void, Void, Void> {

        private int KP;
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
                    String MaxString;

                    String TenToOne[];
                    String OneToFour[];
                    String FourToSeven[];
                    String EightToEleven[];

                    int SevenPMToTen = 0;
                    int OneAMToFour = 0;
                    int TenPMToOneAM = 0;
                    int FourAMToSeven = 0;



                    brand = detail.split("03-06UT");
                    safe = brand[0].split("\\s+");

                    brand = detail.split("03-06UT");
                    EightToEleven = brand[1].split("\\s+");

                    brand = detail.split("06-09UT");
                    safe = brand[0].split("\\s+");

                    brand = detail.split("06-09UT");
                    TenToOne = brand[1].split("\\s+");
                    Log.i("Message 1",TenToOne[2]);

                    brand = detail.split("09-12UT");
                    safe = brand[1].split("\\s+");

                    brand = detail.split("09-12UT");
                    OneToFour = brand[1].split(("\\s+"));

                    brand = detail.split("12-15UT");
                    safe = brand[1].split("\\s+");

                    brand = detail.split("12-15UT");
                    FourToSeven = brand[1].split(("\\s+"));

                    SevenPMToTen = Integer.valueOf(EightToEleven[2]);
                    TenPMToOneAM = Integer.valueOf(TenToOne[2]);
                    OneAMToFour = Integer.valueOf(OneToFour[1]);
                    FourAMToSeven = Integer.valueOf(FourToSeven[1]);


                    int Max = 0;
                    int together = 0;

                    if(SevenPMToTen > Max){
                        KP = SevenPMToTen;
                        Max = SevenPMToTen;
                        MaxString = "The Best time to view the Northern Lights today is from 7PM - 10PM with a KP of " + KP;
                    }

                    else if (TenPMToOneAM > Max) {
                        KP = TenPMToOneAM;
                        Max = TenPMToOneAM;
                        together = 1;
                        MaxString = "The Best time to view the Northern Lights today is from 10PM - 1AM with a KP of " + KP;

                    }
                    if (OneAMToFour >= Max) {
                        KP = OneAMToFour;
                        if (OneAMToFour != Max) {
                            Max = OneAMToFour;
                            MaxString = "The Best time to view the Northern Lights today is from 1AM - 4AM with a KP of " + KP;
                        } else if (together == 1){
                            MaxString = "The Best time to view the Northern Lights today is from 7PM - 4AM  with a KP of " + KP;
                            together = 2;
                        }
                        else{
                            MaxString = "The Best time to view the Northern Lights today is from 7PM- 10PM and 1AM - 4AM  with a KP of " + KP;
                        }
                    }

                    if (FourAMToSeven >= Max) {
                        KP = FourAMToSeven;
                        if (Max != OneAMToFour) {
                            Max = FourAMToSeven;
                            MaxString = "The Best time to view the Northern Lights today is from 4AM - 7AM PST with a KP of " + KP;
                        } else if (together == 1) {
                            MaxString = "The Best time to view the Northern Lights today is from 10PM - 1AM PST and 4AM - 7AM with a KP of " + KP;
                        }
                        else if(together == 2){
                            MaxString = "The Best time to view the Northern Lights today is from 7PM - 7AM PST with a KP of " + KP;
                        }
                        else {
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
    }
}

