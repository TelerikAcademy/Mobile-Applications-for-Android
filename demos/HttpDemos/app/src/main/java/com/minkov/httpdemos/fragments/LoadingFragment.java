package com.minkov.httpdemos.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v4.app.Fragment;

public class LoadingFragment extends Fragment {


    private ProgressDialog loadingDialog;
    private Context context;

    public LoadingFragment() {

    }

    public void show() {
        if (this.loadingDialog == null) {
            this.loadingDialog = new ProgressDialog(this.context);
            this.loadingDialog.setMessage("Please wait...");
            this.loadingDialog.setCancelable(false);
        }

        this.loadingDialog.show();
    }

    public void hide() {
        this.loadingDialog.hide();
    }

    public static LoadingFragment create(Context context) {
        LoadingFragment loadingFragment = new LoadingFragment();
        loadingFragment.setContext(context);
        return loadingFragment;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
