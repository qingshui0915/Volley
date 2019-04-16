package com.bawei.volleystudio.homemvp;

import com.android.volley.VolleyError;
/**
 *@project_name: HomePresenter.java
 *@date: 2019/4/16
 *@user: LiuJiang
 *@description:
 */
public class HomePresenter implements HomeConstract.IHomePresenter {

    private HomeModel homeModel;
    private HomeActivity ihomeview;

    @Override
    public void attch(HomeActivity homeActivity) {
        this.ihomeview=homeActivity;
        homeModel = new HomeModel();
        homeModel.getRequester(new HomeConstract.IHomeModel.ModelCallBack() {
            @Override
            public void onSuccess(String result) {
                ihomeview.getPreData(result);
            }
            @Override
            public void onError(VolleyError error) {

            }
        });
    }

    @Override
    public void detch() {
        if (ihomeview!=null){
            ihomeview=null;
        }
        if (homeModel!=null){
            homeModel=null;
        }
        System.gc();

    }

    @Override
    public void showData() {

    }
}
