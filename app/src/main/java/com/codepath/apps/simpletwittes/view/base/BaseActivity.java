package com.codepath.apps.simpletwittes.view.base;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.codepath.apps.simpletwittes.R;


public abstract class BaseActivity extends AppCompatActivity{

    //instance of the current activity
    public static BaseActivity activity;

    //app bar
    Toolbar toolbar;

    // to allow sliding menu or not
    private boolean mAllowSideMenu = true;

    // inner layout to be inflated
    private int mActivityLayout;

    //side menu
    private DrawerLayout mDrawerLayout;

    //Constructor
    public BaseActivity(int activityLayout, boolean allowMenu) {
        this.mActivityLayout = activityLayout;
        this.mAllowSideMenu = allowMenu;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activity = BaseActivity.this;

        if (mAllowSideMenu) {
            setContentView(R.layout.activity_base);
            ViewGroup contentLayout = (ViewGroup) findViewById(R.id.mainContainr);
            if (mActivityLayout != -1)
                LayoutInflater.from(this).inflate(mActivityLayout, contentLayout, true);



            /*initialize appbar*/
            toolbar = (Toolbar) findViewById(R.id.app_bar);

            if (toolbar != null) {

                setSupportActionBar(toolbar);

            }

            /*initialize sideMenu*/

        } else {
            setContentView(mActivityLayout);
        }

        doOnCreate(savedInstanceState);

    }

    // abstract method to be called in activities that extend this one instead of oncreate().
    protected abstract void doOnCreate(Bundle bundle);


}