package com.willowtree.worstlistviewever;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.willowtree.worstlistviewever.api.SubredditLoader;
import com.willowtree.worstlistviewever.api.model.RedditData;


public class MainActivity extends ActionBarActivity implements LoaderManager.LoaderCallbacks<RedditData>, AdapterView.OnItemClickListener {
    private ListView mListView;
    private ProgressBar mProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.list);
        mListView.setOnItemClickListener(this);
        mProgress = (ProgressBar) findViewById(R.id.progress);
        showProgress(true);
        getSupportLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<RedditData> onCreateLoader(int id, Bundle args) {
        return new SubredditLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<RedditData> loader, RedditData data) {
        mListView.setAdapter(new WorstAdapter(this, data.data.children));
        showProgress(false);
    }

    @Override
    public void onLoaderReset(Loader<RedditData> loader) {

    }

    private void showProgress(boolean show) {
        mProgress.setVisibility(show ? View.VISIBLE : View.GONE);
        mListView.setVisibility(show ? View.GONE : View.VISIBLE);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        RedditData data = (RedditData) parent.getAdapter().getItem(position);
        if (data.isSelf) {
            SelfActivity.startSelfActivity(this, data);
        } else if (data.url.endsWith(".jpg") || data.url.endsWith(".png")) {
            ImageActivity.startImageActivity(this, data);
        } else {
            WebActivity.startWebActivity(this, data);
        }
    }
}
