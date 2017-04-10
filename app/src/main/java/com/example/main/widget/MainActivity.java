package com.example.main.widget;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.common.base.BaseActivity;
import com.example.main.contract.MainContract;
import com.example.main.model.MainModel;
import com.example.main.presenter.MainPresenter;
import com.example.news.ui.NewsFragment;
import com.example.ui.R;

//import com.example.common.base.BaseActivity;

public class MainActivity extends BaseActivity<MainPresenter,MainModel> implements MainContract.View{

    private static final String TAG = "MainActivity";
    //声明相关变量
    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ImageView ivRunningMan;
    private NavigationView mNavigationView;
    private Fragment currentFragment;
    private Fragment mNewsFragment;

    @Override
    protected int getLayoutResources() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        ivRunningMan = (ImageView) findViewById(R.id.iv_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        toolbar.setTitle(getString(R.string.app_name));//设置Toolbar标题
        toolbar.setTitleTextColor(Color.parseColor("#ffffff")); //设置标题颜色
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //创建返回键，并实现打开关/闭监听
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close);
        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        initFragment();
        setupDrawerContent(mNavigationView);
        switchFragment(mNewsFragment);
    }

    public void initFragment(){
        mNewsFragment = NewsFragment.getInstance();
        currentFragment = mNewsFragment;
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        mPresenter.switchNavigation(menuItem.getItemId());
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    @Override
    public void switchToNews() {

        switchFragment(mNewsFragment);
    }

    @Override
    public void switchToImages() {

    }

    @Override
    public void switchToWeather() {

    }

    @Override
    public void switchToAbout() {

    }

    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showErr(String err) {

    }

    private void switchFragment(Fragment targetFragment) {

        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        if (!targetFragment.isAdded()) {
                transaction
                        .hide(currentFragment)
                        .add(R.id.frame_content, targetFragment).show(targetFragment)
                        .commit();

        } else {
                transaction
                        .hide(currentFragment)
                        .show(targetFragment)
                        .commit();
        }
        currentFragment = targetFragment;

    }
}
