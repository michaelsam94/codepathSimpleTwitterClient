package com.codepath.apps.simpletwittes.controller;

import com.codepath.apps.simpletwittes.models.Tweet;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class TimeLineManager {
    private static TimeLineManager _instance;
    private String json;
    private ArrayList<Tweet> tweets = new ArrayList<>();


    public static TimeLineManager get_instance(){
        if(_instance == null) _instance = new TimeLineManager();
        return _instance;
    }

    public void setJson(String json) {
        this.json = json;
    }


    public ArrayList<Tweet> getTweets(){
        if(json != null){
            Gson gson = new Gson();
            tweets = gson.fromJson(json, new TypeToken<ArrayList<Tweet>>(){}.getType());
            return tweets;
        }
        else return null;
    }

}
