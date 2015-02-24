package com.willowtree.worstlistviewever;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by ericrichardson on 2/24/15.
 */
public abstract class BadAdapter extends BaseAdapter{
    Context mContext;

    public Context getContext(){
        return mContext;
    }
    
    public BadAdapter(Context context){
        this.mContext = context;
    }
            
    @Override
    public abstract int getCount();

    @Override
    public abstract Object getItem(int position);

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public abstract View getView(int position, View convertView, ViewGroup parent);
}
