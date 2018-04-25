package com.example.wisne.outdoorapplication;

import android.app.TabActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;

import org.jsoup.Jsoup;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public int KP;
    static TextView textView;



    public void forecast(){
        new northern().execute();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new northern().execute();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        configureForecastButton();
        configureNextButton();
        configureMeteorButton();
       // configureStarButton();
       textView = findViewById(R.id.String);
    }

    private void configureForecastButton() {
        Button nextButton = findViewById(R.id.button3);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                FetchWeather weather = new FetchWeather();
                weather.execute("http://api.openweathermap.org/data/2.5/forecast?&units=imperial&lat=48.846700&lon=-121.692324&appid=75d42cf579d66be3fda8ee90c9cba6e3");
                textView = (TextView) findViewById(R.id.String);
            }
        });
    }


        private void configureNextButton() {
            Button nextButton = findViewById(R.id.nextButton);
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    Intent myIntent = new Intent(MainActivity.this, MapsActivity.class);
                    myIntent.putExtra("result", KP);
                    startActivity(myIntent);
                }
            });
        }

    private void configureMeteorButton(){
        Button meteorButton = findViewById(R.id.meteotButton);
        meteorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent firstIntent = new Intent(MainActivity.this, MeteorShower.class);
                startActivity(firstIntent);
            }
        });
    }


    private void configureStarButton(){
        Button otherButton = findViewById(R.id.button2);
        otherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent firstIntent = new Intent(MainActivity.this, MeteorShower.class);
                startActivity(firstIntent);
            }
        });
    }


    public class northern extends AsyncTask<Void,Void,Void> {

        String detail = "";
        private GoogleMap mMap;



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
                    String MaxString = "There is no expected activity";

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
                    }
                    textView.setText(MaxString);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;

        }


            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }



        }

        }




