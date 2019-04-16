package com.bawei.volleystudio.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.volleystudio.R;
import com.bawei.volleystudio.bean.ShowBean;
import com.bumptech.glide.Glide;

import java.util.List;
/**
 *@project_name: ShopAdapter.java
 *@date: 2019/4/16
 *@user: LiuJiang
 *@description:
 */
public class ShopAdapter extends BaseAdapter {
    private Context context;
    private List<ShowBean.ResultBean> showBeanResult;

    public ShopAdapter(Context context, List<ShowBean.ResultBean> showBeanResult) {
        this.context = context;
        this.showBeanResult = showBeanResult;
    }

    @Override
    public int getCount() {
        return showBeanResult.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView=LayoutInflater.from(context).inflate(R.layout.home_item,null);
            viewHolder.iv_pic=convertView.findViewById(R.id.iv_pic);
            viewHolder.stitle=convertView.findViewById(R.id.stitle);
            viewHolder.sprice=convertView.findViewById(R.id.sprice);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }

        Glide.with(context).load(showBeanResult.get(position).getMasterPic()).into(viewHolder.iv_pic);
        viewHolder.stitle.setText(showBeanResult.get(position).getCommodityName());
        viewHolder.sprice.setText("￥"+showBeanResult.get(position).getPrice()+"");
        return convertView;
    }
    class ViewHolder{

        ImageView iv_pic;
        TextView stitle;
        TextView sprice;
    }
}
