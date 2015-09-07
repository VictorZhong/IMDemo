package com.victor.imdemo.imdemo.client.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2015/9/7.
 */
public class UIUtil {

    private static final long DELAYED_TIME = 60 * 1000;
    public static WeakReference<Toast> mToast = null;

    public static void toastError(Context ctx, String message) {
        toast(ctx, message);
    }

    public static void toastError(Context ctx, int resId) {
        toast(ctx, resId);
    }

    public static void toastError(Context ctx, int errCode, int resId) {
        toast(ctx, ctx.getString(resId) + "(" + errCode + ")");
    }

    public static void toast(Context context, int resId) {
        if (context == null) {
            return;
        }
        String message = context.getString(resId);
        toast(context, message);
    }

    public static void toast(Context context, String str) {
        if (context == null) {
            return;
        }

        Toast toast;
        if (mToast == null || mToast.get() == null) {
            toast = Toast.makeText(context, str, Toast.LENGTH_SHORT);
            mToast = new WeakReference<Toast>(toast);
        } else {
            toast = mToast.get();
            if (toast != null) {
                toast.setText(str);
            }
        }
        if (toast != null) {
            toast.show();
        }
    }

    private static ProgressDialog dialog;
    private static Handler dialogHandle = new Handler(Looper.getMainLooper());
    static Runnable delayAction = null;

    public static void showProgress(Context context) {
        if(dialog != null){
            dialog.dismiss();
        }

        dialog = new ProgressDialog(context);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        if (delayAction != null) {
            dialogHandle.removeCallbacks(delayAction);
        }
        delayAction = new Runnable() {
            @Override
            public void run() {
                dismissProgress();
            }
        };
        dialogHandle.postDelayed(delayAction, DELAYED_TIME);
    }

    public static void dismissProgress() {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }

}

