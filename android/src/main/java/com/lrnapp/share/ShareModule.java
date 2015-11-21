package com.lrnapp.share;

import android.net.Uri;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.share.model.ShareLinkContent;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

import java.net.MalformedURLException;
import java.net.URL;

public class ShareModule extends ReactContextBaseJavaModule {

    private ReactApplicationContext mReactContext;

    public ShareModule(ReactApplicationContext reactContext) {
        super(reactContext);

        mReactContext = reactContext;
    }

    @Override
    public String getName() {
        return "ShareModule";
    }

    @ReactMethod
    public void ShareOnFacebook(final ReadableMap options) {
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

    @ReactMethod
    public void ShareOnTwitter(final ReadableMap options) {

        String text = options.getString("text");
        String link = options.getString("link");
        String image = options.getString("image");

        TweetComposer.Builder builder = new TweetComposer.Builder(mReactContext);

        if (text != null) {
            builder.text(text);
        }

        if (link != null) {
            try {
                builder.url(new URL(link));
            } catch (MalformedURLException e) {
                return;
            }
        }

        if (image != null) {
            builder.image(Uri.parse(image));
        }

        builder.show();
    }
}
