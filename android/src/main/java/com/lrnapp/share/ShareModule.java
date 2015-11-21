package com.lrnapp.share;

import android.content.Context;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

public class ShareModule extends ReactContextBaseJavaModule {

    public ShareModule(ReactApplicationContext reactContext, Context activityContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "ShareModule";
    }
}
