package com.example.chaitanya.barcodescanner;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.ViewGroup;

public class Main2Activity extends ActionBarActivity implements View.OnClickListener {
Button b5,b6,b7,b8,b9,b10,maggi,rcity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b5 = (Button)findViewById(R.id.b5);
        b6 = (Button)findViewById(R.id.b6);
        b7 = (Button)findViewById(R.id.b7);
        b8 = (Button)findViewById(R.id.b8);
        b9 = (Button)findViewById(R.id.b9);
        b10 = (Button)findViewById(R.id.b10);
        maggi=(Button)findViewById(R.id.webview);
        rcity=(Button)findViewById(R.id.rcity);
    }
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.b5:
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://paytm.com/")));
                    break;
                case R.id.b6:
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.freecharge.in/")));
                    break;

                case R.id.b7:
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://bhimapps.in/")));
                    break;
                case R.id.b8:
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.icicibank.com/Personal-Banking/payments.page")));
                    break;
                case R.id.b9:
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.icicibank.com/Personal-Banking/cards/Consumer-Cards/Debit-Card/debit-online.page")));
                    break;
                case R.id.b10:
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.icicibank.com/Personal-Banking/insta-banking/internet-banking/index.page")));
                    break;
                case R.id.webview:
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.amazon.in/Gourmet-Specialty-Foods/b?ie=UTF8&node=2454178031")));
                    break;
                case R.id.rcity:
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.rcity.co.in/about-us/r-city-floor-plans.aspx")));
                    break;

            }

        }


    }

