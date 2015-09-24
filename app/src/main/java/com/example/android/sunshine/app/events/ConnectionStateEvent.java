package com.example.android.sunshine.app.events;

import android.net.NetworkInfo;

/**
 * Created by malachi on 9/23/15.
 */
public class ConnectionStateEvent
{
	private final NetworkInfo networkInfo;

	public ConnectionStateEvent(final NetworkInfo networkInfo)
	{
		this.networkInfo = networkInfo;
	}

	public NetworkInfo getNetworkInfo() {
		return networkInfo;
	}
}
