package com.lrnapp.share;

import android.net.Uri;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.share.model.ShareLinkContent;

public class ShareModule extends ReactContextBaseJavaModule {

    public ShareModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "ShareModule";
    }

    @ReactMethod
    public void ShareOnFacebook(ReadableMap options) {
        String title = options.getString("title");
        String description = options.getString("description");
        String link = options.getString("link");
        String image = options.getString("image");

        ShareLinkContent.Builder builder = new ShareLinkContent.Builder();

        if (title != null) {
            builder.setContentTitle(title);
        }

        if (description != null) {
            builder.setContentDescription(description);
        }

        if (link != null) {
            builder.setContentUrl(Uri.parse(link));
        }

        if (image != null) {
            builder.setImageUrl(Uri.parse(image));
        }

        ShareLinkContent content = builder.build();
    }
}
