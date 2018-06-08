package com.zrjt.tao.firstconsciousness.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.zrjt.tao.firstconsciousness.R;

/**
 * @author 049
 * @date 2018/6/6
 */

public class NavButton extends FrameLayout {

    ImageView mIvIcon;
    TextView mTvTitle;
    TextView mTvDots;

    public NavButton(@NonNull Context context) {
        super(context);
        init();
    }

    public NavButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NavButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public NavButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.item_nav_buttom, null);
        mIvIcon = view.findViewById(R.id.nav_iv_icon);
        mTvTitle = view.findViewById(R.id.nav_tv_title);
        mTvDots = view.findViewById(R.id.nav_tv_dot);
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        mIvIcon.setSelected(selected);
        mTvTitle.setSelected(selected);
    }

    public void setCount(int count) {
        mTvDots.setVisibility(count > 0 ? VISIBLE : GONE);
        mTvDots.setText(String.valueOf(count));
    }
}
