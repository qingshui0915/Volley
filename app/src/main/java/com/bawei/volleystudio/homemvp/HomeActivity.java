package com.bawei.volleystudio.homemvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.bawei.volleystudio.R;
import com.bawei.volleystudio.adapter.ShopAdapter;
import com.bawei.volleystudio.bean.ShowBean;
import com.google.gson.Gson;

import java.util.List;
/**
 *@project_name: HomeActivity.java
 *@date: 2019/4/16
 *@user: LiuJiang
 *@description:
 */
public class HomeActivity extends AppCompatActivity implements HomeConstract.IHomeView {

    private HomePresenter homePresenter;
    private GridView gv;
    private List<ShowBean.ResultBean> showBeanResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        gv = findViewById(R.id.gv);
        homePresenter = new HomePresenter();
        homePresenter.attch(HomeActivity.this);
    }

    @Override
    public void getPreData(String data) {
        Gson gson = new Gson();
        ShowBean showBean = gson.fromJson(data, ShowBean.class);
        showBeanResult = showBean.getResult();

        gv.setAdapter(new ShopAdapter(this,showBeanResult));



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        homePresenter.detch();
    }
}
