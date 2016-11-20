package com.codepath.apps.simpletwittes.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ListView;

import com.codepath.apps.simpletwittes.R;
import com.codepath.apps.simpletwittes.TwitterApplication;
import com.codepath.apps.simpletwittes.TwitterClient;
import com.codepath.apps.simpletwittes.controller.TimeLineManager;
import com.codepath.apps.simpletwittes.models.Tweet;
import com.codepath.apps.simpletwittes.view.base.BaseActivity;
import com.codepath.apps.simpletwittes.view.components.EndlessScrollListener;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Time;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cz.msebera.android.httpclient.Header;

public class TimeLineActivity extends BaseActivity {


    private TwitterClient client;
    private TweetsArrayAdapter tweetsArrayAdapter;
    private ArrayList<Tweet> tweets;

    @BindView(R.id.lvTweets)
    ListView lvTweets;


    public TimeLineActivity(){
        super(R.layout.activity_timeline,false);
    }

    @Override
    protected void doOnCreate(Bundle bundle) {
        ButterKnife.bind(this);
        client = TwitterApplication.getRestClient();
        populateTimeLine();


    }

    private void populateTimeLine() {
        client.getHomeTimeline(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                TimeLineManager.get_instance().setJson(response.toString());
                tweets = new ArrayList<>();
                tweets = TimeLineManager.get_instance().getTweets();
                tweetsArrayAdapter = new TweetsArrayAdapter(TimeLineActivity.this,tweets);
                lvTweets.setAdapter(tweetsArrayAdapter);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });


    }
}
