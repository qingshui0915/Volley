package com.bawei.volleystudio.net;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bawei.volleystudio.VolleyApp;

import java.util.Map;

public class VolleyHttpClient {
    private static final VolleyHttpClient ourInstance = new VolleyHttpClient();

    public static VolleyHttpClient getInstance() {
        return ourInstance;
    }

    private VolleyHttpClient() {
    }

    //get请求
    public void getVolleyHttp(String url, final VolleyCallBack volleyCallBack){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                volleyCallBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyCallBack.onFail(error);
            }
        });
        //设置请求的Tag标签
        stringRequest.setTag("testGET");
        //加到全局队列去
        VolleyApp.getHttpVolley().add(stringRequest);
    }
    //post请求
    public void postVolleyHttp(String url, final Map<String,String> map, final VolleyCallBack volleyCallBack){
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                volleyCallBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyCallBack.onFail(error);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        //设置请求的Tag标签
        stringRequest.setTag("testGET");
        //加到全局队列去
        VolleyApp.getHttpVolley().add(stringRequest);

    }


    public interface VolleyCallBack{
        void onSuccess(String result);

        void onFail(VolleyError error);
    }
}
