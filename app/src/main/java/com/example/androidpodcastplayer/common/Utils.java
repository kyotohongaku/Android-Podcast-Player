package com.example.androidpodcastplayer.common;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class Utils {

    private Utils() {
        throw new AssertionError();
    }

    // hide the keyboard on executing search
    public static void hideKeyboard(Activity activity, IBinder windowToken) {
        InputMethodManager mgr = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(windowToken, 0);
    }

    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void showSnackbar(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
    }

    public static void showSnackbarSticky(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE);
    }

    // Check that a network connection is available
    public  static boolean isClientConnected(Context context) {

        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        return  activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    public static void loadPreviewWithGlide(Context context, String previewPath, ImageView view) {
        Glide.with(context)
                .load(previewPath)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(view);
    }


}
