package com.example.common.base;

import android.graphics.Bitmap;
import android.support.v4.graphics.BitmapCompat;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.common.utils.ImageLoaderUtils;

/**
 * Created by lxl on 2017/5/26.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder{
    private final SparseArray<View> mViews = new SparseArray<>();

    public OnItemClickListener mOnItemClickListener;

    View itemView;

    public BaseViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
    }

    public <T extends View> void setOnClickListener(int id){
        T view = get(id);
        view.setOnClickListener(l->mOnItemClickListener.OnItemClick(l,this.getLayoutPosition()));
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

    public interface OnItemClickListener{
        public void OnItemClick(View view,int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mOnItemClickListener = listener;
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
