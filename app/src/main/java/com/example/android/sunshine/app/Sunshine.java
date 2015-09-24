package com.example.android.sunshine.app;

import android.app.Application;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by malachi on 9/23/15.
 */
public class Sunshine
extends Application
{
	public static final String TAG = Sunshine.class.getSimpleName();

	// @TODO consider switching over to Dagger

	private static Bus bus;
	public static Bus getBus(){return bus;}

	private static DataConnectionManager dataConnectionManager;
	public static DataConnectionManager getDataConnectionManager(){return dataConnectionManager;}

	@Override
	public void onCreate() {
		super.onCreate();
		bus = new Bus(ThreadEnforcer.ANY);
		dataConnectionManager = new DataConnectionManager();
	}
}

