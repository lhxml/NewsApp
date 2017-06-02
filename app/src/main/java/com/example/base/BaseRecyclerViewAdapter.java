package com.example.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.common.base.*;
import com.example.common.base.BasePresenter;
import com.example.common.listener.OnItemClickListener;
import com.example.common.utils.TUtil;
import com.example.util.LoadHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxl on 2017/5/26.
 * 带刷新加载的adapter
 */

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM =0;  //普通Item View
    private static final int TYPE_FOOTER = 1;  //顶部FootView

    private Context mContext;
    private List<T> tList;

    protected OnItemClickListener mOnItemClickListener;



    public BaseRecyclerViewAdapter(Context mContext){
        this.mContext = mContext;
        tList = new ArrayList<T>();
    }

    public void setList(List<T> tList){
        Log.i("ListAdater==", "setList: "+tList);
        if(tList!=null){

            this.tList = tList;
        }else{
            this.tList = new ArrayList<>();
        }
        this.notifyDataSetChanged();
    }

    public void addList(List<T> tList){
        if(tList!=null){
            this.tList.addAll(tList);
        }else{
            this.tList = new ArrayList<>();
        }
        this.notifyDataSetChanged();
    }

    public List<T> gettList() {
        return tList;
    }

    @Override
    public int getItemViewType(int position) {
        if(position+1==getItemCount()){
            return TYPE_FOOTER;
        }else{
            return TYPE_ITEM;
        }

    }

    @Override
    public int getItemCount() {
        return tList.size() == 0 ? 0 : tList.size()+1;
    }

    public abstract int getItemLayoutId();//布局的layout

    public abstract void convert(RecyclerView.ViewHolder holder,T data);

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==TYPE_ITEM){
            BaseViewHolder holder = new BaseViewHolder(LayoutInflater.from(mContext).inflate(getItemLayoutId(),parent,false));

            return holder;
        }else{
            LoadHelper loadHelper = LoadHelper.getInstance(mContext);
            View view = loadHelper.getmLoadingFooterView();
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            return new MyFooterViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof BaseViewHolder){
            convert((BaseViewHolder)holder,tList.get(position));
        }else if(holder instanceof MyFooterViewHolder){
            LoadHelper.getInstance(mContext).startLoadMore();
        }
    }

    static class MyFooterViewHolder extends RecyclerView.ViewHolder{

        public MyFooterViewHolder(View itemView) {
            super(itemView);
        }
    }


    public void setOnItemClickListener(OnItemClickListener listener){
        mOnItemClickListener = listener;
    }


}
