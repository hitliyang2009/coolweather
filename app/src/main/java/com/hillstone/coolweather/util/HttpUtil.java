package com.hillstone.coolweather.util;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by hillstone on 2017/2/28.
 */

public class HttpUtil {
    private static final String TAG = "HttpUtil";
    public static void sendOKHttpRequest(String address, okhttp3.Callback callback) {
        Log.d(TAG, "sendOKHttpRequest: enter, address is : " + address);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
