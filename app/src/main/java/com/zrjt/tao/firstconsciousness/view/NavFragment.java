package com.zrjt.tao.firstconsciousness.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.zrjt.tao.firstconsciousness.R;
import com.zrjt.tao.firstconsciousness.base.BaseFragment;

import butterknife.BindView;

/**
 *
 * @author 049
 * @date 2018/6/6
 */

public class NavFragment extends BaseFragment {

    @BindView(R.id.nav_item_news)
    NavButton mNavNews;
    @BindView(R.id.nav_item_tweet)
    NavButton mNavTweet;
    @BindView(R.id.nav_item_explore)
    NavButton mNavExplore;
    @BindView(R.id.nav_item_me)
    NavButton mNavMe;
    @BindView(R.id.nav_item_tweet_pub)
    ImageView mNavPub;
    private Context mContext;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_nav;
    }

    @Override
    protected void initWidget(View mRootView) {

    }
}
