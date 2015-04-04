package com.willowtree.worstlistviewever;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;

import com.willowtree.worstlistviewever.api.model.RedditData;

/**
 * Created by ericrichardson on 2/24/15.
 */
public abstract class WorseAdapter extends BadAdapter {

    public WorseAdapter(Context context){
        super(context);
    }
    
    @Override
    public abstract int getCount();

    @Override
    public abstract RedditData getItem(int position);

    @Override
    public abstract View getView(int position, View convertView, ViewGroup parent);
    
    Typeface getBoldFont(){
        return WorstUtil.getFont(getContext(), WorstUtil.FontType.BOLD);
    }

    Typeface getItalicFont(){
        return WorstUtil.getFont(getContext(), WorstUtil.FontType.ITALIC);
    }

    Typeface getLightItalicFont(){
        return WorstUtil.getFont(getContext(), WorstUtil.FontType.LIGHT_ITALIC);
    }

    Typeface getRegularFont(){
        return WorstUtil.getFont(getContext(), WorstUtil.FontType.REGULAR);
    }
}
