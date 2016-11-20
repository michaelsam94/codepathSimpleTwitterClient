package com.codepath.apps.simpletwittes;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;

import android.app.Application;
import android.content.Context;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;

/*
 * This is the Android application itself and is used to configure various settings
 * including the image cache in memory and on disk. This also adds a singleton
 * for accessing the relevant rest client.
 *
 *     TwitterClient client = TwitterApplication.getRestClient();
 *     // use client to send requests to API
 *
 */
public class TwitterApplication extends Application {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "TlOuRtL6yAmv7ECziTOi2KXBV";
    private static final String TWITTER_SECRET = "L3B4IPOPoTuXbTIiGwJ1Iylf0FHeXKe1qHOr4WRL9Ur5TqNYbu";

	private static Context context;

	@Override
	public void onCreate() {
		super.onCreate();
		TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
		Fabric.with(this, new Twitter(authConfig));

		FlowManager.init(new FlowConfig.Builder(this).build());
		FlowLog.setMinimumLoggingLevel(FlowLog.Level.V);

		TwitterApplication.context = this;
	}

	public static TwitterClient getRestClient() {
		return (TwitterClient) TwitterClient.getInstance(TwitterClient.class, TwitterApplication.context);
	}
}