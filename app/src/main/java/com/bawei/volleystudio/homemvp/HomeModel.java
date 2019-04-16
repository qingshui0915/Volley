package com.bawei.volleystudio.homemvp;

import com.android.volley.VolleyError;
import com.bawei.volleystudio.net.VolleyHttpClient;
/**
 *@project_name: HomeModel.java
 *@date: 2019/4/16
 *@user: LiuJiang
 *@description:
 */
public class HomeModel implements HomeConstract.IHomeModel {
    public static final String URL="http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?&page=1&count=30&keyword=%E7%94%B7%E9%9E%8B";


    @Override
    public void getRequester(final ModelCallBack modelCallBack) {
        //Volley请求数据
        VolleyHttpClient.getInstance().getVolleyHttp(URL, new VolleyHttpClient.VolleyCallBack() {
            @Override
            public void onSuccess(String result) {
                modelCallBack.onSuccess(result);
            }
            @Override
            public void onFail(VolleyError error) {
                modelCallBack.onError(error);
            }
        });
    }
}
