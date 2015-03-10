package com.willowtree.worstlistviewever.api;


import com.willowtree.worstlistviewever.api.model.RedditData;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by ericrichardson on 2/18/15.
 */
public interface RedditService {
    @GET("/{subreddit}.json?limit=100")
    public RedditData getSubreddit(@Path("subreddit") String subreddit);
}
