package com.bawei.volleystudio;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
//全局
public class VolleyApp extends Application {
    private static RequestQueue requestQueue;
    @Override
    public void onCreate() {
        super.onCreate();

        requestQueue = Volley.newRequestQueue(getApplicationContext());

    }
    public static RequestQueue getHttpVolley(){
        return requestQueue;
    }
}
