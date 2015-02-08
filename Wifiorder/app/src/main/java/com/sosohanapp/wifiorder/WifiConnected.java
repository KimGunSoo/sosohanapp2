package com.sosohanapp.wifiorder;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class WifiConnected extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        setContentView(R.layout.activity_wifi_connected);
        ConnectivityManager connect = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        /* get wifi information */
        NetworkInfo wifiInfo = connect.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        Button btn_connect_wifi = (Button) findViewById(R.id.btn_connect_wifi);
        Button btn_connect_cancel_wifi = (Button) findViewById(R.id.btn_connect_cancel_wifi);

        if (wifiInfo.isConnected() == false) {
            /* print wifi connected information */
            TextView wifiConnectedText = (TextView) findViewById(R.id.wifi_connected);
            wifiConnectedText.setText("Wifi에 접속되지 않았습니다. 접속하시겠습니까?");

            btn_connect_wifi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /* wifi scan */
                }
            });

            btn_connect_cancel_wifi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /* go back Intent or exit application */
                    /*
                    Intent wifiConnectedIntent = new Intent(WifiConnected.this, MainActivity.class);
                    startActivity(wifiConnectedIntent);
                    */
                }
            });
        } else {
            btn_connect_wifi.setVisibility(View.INVISIBLE);
            btn_connect_cancel_wifi.setVisibility(View.INVISIBLE);
            /* wifiInfo.isConnected() == true */
            /* print wifi connected information */
            TextView wifiConnectedText = (TextView) findViewById(R.id.wifi_connected);
            //wifiConnectedText.setText("WifiConnected : " + wifiInfo.isConnected());

            /* TODO: implement
            * 1. connect to server
            * 2. get menu list or menu image
            */
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_wifi_connected, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

