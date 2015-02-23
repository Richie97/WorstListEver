package com.willowtree.worstlistviewever;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.willowtree.worstlistviewever.api.model.RedditData;


public class SelfActivity extends ActionBarActivity {

    public static void startSelfActivity(Context context, RedditData data){
        Intent intent = new Intent(context, SelfActivity.class);
        intent.putExtra("data", data);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self);
        RedditData data = getIntent().getParcelableExtra("data");
        getSupportActionBar().setTitle(data.title);
        TextView tv = (TextView) findViewById(R.id.self_text);
        tv.setText(Html.fromHtml(Html.fromHtml(data.selfTextHtml).toString()));
    }
}
