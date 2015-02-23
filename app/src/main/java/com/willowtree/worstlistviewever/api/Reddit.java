package com.willowtree.worstlistviewever.api;


import com.google.gson.Gson;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by ericrichardson on 2/18/15.
 */
public class Reddit {
    
    static RedditService redditService;
    
    public static RedditService getService(){
        if(redditService == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint("http://reddit.com/r")
                    .setConverter(new GsonConverter(new Gson()))
                    .build();
            redditService = restAdapter.create(RedditService.class);
        }
        return redditService;
    }
}
