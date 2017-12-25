package com.wyq.mcowu.junlintianxia.junlintianxia.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.wyq.mcowu.junlintianxia.R;
import com.wyq.mcowu.junlintianxia.junlintianxia.Immersive.Immersives;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        //沉浸式
        Immersives.getInstance().Immersive(getWindow(),getActionBar());
        //隐藏标题栏
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        int id = getIntent().getIntExtra("id", 1);
        Log.i("====id=============", "onCreate: "+id+"");
    }
}
