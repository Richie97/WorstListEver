package com.willowtree.worstlistviewever.api;

import android.content.Context;

import com.willowtree.worstlistviewever.api.model.RedditData;

import oak.util.OakAsyncLoader;

/**
 * Created by ericrichardson on 2/18/15.
 */
public class SubredditLoader extends OakAsyncLoader<RedditData> {
    public static final String SUBREDDIT = "subreddit";
    public static final String DEFAULT_SUBREDDIT = "android";
    
    private String subreddit;
    public SubredditLoader(Context context, String subreddit) {
        super(context);
        this.subreddit = subreddit;
    }

    @Override
    public RedditData loadInBackground() {
        return Reddit.getService().getSubreddit(subreddit);
    }
}
