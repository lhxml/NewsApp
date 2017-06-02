package com.example.common.base;

import android.graphics.Bitmap;
import android.support.v4.graphics.BitmapCompat;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.common.listener.OnItemClickListener;
import com.example.common.utils.ImageLoaderUtils;

/**
 * Created by lxl on 2017/5/26.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder{
    private final SparseArray<View> mViews = new SparseArray<>();


    View itemView;

    public BaseViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
    }

    public <T extends View> void setOnClickListener(int id, final OnItemClickListener listener){
        T view = get(id);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.OnItemClick(view,BaseViewHolder.this.getLayoutPosition());
            }
        });
    }

    public <T extends View> T get(int id){
        return (T)bindView(id);
    }

    public <T extends View> T bindView(int id){
        T view = (T) mViews.get(id);
        if(view==null){
            view = (T) itemView.findViewById(id);
            mViews.put(id,view);
        }
        return view;
    }




    public BaseViewHolder setText(int viewId,String text){
        TextView view = get(viewId);
        view.setText(text);
        return this;
    }

    public BaseViewHolder setImageResource(int viewId,int drawableId){
        ImageView view = get(viewId);
        view.setImageResource(drawableId);
        return this;
    }

    public BaseViewHolder setImageBitmap(int viewId,Bitmap bitmap){
        ImageView view = get(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }

    public BaseViewHolder setImageByUrl(int viewId,String imageUrl){
        ImageView view = get(viewId);
        ImageLoaderUtils.display(BaseApplication.getAppContext(),view,imageUrl);
        return this;
    }
}
