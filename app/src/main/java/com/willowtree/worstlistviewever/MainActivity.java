package com.willowtree.worstlistviewever;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.view.MenuCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.willowtree.worstlistviewever.api.SubredditLoader;
import com.willowtree.worstlistviewever.api.model.RedditData;


public class MainActivity extends ActionBarActivity implements LoaderManager.LoaderCallbacks<RedditData>, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private ListView mListView;
    private ProgressBar mProgress;
    private int loaderId = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PreferenceManager.getDefaultSharedPreferences(this).edit().putLong("currentTime", System.currentTimeMillis()).apply();
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.list);
        mListView.setOnItemClickListener(this);
        mListView.setOnItemLongClickListener(this);
        mProgress = (ProgressBar) findViewById(R.id.progress);
        Bundle args = getLoaderArguments(SubredditLoader.DEFAULT_SUBREDDIT);
        getSupportLoaderManager().initLoader(loaderId, args, this);
    }
    
    private Bundle getLoaderArguments(String subreddit){
        Bundle args = new Bundle();
        args.putString(SubredditLoader.SUBREDDIT, subreddit);
        return args;
    }

    @Override
    public Loader<RedditData> onCreateLoader(int id, Bundle args) {
        showProgress(true);
        String subreddit = args.getString(SubredditLoader.SUBREDDIT);
        getSupportActionBar().setTitle(subreddit);
        return new SubredditLoader(this, subreddit);
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
        } else if (data.isImage()) {
            ImageActivity.startImageActivity(this, data);
        } else {
            WebActivity.startWebActivity(this, data);
        }
    }
    
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        int pos = PreferenceManager.getDefaultSharedPreferences(this).getInt("pos", 0);
        Toast.makeText(this, ((WorstAdapter)parent.getAdapter()).getItem(pos).title, Toast.LENGTH_SHORT).show();
        return true;
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if(!TextUtils.isEmpty(s)) {
                    loaderId++;
                    getSupportLoaderManager().initLoader(loaderId, getLoaderArguments(s), MainActivity.this);
                }
                supportInvalidateOptionsMenu();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


}
