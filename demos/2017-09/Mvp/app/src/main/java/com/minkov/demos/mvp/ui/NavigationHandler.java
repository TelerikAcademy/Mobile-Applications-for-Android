package com.minkov.demos.mvp.ui;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.minkov.demos.mvp.ui.base.NavigationHandlerBase;

import javax.inject.Inject;

/**
 * Created by minkov on 9/27/17.
 */

public class NavigationHandler implements NavigationHandlerBase{
  private final Context mContext;

  @Inject
  public NavigationHandler(Context context) {
    mContext = context;
  }

  public void navigateTo(Intent intent) {
    mContext.startActivity(intent);
  }

//  public void navigateBack() {
//    navigateBack(null);
//  }
//
//  public void navigateBack(Intent intent) {
//    if(intent == null) {
//      ((Application) mContext).
//    }
//  }

}
