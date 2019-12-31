package com.example.chirag.navigationdrawer.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.example.chirag.navigationdrawer.MainActivity;
import com.example.chirag.navigationdrawer.MyApplicationLauncher;

public class ConnectvityCheck extends BroadcastReceiver {

    public static ConnectivityReceiverListener  connectivityReceiverListener;

    @Override
    public void onReceive(Context context, Intent intent) {


        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null
                && activeNetwork.isConnectedOrConnecting();

        if (connectivityReceiverListener != null) {
            connectivityReceiverListener.onNetworkConnectionChanged(isConnected);
        }
        else
        {

            System.out.println("else working");
        }


    }


    public static boolean isConnected() {
        ConnectivityManager
                cm = (ConnectivityManager) MyApplicationLauncher.getInstance().getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null
                && activeNetwork.isConnectedOrConnecting();
    }


    public interface ConnectivityReceiverListener {

        void onNetworkConnectionChanged(boolean isConnected);
    }
}
