package com.bawei.myapplicationooo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.myapplicationooo.R;
import com.bawei.myapplicationooo.bean.One;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * @Author：DELL
 * @E-mail： 463211790@qq.com
 * @Date：2019/3/17 20:39
 * @Description：描述信息
 */
public class ItmAdapter extends RecyclerView.Adapter {
    private ArrayList<One> list =new ArrayList<>();
    private Context context;

    public ItmAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        RecyclerView.ViewHolder viewHolder =null;

        switch (i){
            case 0:
                view = View.inflate(context,R.layout.layout01,null);
                viewHolder =new ViewHolder0(view);
                break;
            case 1:
                view = View.inflate(context,R.layout.layout02,null);
                viewHolder =new ViewHolder1(view);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        final One one = list.get(i);
        if (viewHolder instanceof ViewHolder0){
            ((ViewHolder0) viewHolder).text1.setText(one.getType());
            Picasso.with(context).load(one.getUrl()).into(((ViewHolder0) viewHolder).img_v1);
        }else if (viewHolder instanceof ViewHolder1){

            Picasso.with(context).load(one.getUrl()).into(((ViewHolder1) viewHolder).img_v1);
            Picasso.with(context).load(one.getUrl()).into(((ViewHolder1) viewHolder).img_v2);
            Picasso.with(context).load(one.getUrl()).into(((ViewHolder1) viewHolder).img_v3);
            Picasso.with(context).load(one.getUrl()).into(((ViewHolder1) viewHolder).img_v4);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,list.get(i).getType(),Toast.LENGTH_SHORT).show();

//                list.remove(i);
//                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position%2;
    }

    public void setData(ArrayList<One> list){
        this.list=list;
        notifyDataSetChanged();
    }
    private class ViewHolder0 extends RecyclerView.ViewHolder{

        TextView text1;
        ImageView img_v1;
        public ViewHolder0(@NonNull View itemView) {
            super(itemView);
            text1= itemView.findViewById(R.id.text1);
            img_v1= itemView.findViewById(R.id.img_v1);
        }
    }

    private class ViewHolder1 extends RecyclerView.ViewHolder{

        ImageView img_v1,img_v2,img_v3,img_v4;
        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            img_v1= itemView.findViewById(R.id.img_v1);
            img_v2= itemView.findViewById(R.id.img_v2);
            img_v3= itemView.findViewById(R.id.img_v3);
            img_v4= itemView.findViewById(R.id.img_v4);
        }
    }

}
