package com.example.android.sunshine.app;

import android.net.NetworkInfo;
import android.util.Log;
import com.example.android.sunshine.app.events.ConnectionStateEvent;
import com.squareup.otto.Produce;

/**
 * Created by malachi on 9/23/15.
 */
public class DataConnectionManager
{
    private NetworkInfo lastNetworkInfo = null;

    public DataConnectionManager()
    {
        Sunshine.getBus().register(this);
    }

    /**
     * Not currently called, but available for clean shutdown
     */
    public void close()
    {
        Sunshine.getBus().unregister(this);
    }

    public void reportConnection(final NetworkInfo networkInfo)
    {
        lastNetworkInfo = networkInfo;
        if(networkInfo == null) {
            Log.w(Sunshine.TAG, "reportConnection received an empty NetworkInfo - problem upstream?");
        }else{
            Log.d(Sunshine.TAG, "reportConnection posting event: " + networkInfo);
            Sunshine.getBus().post(new ConnectionStateEvent(networkInfo));
        }
    }

    @Produce
    public ConnectionStateEvent produceConnectionEvent()
    {
        if(lastNetworkInfo == null)
            return null;

        return new ConnectionStateEvent(lastNetworkInfo);
    }
}
