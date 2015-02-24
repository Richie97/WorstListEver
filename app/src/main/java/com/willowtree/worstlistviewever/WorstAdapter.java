package com.willowtree.worstlistviewever;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.willowtree.worstlistviewever.api.model.RedditData;

import java.util.List;

/**
 * Created by ericrichardson on 2/23/15.
 */
public class WorstAdapter extends WorseAdapter {
    List<RedditData> mData;

    public WorstAdapter(Context context, List<RedditData> data) {
        super(context);
        this.mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public RedditData getItem(int position) {
        for (int i = 0; i < mData.size(); i++) {
            if (position == i) {
                return mData.get(i).data;
            }
        }
        return mData.get(0).data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        RedditData data = getItem(position);
        if (data.isSelf) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.view_list_item, parent, false);
            TextView title, author, subreddit, ups, downs, comments;
            title = (TextView) view.findViewById(R.id.title);
            title.setText(Html.fromHtml(data.title));
            title.setTypeface(getBoldFont());
            author = (TextView) view.findViewById(R.id.author);
            author.setTypeface(getRegularFont());
            Spannable authorSpan = new SpannableString(Html.fromHtml(data.author));
            authorSpan.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.ui_text)), 0, authorSpan.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            author.setText(authorSpan);
            subreddit = (TextView) view.findViewById(R.id.subreddit);
            subreddit.setTypeface(getLightItalicFont());
            Spannable subSpan = new SpannableString(Html.fromHtml(data.subreddit));
            subSpan.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.orangered)), 0, subSpan.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            subreddit.setText(subSpan);
            ups = (TextView) view.findViewById(R.id.ups);
            ups.setTypeface(getItalicFont());
            Spannable upvoteSpan = new SpannableString(Integer.toString(data.ups));
            upvoteSpan.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.upvote)), 0, upvoteSpan.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            ups.setText(upvoteSpan);
            downs = (TextView) view.findViewById(R.id.downs);
            downs.setTypeface(getItalicFont());
            PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putInt("pos", position).commit();
            Spannable downvoteSpan = new SpannableString(Integer.toString(data.downs));
            downvoteSpan.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.downvote)), 0, downvoteSpan.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            downs.setText(downvoteSpan);
            comments = (TextView) view.findViewById(R.id.comment_count);
            comments.setTypeface(getItalicFont());
            Spannable commentSpan = new SpannableString(Integer.toString(data.commentCount));
            commentSpan.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.ui_text)), 0, commentSpan.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            comments.setText(commentSpan);
        } else {
            view = LayoutInflater.from(getContext()).inflate(R.layout.view_list_item_image, parent, false);
            TextView title, author, subreddit, ups, downs, comments;
            title = (TextView) view.findViewById(R.id.title);
            title.setText(Html.fromHtml(data.title));
            title.setTypeface(getBoldFont());
            author = (TextView) view.findViewById(R.id.author);
            author.setTypeface(getRegularFont());
            Spannable authorSpan = new SpannableString(Html.fromHtml(data.author));
            authorSpan.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.ui_text)), 0, authorSpan.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            author.setText(authorSpan);
            subreddit = (TextView) view.findViewById(R.id.subreddit);
            subreddit.setTypeface(getLightItalicFont());
            Spannable subSpan = new SpannableString(Html.fromHtml(data.subreddit));
            subSpan.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.orangered)), 0, subSpan.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            subreddit.setText(subSpan);
            ups = (TextView) view.findViewById(R.id.ups);
            ups.setTypeface(getItalicFont());
            Spannable upvoteSpan = new SpannableString(Integer.toString(data.ups));
            upvoteSpan.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.upvote)), 0, upvoteSpan.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            ups.setText(upvoteSpan);
            PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putInt("pos", position).commit();
            downs = (TextView) view.findViewById(R.id.downs);
            downs.setTypeface(getItalicFont());
            Spannable downvoteSpan = new SpannableString(Integer.toString(data.downs));
            downvoteSpan.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.downvote)), 0, downvoteSpan.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            downs.setText(downvoteSpan);
            comments = (TextView) view.findViewById(R.id.comment_count);
            comments.setTypeface(getItalicFont());
            Spannable commentSpan = new SpannableString(Integer.toString(data.commentCount));
            commentSpan.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.ui_text)), 0, commentSpan.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            comments.setText(commentSpan);
            WebView image = (WebView) view.findViewById(R.id.image);
            image.loadUrl(data.thumbnail);
        }
        return view;
    }
}
