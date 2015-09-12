package com.test.administrator.broadcastbestpractice;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Administrator on 2015/8/16.
 */
public class BaseActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}

