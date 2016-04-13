package com.example.android.datademo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.datademo.R;

public class SQLiteFragment extends Fragment {
  private View rootView;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    rootView = (View) inflater.inflate(R.layout.fragment_sqlite, container, false);

    return rootView;
  }
}
