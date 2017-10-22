package com.android.hongjianzhang.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.hongjianzhang.R;
import com.android.hongjianzhang.activity.WebViewActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhishiFragment extends Fragment implements View.OnClickListener{
    private View rootView;
    private TextView tv_goWeb;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_zhishi, container, false);
        initView();
        return rootView;
    }

    private void initView() {
        tv_goWeb = rootView.findViewById(R.id.tv_goWeb);
        tv_goWeb.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        WebViewActivity.startWebViewActivity(getActivity(),"http://www.hongjianzhang.cn");
    }
}
