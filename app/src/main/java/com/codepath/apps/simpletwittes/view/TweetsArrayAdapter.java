package com.codepath.apps.simpletwittes.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.apps.simpletwittes.R;
import com.codepath.apps.simpletwittes.models.Tweet;
import com.codepath.apps.simpletwittes.view.components.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TweetsArrayAdapter extends ArrayAdapter<Tweet> {
    private ArrayList<Tweet> tweets;
    private Context mContext;
    public TweetsArrayAdapter(Context context, ArrayList<Tweet> tweets) {
        super(context, R.layout.item_tweet, tweets);
        this.tweets = tweets;
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Tweet tweet = getItem(position);
        if(convertView == null) convertView = LayoutInflater.from(mContext)
                .inflate(R.layout.item_tweet,parent,false);

        ViewHolder viewHolder = new ViewHolder(convertView);
        viewHolder.ivUserProfilePic.setImageResource(android.R.color.transparent);

        Picasso.with(mContext).load(tweet.getUser().getProfileImageUrl()).
                transform(new CircleTransform()).into(viewHolder.ivUserProfilePic);

        viewHolder.tvUserName.setText(tweet.getUser().getName());
        viewHolder.tvTweet.setText(tweet.getText());
        return convertView;
    }

    @Override
    public int getCount() {
        return tweets!= null? tweets.size(): 0;
    }

    public class ViewHolder{
        @BindView(R.id.ivUserProfilePic)
        ImageView ivUserProfilePic;
        @BindView(R.id.tvUserName)
        TextView tvUserName;
        @BindView(R.id.tvTweet)
        TextView tvTweet;

        public ViewHolder(View itemView){
            ButterKnife.bind(this,itemView);
        }
    }
}
