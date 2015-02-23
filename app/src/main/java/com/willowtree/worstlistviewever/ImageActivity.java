package com.willowtree.worstlistviewever;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.willowtree.worstlistviewever.api.model.RedditData;


public class ImageActivity extends ActionBarActivity {

    public static void startImageActivity(Context context, RedditData data){
        Intent intent = new Intent(context, ImageActivity.class);
        intent.putExtra("data", data);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ImageView image = (ImageView) findViewById(R.id.image);
        RedditData data = getIntent().getParcelableExtra("data");
        getSupportActionBar().setTitle(data.title);
        Picasso.with(this).load(data.url).into(image);
    }
}
