package com.android.hongjianzhang.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.hongjianzhang.MainActivity;
import com.android.hongjianzhang.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tv_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findView();
        init();
    }

    private void init() {
        tv_login.setOnClickListener(this);
    }

    private void findView() {
        tv_login = (TextView) findViewById(R.id.tv_login);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_login:
                startActivity(new Intent(this,MainActivity.class));
                finish();
                break;
        }
    }
}
