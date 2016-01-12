package com.example.android.datademo.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.datademo.R;

public class SharedPreferencesFragment extends Fragment {
  private View rootView;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    rootView = (View) inflater.inflate(R.layout.fragment_shared_preferences, container, false);

    ((Button) rootView.findViewById(R.id.save_prefs_btn))
            .setOnClickListener(new SavePrefsOnClickListener());

    ((Button) rootView.findViewById(R.id.get_prefs_btn))
            .setOnClickListener(new GetPrefsOnClickListener());

    return rootView;
  }

  private class SavePrefsOnClickListener implements View.OnClickListener {

    @Override
    public void onClick(View v) {
      String username = ((EditText) rootView.findViewById(R.id.username_text)).getText().toString();

      getActivity()
              .getPreferences(Context.MODE_PRIVATE)
              .edit().putString(getString(R.string.username), username)
              .commit();

      Toast.makeText(getActivity(), "Saved to preferences", Toast.LENGTH_SHORT).show();
    }
  }

  private class GetPrefsOnClickListener implements View.OnClickListener {

    @Override
    public void onClick(View v) {
      String key = getString(R.string.username);

      String value = getActivity()
              .getPreferences(Context.MODE_PRIVATE)
              .getString(key, "non existent");

      Toast.makeText(getActivity(), key + " => " + value, Toast.LENGTH_SHORT).show();
      Toast.makeText(getActivity(), key + " => " + value, Toast.LENGTH_SHORT).show();
    }
  }
}
