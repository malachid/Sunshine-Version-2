package com.example.android.sunshine.app;

import android.app.Application;
import android.net.NetworkInfo;
import android.util.Log;

import com.example.android.sunshine.app.events.ConnectionStateEvent;
import com.squareup.otto.Bus;
import com.squareup.otto.Produce;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by malachi on 9/23/15.
 */
public class Sunshine
extends Application
{
	public static final String TAG = Sunshine.class.getSimpleName();
	private NetworkInfo lastNetworkInfo = null;

	private static Bus bus;
	public static Bus getBus(){return bus;}

	@Override
	public void onCreate() {
		super.onCreate();
		bus = new Bus(ThreadEnforcer.ANY);
		bus.register(this);
		// @TODO when could we properly unregister?
	}

	// @TODO move these connection methods into a data manager class

	public void reportConnection(final NetworkInfo networkInfo)
	{
		lastNetworkInfo = networkInfo;
		// @TODO error handling
		Log.d(TAG, "onReceive posting event: " + networkInfo.isConnected());
		Sunshine.getBus().post(new ConnectionStateEvent(networkInfo));
	}

	@Produce public ConnectionStateEvent produceConnectionEvent()
	{
		if(lastNetworkInfo == null)
			return null;

		return new ConnectionStateEvent(lastNetworkInfo);
	}
}

