package com.zrjt.tao.firstconsciousness.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * @author 049
 * @date 2018/6/6
 */

public abstract class BaseFragment extends Fragment {

    protected Context mContext;
    protected View mRootView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (mRootView != null) {
            ViewGroup mParent = (ViewGroup) mRootView.getParent();
            if (mParent != null) {
                mParent.removeView(mRootView);
            }
        } else {
            mRootView = inflater.inflate(getLayoutId(), container, false);
            onBindViewBefore(mRootView);
            ButterKnife.bind(this, mRootView);
            // Get savedInstanceState
            if (savedInstanceState != null) {
                onRestartInstance(savedInstanceState);
            }
            initWidget(mRootView);
            initData();
        }
        return mRootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /**
     * 布局id
     *
     * @return
     */
    protected abstract int getLayoutId();

    protected void onBindViewBefore(View mRootView) {
    }

    protected void initWidget(View mRootView) {
    }

    protected void initData() {
    }

    protected void onRestartInstance(Bundle bundle) {
    }
}
