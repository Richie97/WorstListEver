package com.willowtree.worstlistviewever;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.gson.Gson;
import com.willowtree.worstlistviewever.api.model.RedditData;

import java.util.List;

/**
 * Created by ericrichardson on 2/23/15.
 */
public class WorstAdapter  extends BaseAdapter {
    Context mContext;
    List<RedditData> mData;

    public WorstAdapter(Context context, List<RedditData> data) {
        this.mContext = context;
        this.mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public RedditData getItem(int position) {
        return mData.get(position).data;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).isSelf?0:1;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if(getItemViewType(position) == 0) {
            view = LayoutInflater.from(mContext).inflate(R.layout.view_list_item, parent, false);
            RedditData data = getItem(position);
            Typeface robotoCondensedBold = Typeface.createFromAsset(mContext.getAssets(), mContext.getString(R.string.roboto_bold));
            Typeface robotoCondensedRegular = Typeface.createFromAsset(mContext.getAssets(), mContext.getString(R.string.roboto_regular));
            Typeface robotoCondensedItalic = Typeface.createFromAsset(mContext.getAssets(), mContext.getString(R.string.roboto_italic));
            Typeface robotoCondensedLightItalic = Typeface.createFromAsset(mContext.getAssets(), mContext.getString(R.string.roboto_light_italic));
            TextView title, author, subreddit, ups, downs, comments;
            title = (TextView) view.findViewById(R.id.title);
            title.setText(Html.fromHtml(data.title));
            title.setTypeface(robotoCondensedBold);
            author = (TextView) view.findViewById(R.id.author);
            author.setTypeface(robotoCondensedRegular);
            Spannable authorSpan = new SpannableString(Html.fromHtml(data.author));
            authorSpan.setSpan(new ForegroundColorSpan(mContext.getResources().getColor(R.color.ui_text)), 0, authorSpan.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            author.setText(authorSpan);
            subreddit = (TextView) view.findViewById(R.id.subreddit);
            subreddit.setTypeface(robotoCondensedLightItalic);
            Spannable subSpan = new SpannableString(Html.fromHtml(data.subreddit));
            subSpan.setSpan(new ForegroundColorSpan(mContext.getResources().getColor(R.color.orangered)), 0, subSpan.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            subreddit.setText(subSpan);
            PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString("item", new Gson().toJson(data)).commit();
            ups = (TextView) view.findViewById(R.id.ups);
            ups.setTypeface(robotoCondensedItalic);
            Spannable upvoteSpan = new SpannableString(Integer.toString(data.ups));
            upvoteSpan.setSpan(new ForegroundColorSpan(mContext.getResources().getColor(R.color.upvote)), 0, upvoteSpan.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            ups.setText(upvoteSpan);
            downs = (TextView) view.findViewById(R.id.downs);
            downs.setTypeface(robotoCondensedItalic);
            Spannable downvoteSpan = new SpannableString(Integer.toString(data.downs));
            downvoteSpan.setSpan(new ForegroundColorSpan(mContext.getResources().getColor(R.color.downvote)), 0, downvoteSpan.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            downs.setText(downvoteSpan);
            comments = (TextView) view.findViewById(R.id.comment_count);
            comments.setTypeface(robotoCondensedItalic);
            Spannable commentSpan = new SpannableString(Integer.toString(data.commentCount));
            commentSpan.setSpan(new ForegroundColorSpan(mContext.getResources().getColor(R.color.ui_text)), 0, commentSpan.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            comments.setText(commentSpan);
        } else {
            view = LayoutInflater.from(mContext).inflate(R.layout.view_list_item_image, parent, false);
            RedditData data = getItem(position);
            Typeface robotoCondensedBold = Typeface.createFromAsset(mContext.getAssets(), mContext.getString(R.string.roboto_bold));
            Typeface robotoCondensedRegular = Typeface.createFromAsset(mContext.getAssets(), mContext.getString(R.string.roboto_regular));
            Typeface robotoCondensedItalic = Typeface.createFromAsset(mContext.getAssets(), mContext.getString(R.string.roboto_italic));
            Typeface robotoCondensedLightItalic = Typeface.createFromAsset(mContext.getAssets(), mContext.getString(R.string.roboto_light_italic));
            TextView title, author, subreddit, ups, downs, comments;
            title = (TextView) view.findViewById(R.id.title);
            title.setText(Html.fromHtml(data.title));
            title.setTypeface(robotoCondensedBold);
            author = (TextView) view.findViewById(R.id.author);
            author.setTypeface(robotoCondensedRegular);
            Spannable authorSpan = new SpannableString(Html.fromHtml(data.author));
            authorSpan.setSpan(new ForegroundColorSpan(mContext.getResources().getColor(R.color.ui_text)), 0, authorSpan.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            author.setText(authorSpan);
            subreddit = (TextView) view.findViewById(R.id.subreddit);
            subreddit.setTypeface(robotoCondensedLightItalic);
            Spannable subSpan = new SpannableString(Html.fromHtml(data.subreddit));
            subSpan.setSpan(new ForegroundColorSpan(mContext.getResources().getColor(R.color.orangered)), 0, subSpan.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            subreddit.setText(subSpan);
            ups = (TextView) view.findViewById(R.id.ups);
            ups.setTypeface(robotoCondensedItalic);
            Spannable upvoteSpan = new SpannableString(Integer.toString(data.ups));
            upvoteSpan.setSpan(new ForegroundColorSpan(mContext.getResources().getColor(R.color.upvote)), 0, upvoteSpan.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            ups.setText(upvoteSpan);
            PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString("item", new Gson().toJson(data)).commit();
            downs = (TextView) view.findViewById(R.id.downs);
            downs.setTypeface(robotoCondensedItalic);
            Spannable downvoteSpan = new SpannableString(Integer.toString(data.downs));
            downvoteSpan.setSpan(new ForegroundColorSpan(mContext.getResources().getColor(R.color.downvote)), 0, downvoteSpan.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            downs.setText(downvoteSpan);
            comments = (TextView) view.findViewById(R.id.comment_count);
            comments.setTypeface(robotoCondensedItalic);
            Spannable commentSpan = new SpannableString(Integer.toString(data.commentCount));
            commentSpan.setSpan(new ForegroundColorSpan(mContext.getResources().getColor(R.color.ui_text)), 0, commentSpan.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            comments.setText(commentSpan);
            WebView image = (WebView) view.findViewById(R.id.image);
            image.loadUrl(data.thumbnail);
        }
        return view;
    }
}
