package com.example.util;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.ui.R;

/**
 * Created by lxl on 2017/4/15.
 */

public class DialogUtils {
    private static MaterialDialog dialog;
    public static void showProgressDialog(Context context,boolean horizontal){
        if(dialog==null||!dialog.isShowing()){
            dialog = new MaterialDialog.Builder(context)
                    .content(context.getString(R.string.material_dialog_content))
                    .progress(true,0)
                    .progressIndeterminateStyle(horizontal)
                    .build();
        }
        dialog.show();
    }

    public static void showBasicDialog(Context context,String text){
        if(dialog==null||!dialog.isShowing()){
            dialog = new MaterialDialog.Builder(context)
                    .content(text)
                    .positiveText(context.getString(R.string.confirm))
                    .show();
        }
    }
    public static void dismissDialog(){
        if(dialog!=null&&dialog.isShowing()){
            dialog.dismiss();
            dialog = null;
        }
    }



}
