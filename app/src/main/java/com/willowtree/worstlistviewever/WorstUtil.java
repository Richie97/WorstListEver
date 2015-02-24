package com.willowtree.worstlistviewever;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by ericrichardson on 2/24/15.
 */
public class WorstUtil {
    public enum FontType {
        BOLD, ITALIC, LIGHT_ITALIC, REGULAR
    }
    
    public static Typeface getFont(Context context, FontType typeface){
        switch(typeface){
            case BOLD:
                return Typeface.createFromAsset(context.getAssets(), context.getString(R.string.roboto_bold));
            case ITALIC:
                return Typeface.createFromAsset(context.getAssets(), context.getString(R.string.roboto_italic));
            case LIGHT_ITALIC:
                return Typeface.createFromAsset(context.getAssets(), context.getString(R.string.roboto_light_italic));
            default:
                return Typeface.createFromAsset(context.getAssets(), context.getString(R.string.roboto_regular));
        }
        
    }
}
