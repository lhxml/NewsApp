package com.example.news.ui;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.widget.ImageView;

import com.example.bean.News;
import com.example.bean.NewsDetails;
import com.example.common.base.BaseActivity;
import com.example.news.contract.NewsDetailsContract;
import com.example.news.model.NewsDetailsModel;
import com.example.news.model.NewsModel;
import com.example.news.presenter.NewsDetailsPresenter;
import com.example.news.presenter.NewsPresenter;
import com.example.ui.R;
import com.example.util.DialogUtils;
import com.example.util.ImageLoaderUtils;

import org.sufficientlysecure.htmltextview.HtmlTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lxl on 2017/4/14.
 */

public class NewsDetailsActivity extends BaseActivity<NewsDetailsPresenter, NewsDetailsModel> implements NewsDetailsContract.View{


    @BindView(R.id.img_newsdetails)
    ImageView imgNewsdetails;
    @BindView(R.id.html_newsdetails_text)
    HtmlTextView htmlNewsdetailsText;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    private News news;
    private int tableNum;


    @Override
    public void showLoading(String msg) {
        DialogUtils.showDialog(this, false);
    }

    @Override
    public void hideLoading() {
        DialogUtils.dismissDialog();
    }

    @Override
    public void showErr(String err) {

    }

    @Override
    protected int getLayoutResources() {
        return R.layout.activity_newsdetails;
    }

    @Override
    protected void initView() {
        news = getIntent().getParcelableExtra("news");
        tableNum = getIntent().getIntExtra("tableNum",1);
        mPresenter.getNewsDetailsData(Integer.parseInt(news.getNews_id()),tableNum,"&");
    }


    @Override
    public void returnNewsDetailsData(NewsDetails newsDetails) {
       collapsingToolbar.setTitle(newsDetails.getTitle());
        ImageLoaderUtils.display(this,imgNewsdetails,newsDetails.getTop_image());
        htmlNewsdetailsText.setHtmlFromString(newsDetails.getContent(),new HtmlTextView.LocalImageGetter());

    }
}
