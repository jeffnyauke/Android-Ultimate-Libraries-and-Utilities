package com.example.jeffreynyauke.myapplication.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Jeffrey Nyauke on 2/19/2017.
 */

public class FontTabLayout extends TabLayout {

    private static final String FONT_PATH = "fonts/Lato-Regular.ttf";
    private Typeface mTypeface;

    public  FontTabLayout (Context context){
        super(context);
        init();
    }

    public  FontTabLayout (Context context, AttributeSet attrs){
        super(context, attrs);
        init();
    }

    public  FontTabLayout (Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mTypeface = Typeface.createFromAsset(getContext().getAssets(), FONT_PATH);
    }

    @Override
    public void addTab(@NonNull Tab tab, int position, boolean setSelected){
        super.addTab(tab, position, setSelected);

        ViewGroup mainView = (ViewGroup) getChildAt(0);
        ViewGroup tabView = (ViewGroup) mainView.getChildAt(tab.getPosition());
        int tabChildCount = tabView.getChildCount();
        for (int i = 0; i < tabChildCount; i++){
            View tabViewChild = tabView.getChildAt(i);
            if (tabViewChild instanceof TextView){
                ((TextView) tabViewChild).setTypeface(mTypeface, Typeface.NORMAL);
            }
        }
    }
}
