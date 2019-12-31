package com.example.chirag.navigationdrawer;

import android.app.Application;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import com.example.chirag.navigationdrawer.broadcast.ConnectvityCheck;

public class MyApplicationLauncher extends Application {

    private static MyApplicationLauncher mInstance;
    @Override
    public void onCreate() {
        super.onCreate();

        final IntentFilter intentFilter = new IntentFilter();

        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);

        ConnectvityCheck ConnectvityCheck = new ConnectvityCheck();

        registerReceiver(ConnectvityCheck, intentFilter);

        mInstance = this;
    }


    public static synchronized MyApplicationLauncher getInstance() {
        return mInstance;
    }

    public void setConnectivityListener(ConnectvityCheck.ConnectivityReceiverListener listener) {



//        System.out.println("check123");
        ConnectvityCheck.connectivityReceiverListener = listener;
    }




}
