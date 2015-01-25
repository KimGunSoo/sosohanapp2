package com.sosohanapp.wifiorder;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class WifiConnected extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_connected);
        ConnectivityManager connect = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        /* get wifi information */
        NetworkInfo wifiInfo = connect.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        /* print wifi connected information */
        TextView wifiConnectedText = (TextView)findViewById(R.id.wifi_connected);
        wifiConnectedText.setText("WifiConnected : " + wifiInfo.isConnected());
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
