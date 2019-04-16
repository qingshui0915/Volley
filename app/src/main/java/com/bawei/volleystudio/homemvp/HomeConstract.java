package com.bawei.volleystudio.homemvp;

import com.android.volley.VolleyError;
/**
 *@project_name: HomeConstract.java
 *@date: 2019/4/16
 *@user: LiuJiang
 *@description:MVP
 */
public interface HomeConstract {
    //IHomeView层
    interface IHomeView{
        void getPreData(String data);
    }
    //IHomeModel层
    interface IHomeModel{
        void getRequester(ModelCallBack modelCallBack);
        interface ModelCallBack{
            void onSuccess(String result);

            void onError(VolleyError error);
        }

    }
    //IHomePresenter层
    interface IHomePresenter{
        void attch(HomeActivity homeActivity);
        void detch();

        void showData();
    }
}
