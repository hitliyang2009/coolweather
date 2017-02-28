package com.hillstone.coolweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate: app is oncreat.......");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
