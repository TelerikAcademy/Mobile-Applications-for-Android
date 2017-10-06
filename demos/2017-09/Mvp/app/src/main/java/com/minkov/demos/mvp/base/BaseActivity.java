package com.minkov.demos.mvp.base;

import android.support.annotation.NonNull;

import com.minkov.demos.mvp.PersonsApplication;

import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by minkov on 10/6/17.
 */

public class BaseActivity extends DaggerAppCompatActivity {

    private OnRequestPermissionResultLister mOnRequestPermissionResultLister;

    @Override
    protected void onResume() {
        super.onResume();
        ((PersonsApplication) getApplication())
                .setCurrentActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((PersonsApplication) getApplication())
                .setCurrentActivity(null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        ((PersonsApplication) getApplication())
                .setCurrentActivity(null);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (mOnRequestPermissionResultLister == null) {
            return;
        }
        
        mOnRequestPermissionResultLister.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void setOnRequestPermissionResultLister(OnRequestPermissionResultLister onRequestPermissionResultLister) {
        mOnRequestPermissionResultLister = onRequestPermissionResultLister;
    }

    public interface OnRequestPermissionResultLister {
        void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults);
    }
}
