package com.android.hongjianzhang;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.hongjianzhang.adapter.MainVPAdapter;
import com.android.hongjianzhang.fragment.ChuanTongFragment;
import com.android.hongjianzhang.fragment.XueshuFragment;
import com.android.hongjianzhang.fragment.YiShuFragment;
import com.android.hongjianzhang.fragment.ZhishiFragment;

import java.security.Key;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView iv_banguai1;
    private ImageView iv_banguai2;
    private ImageView iv_banguai3;
    private ImageView iv_banguai4;
    private ImageView iv_banguai5;
    private ImageView iv_banguai6;
    private ImageView iv_banguai7;
    private ImageView iv_banguai8;
    private ViewPager viewPager;
    private HorizontalScrollView scrollView;

    private static final int ZHISHI = 0;

    private FragmentManager fm;
    private ArrayList<Fragment> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("Main","进入1");
        setContentView(R.layout.activity_main);
        findView();
        init();
    }

    private void init() {
        iv_banguai2.setOnClickListener(this);
        iv_banguai1.setOnClickListener(this);

        fm = getSupportFragmentManager();
        // TODO: 2017-10-21 添加fragment
        list.add(new ZhishiFragment());
        list.add(new YiShuFragment());
        list.add(new XueshuFragment());
        list.add(new ChuanTongFragment());

        MainVPAdapter adapter = new MainVPAdapter(fm,list);
        viewPager.setAdapter(adapter);
    }

    private void findView() {
        iv_banguai1 = (ImageView) findViewById(R.id.iv_banguai1);
        iv_banguai2 = (ImageView) findViewById(R.id.iv_banguai2);
        viewPager = (ViewPager) findViewById(R.id.viewpager_main);
        scrollView = (HorizontalScrollView) findViewById(R.id.main_xuanxiang);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_banguai1:
                showFragment(ZHISHI);
                break;
            case R.id.iv_banguai2:
                showFragment(2);
                break;
        }
    }



    private void showFragment(int position) {
        viewPager.setVisibility(View.VISIBLE);
        scrollView.setVisibility(View.GONE);
        switch (position) {
            case 1:
                break;
            case 2:
                viewPager.setCurrentItem(1);
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (viewPager.getVisibility() == View.VISIBLE) {
                viewPager.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
