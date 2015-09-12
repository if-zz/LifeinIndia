package com.test.administrator.broadcastbestpractice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2015/8/30.
 */
public class TitleLayout extends LinearLayout {
    public TitleLayout(final Context context,AttributeSet attrs){
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.main_title, this);
        Button titleBack=(Button)findViewById(R.id.title_back);
        Button more=(Button)findViewById(R.id.more);
        titleBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
        more.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent((Activity)getContext(),MainActivity.class);
                getContext().startActivity(intent);
            }
        });
    }
}
