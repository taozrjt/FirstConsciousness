package com.zrjt.tao.firstconsciousness.view;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;

import com.zrjt.tao.firstconsciousness.R;
import com.zrjt.tao.firstconsciousness.base.BaseFragment;

import java.util.List;

import butterknife.BindView;

/**
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
    private int mContainerId;
    private FragmentManager mFragmentManager;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_nav;
    }

    @Override
    protected void initWidget(View mRootView) {
        super.initWidget(mRootView);
        mNavNews.initItemIcon(R.drawable.tab_icon_new, getResources().getString(R.string.nav_index), null);
        mNavTweet.initItemIcon(R.drawable.tab_icon_new, getResources().getString(R.string.nav_index), null);
        mNavExplore.initItemIcon(R.drawable.tab_icon_new, getResources().getString(R.string.nav_index), null);
        mNavMe.initItemIcon(R.drawable.tab_icon_new, getResources().getString(R.string.nav_index), null);
    }

    public void setup(Context context, FragmentManager fragmentManager, int contentId) {
        mContext = context;
        mFragmentManager = fragmentManager;
        mContainerId = contentId;
        clearOldFragment();
    }

    @SuppressWarnings("RestrictedApi")
    private void clearOldFragment() {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        List<Fragment> fragments = mFragmentManager.getFragments();
        if (transaction == null || fragments == null || fragments.size() == 0) {
            return;
        }
        boolean doCommit = false;
        for (Fragment fragment : fragments) {
            if (fragment != this && fragment != null) {
                transaction.remove(fragment);
                doCommit = true;
            }
        }
        if (doCommit) {
            transaction.commitNow();
        }
    }
}
