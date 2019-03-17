package com.bawei.myapplicationooo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.myapplicationooo.R;
import com.bawei.myapplicationooo.bean.One;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * @Author：DELL
 * @E-mail： 463211790@qq.com
 * @Date：2019/3/17 20:05
 * @Description：描述信息
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {
    private ArrayList<One> list = new ArrayList<>();
    private Context context;

    public NewsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = View.inflate(context,R.layout.layout01,null);
        MyViewHolder myViewHolder =new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        String type = list.get(i).getType();
        String url = list.get(i).getUrl();

        myViewHolder.text1.setText(type);

        Picasso.with(context).load(url).into(myViewHolder.img_v1);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void setData(ArrayList<One> list){
        this.list=list;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text1;
        ImageView img_v1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 =itemView.findViewById(R.id.text1);
            img_v1 =itemView.findViewById(R.id.img_v1);

        }
    }
}
