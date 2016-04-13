package com.example.android.datademo.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.datademo.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InternalStorageFragment extends Fragment {
  private static final String FILE_NAME = "myfile";
  private static final String LOG_TAG = InternalStorageFragment.class.getSimpleName();
  private View rootView;
  File file;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    rootView = (View) inflater.inflate(R.layout.fragment_internal_storage, container, false);
    file = new File(getContext().getFilesDir(), FILE_NAME);

    ((Button) rootView.findViewById(R.id.save_to_file_btn))
            .setOnClickListener(new SaveToFileClickListener());
    ((Button) rootView.findViewById(R.id.get_from_file_btn))
            .setOnClickListener(new GetFromFileClickListener());
    ((Button) rootView.findViewById(R.id.delete_file))
            .setOnClickListener(new DeleteFileClickListener());

    return rootView;
  }

  private class SaveToFileClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
      String text = ((EditText) rootView.findViewById(R.id.text_for_file)).getText().toString();
      FileOutputStream outputStream;

      try {
        outputStream = getContext().openFileOutput(FILE_NAME, Context.MODE_APPEND);
        outputStream.write(text.getBytes());
        outputStream.close();

        Toast.makeText(getContext(), "Text saved to file", Toast.LENGTH_SHORT).show();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  private class GetFromFileClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
      String text = null;
      FileInputStream inputStream;

      try {
        inputStream = getContext().openFileInput(FILE_NAME);
        text = readStream(inputStream);
        inputStream.close();
      } catch (Exception e) {
        e.printStackTrace();
      }

      ((TextView) rootView.findViewById(R.id.text_from_file))
              .setText(text);
    }
  }

  private String readStream(FileInputStream inputStream) {
    String result = null;
    BufferedReader reader = null;
    StringBuffer buffer = new StringBuffer();

    if (inputStream == null) {
      // Nothing to do.
      return null;
    }
    reader = new BufferedReader(new InputStreamReader(inputStream));

    String line;
    try {
      while ((line = reader.readLine()) != null) {
        // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
        // But it does make debugging a *lot* easier if you print out the completed
        // buffer for debugging.
        buffer.append(line + "\n");
      }
    } catch (IOException e) {
      Log.e(LOG_TAG, e.getMessage());
    }

    if (buffer.length() == 0) {
      // Stream was empty.  No point in parsing.
      return null;
    }

    result = buffer.toString();
    return result;
  }

  private class DeleteFileClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
      // file.delete();
      getContext().deleteFile(FILE_NAME);

      Toast.makeText(getContext(), "The file is no more", Toast.LENGTH_SHORT).show();
    }
  }
}
