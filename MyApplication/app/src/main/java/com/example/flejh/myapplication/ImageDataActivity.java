package com.example.flejh.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.glass.view.WindowUtils;

public class ImageDataActivity extends Activity {

    public static final String SEARCH = "search";
    private String mPlatform = "Android";
    private TextView rawData;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().requestFeature(WindowUtils.FEATURE_VOICE_COMMANDS);
        rawData = new TextView(this);

        if(getIntent().hasExtra(SEARCH)){
            mPlatform = getIntent().getStringExtra(SEARCH);
        }

        displayData(mPlatform);

        setContentView(rawData);
    }

    void displayData(String data) {
        Uri uriUrl = Uri.parse("http://192.168.43.6:3000/image");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}

