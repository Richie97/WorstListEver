package com.willowtree.worstlistviewever.api;

import android.content.Context;

import com.willowtree.worstlistviewever.api.model.RedditData;

import oak.util.OakAsyncLoader;

/**
 * Created by ericrichardson on 2/18/15.
 */
public class SubredditLoader extends OakAsyncLoader<RedditData> {
    public SubredditLoader(Context context) {
        super(context);
    }

    @Override
    public RedditData loadInBackground() {
        return Reddit.getService().getSubreddit("android");
    }
}
