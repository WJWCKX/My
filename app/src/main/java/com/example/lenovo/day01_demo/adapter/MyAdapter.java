package com.example.lenovo.day01_demo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.day01_demo.R;
import com.example.lenovo.day01_demo.ShowActivity;
import com.example.lenovo.day01_demo.XiangQingActivity;
import com.example.lenovo.day01_demo.bean.MyData;

import java.util.List;


/**
 * Created by lenovo on 2017/12/18.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MyData.InfoListBean> mList;
    private Context mContext;
    private RecyclerView.ViewHolder holder;

    public MyAdapter(List<MyData.InfoListBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                View one = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_one, parent, false);
                holder = new ViewHolder_One(one);
                break;
            case 1:
                View two = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_two, parent, false);
                holder = new ViewHolder_Two(two);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        String type = mList.get(position).getType();
        int type2 = Integer.parseInt(type);
        switch (type2){
            case 0:
                ((ViewHolder_One)holder).title_one.setText(mList.get(position).getGoods_name());
                Glide.with(mContext).load(mList.get(position).getImg()).into(((ViewHolder_One)holder).img_one);
                ((ViewHolder_One)holder).img_one.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, XiangQingActivity.class);
                        intent.putExtra("name", mList.get(position).getGoods_name());
                        intent.putExtra("integral", mList.get(position).getIntegral());
                        intent.putExtra("likes", mList.get(position).getLikes());
                        intent.putExtra("img", mList.get(position).getImg());
                        mContext.startActivity(intent);
                    }
                });
                break;
            case 1:
                ((ViewHolder_Two)holder).title_two.setText(mList.get(position).getGoods_name());
                Glide.with(mContext).load(mList.get(position).getImg()).into(((ViewHolder_Two)holder).img_two);
                ((ViewHolder_Two)holder).img_two.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, XiangQingActivity.class);
                        intent.putExtra("name", mList.get(position).getGoods_name());
                        intent.putExtra("integral", mList.get(position).getIntegral());
                        intent.putExtra("likes", mList.get(position).getLikes());
                        intent.putExtra("img", mList.get(position).getImg());
                        mContext.startActivity(intent);
                    }
                });
                break;

        }

    }






    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return Integer.parseInt(mList.get(position).getType());

    }

    class ViewHolder_One extends RecyclerView.ViewHolder {

        private final ImageView img_one;
        private final TextView title_one;

        public ViewHolder_One(View itemView) {
            super(itemView);

            img_one = itemView.findViewById(R.id.img_one);
            title_one = itemView.findViewById(R.id.title_tv_one);
        }
    }

    class ViewHolder_Two extends RecyclerView.ViewHolder {

        private final ImageView img_two;
        private final TextView title_two;

        public ViewHolder_Two(View itemView) {
            super(itemView);

            img_two = itemView.findViewById(R.id.img_two);
            title_two = itemView.findViewById(R.id.title_tv_two);
        }
    }
}
