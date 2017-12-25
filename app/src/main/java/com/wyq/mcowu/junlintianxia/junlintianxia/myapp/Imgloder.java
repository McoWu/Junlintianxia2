package com.wyq.mcowu.junlintianxia.junlintianxia.myapp;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by tangxiaoying on 2017/12/21.
 */

public class Imgloder extends ImageLoader {


    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context)
                .load(path)
                .into(imageView);
    }
}
