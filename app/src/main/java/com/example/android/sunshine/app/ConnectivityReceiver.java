package com.example.android.sunshine.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.net.ConnectivityManagerCompat;

public class ConnectivityReceiver extends BroadcastReceiver {
	public ConnectivityReceiver() {
	}
	
	@Override
	public void onReceive(Context context, Intent intent) {
		final ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		final NetworkInfo networkInfo = ConnectivityManagerCompat.getNetworkInfoFromBroadcast(connectivityManager, intent);
		if(networkInfo != null)
			Sunshine.getDataConnectionManager().reportConnection(networkInfo);
	}
}
