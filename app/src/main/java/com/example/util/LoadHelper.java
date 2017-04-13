package com.example.util;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.ColorRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.common.base.BaseApplication;
import com.example.ui.R;

/**
 * Created by lxl on 2017/4/12.
 */

public class LoadHelper {

    private Context mContext;
    private AnimationDrawable mAnimationDrawable;

    /**
     *加载更多的文字
     */
    private String mLoadingMoreText = "正在加载中...";
    /**
     *加载布局的背景颜色
     */
    private int mLoadMoreBackgroundRes = -1;
    /**
     *加载更多的布局
     */
    protected View mLoadingFooterView;
    /**
     *加载更多的提示控件
     */
    protected TextView mLoadingTextView;
    /**
     *加载更多的动画控件
     */
    protected ImageView mLoadingImageView;

    private static LoadHelper helper = null;

    private LoadHelper(Context context){
        this.mContext = context.getApplicationContext();
    }

    public static LoadHelper getInstance(Context context){
        if(helper==null){
            synchronized (LoadHelper.class){
                if(helper==null){
                    helper = new LoadHelper(context);
                }
            }
        }
        return helper;
    }


    /**
     *开始加载更多动画
     */
    public void startLoadMore(){
       setmLoadingImageVisible();
        if(mAnimationDrawable!=null){
            mAnimationDrawable.start();
        }
    }
    /**
     *停止加载动画
     */
    public void endLoadMore(){

        if(mAnimationDrawable!=null){
            mAnimationDrawable.stop();
        }
        setmLoadingImageInVisible();
    }

    /**
     *设置加载更多的文字
     */
    public void setLoadingMoreText(String loadingMoreText){
        mLoadingMoreText = loadingMoreText;
    }
    /**
     *设置加载更多背景色
     */
    public void setLoadingMoreBackgroundRes(@ColorRes int loadingMoreBackgroundRes){
        mLoadMoreBackgroundRes = loadingMoreBackgroundRes;
    }
    /**
     *初始化布局并且获取加载更多的布局
     */
    public View getmLoadingFooterView(){
        if(mLoadingFooterView==null){
            mLoadingFooterView = LayoutInflater.from(mContext).inflate(R.layout.footer,null);
            mLoadingFooterView.setBackgroundColor(Color.TRANSPARENT);
            if(mLoadMoreBackgroundRes != -1){
                mLoadingFooterView.setBackgroundResource(mLoadMoreBackgroundRes);
            }
            mLoadingTextView = (TextView) mLoadingFooterView.findViewById(R.id.tv_loading_footer);
            mLoadingImageView = (ImageView) mLoadingFooterView.findViewById(R.id.img_loading_footer);
            mAnimationDrawable = (AnimationDrawable) mLoadingImageView.getDrawable();
            mLoadingTextView.setText(mLoadingMoreText);
        }

        return mLoadingFooterView;
    }

    public void setmLoadingImageInVisible(){
        if(mLoadingImageView!=null && mLoadingImageView.getVisibility()==View.VISIBLE){
            mLoadingImageView.setVisibility(View.GONE);
        }
    }
    public void setmLoadingImageVisible(){
        if(mLoadingImageView!=null&&mLoadingImageView.getVisibility()==View.GONE){
            mLoadingImageView.setVisibility(View.VISIBLE);
        }
    }


}
