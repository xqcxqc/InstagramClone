package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("iEYR4ij2z8U7uEuzIwVc6rJ3kif83EWdYCwoLKXd")
                .clientKey("TlGPMAslSbW1hRfOP23LHBgeCYjDx8cJZL36UGJu")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
