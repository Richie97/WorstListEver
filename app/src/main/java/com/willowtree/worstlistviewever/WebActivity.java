package com.willowtree.worstlistviewever;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.willowtree.worstlistviewever.api.model.RedditData;


public class WebActivity extends ActionBarActivity {

    public static void startWebActivity(Context context, RedditData data){
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra("data", data);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        RedditData data = getIntent().getParcelableExtra("data");
        getSupportActionBar().setTitle(data.title);
        WebView tv = (WebView) findViewById(R.id.webview);
        tv.loadUrl(data.url);
    }
}
