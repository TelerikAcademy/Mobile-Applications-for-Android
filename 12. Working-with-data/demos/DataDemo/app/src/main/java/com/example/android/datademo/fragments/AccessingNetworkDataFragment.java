package com.example.android.datademo.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.android.datademo.R;
import com.example.android.datademo.helpers.DataParser;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class AccessingNetworkDataFragment extends Fragment {
  private View rootView;
  private ListView listView;
  private ArrayAdapter<String> adapter;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    rootView = (View) inflater.inflate(R.layout.fragment_network_access, container, false);
    listView = (ListView) rootView.findViewById(R.id.list_view);

    ((Button) rootView.findViewById(R.id.load_data_btn))
            .setOnClickListener(new LoadDataClickListener());

    return rootView;
  }

  private class LoadDataClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
      FetchDataTask forecastTask = new FetchDataTask();
      forecastTask.execute("94043");
    }
  }

  public class FetchDataTask extends AsyncTask<String, Void, String[]> {
    private final String LOG_TAG = FetchDataTask.class.getSimpleName();

    @Override
    protected String[] doInBackground(String... params) {
      // These two need to be declared outside the try/catch
      // so that they can be closed in the finally block.
      HttpURLConnection urlConnection = null;
      BufferedReader reader = null;

      String forecastJsonStr;

      String format = "json";
      String units = "metric";
      int numDays = 7;
      String appid = "db3f6e6995ade634f09ccd414ed12d78";

      try {
        final String FORECAST_BASE_URL = "http://api.openweathermap.org/data/2.5/forecast/daily";
        final String LATITUDE = "lat";
        final String LONGITUDE = "lon";
        final String FORMAT_PARAM = "mode";
        final String UNITS_PARAM = "units";
        final String DAYS_PARAM = "cnt";
        final String APPID_PARAM = "appid";

        Uri builtUri = Uri.parse(FORECAST_BASE_URL).buildUpon()
                .appendQueryParameter(LATITUDE, "42.69751")
                .appendQueryParameter(LONGITUDE, "23.32415")
                .appendQueryParameter(FORMAT_PARAM, format)
                .appendQueryParameter(UNITS_PARAM, units)
                .appendQueryParameter(DAYS_PARAM, Integer.toString(numDays))
                .appendQueryParameter(APPID_PARAM, appid)
                .build();

        // Construct the URL for the OpenWeatherMap query
        // Possible parameters are avaiable at OWM's forecast API page, at
        // http://openweathermap.org/API#forecast
        URL url = new URL(builtUri.toString());

        // Create the request to OpenWeatherMap, and open the connection
        urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.connect();

        // Read the input stream into a String
        InputStream inputStream = urlConnection.getInputStream();
        StringBuffer buffer = new StringBuffer();
        if (inputStream == null) {
          // Nothing to do.
          return null;
        }
        reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        while ((line = reader.readLine()) != null) {
          // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
          // But it does make debugging a *lot* easier if you print out the completed
          // buffer for debugging.
          buffer.append(line + "\n");
        }

        if (buffer.length() == 0) {
          // Stream was empty.  No point in parsing.
          return null;
        }

        forecastJsonStr = buffer.toString();
      } catch (IOException e) {
        Log.e(LOG_TAG, "Error " + e.getMessage(), e);
        // If the code didn't successfully get the weather data, there's no point in attemping
        // to parse it.
        return null;
      } finally {
        if (urlConnection != null) {
          urlConnection.disconnect();
        }

        if (reader != null) {
          try {
            reader.close();
          } catch (final IOException e) {
            Log.e(LOG_TAG, "Error closing stream", e);
          }
        }
      }

      String[] result = null;
      try {
        result = DataParser.getWeatherDataFromJson(forecastJsonStr, 7);
      } catch (JSONException e) {
        Log.e(LOG_TAG, "Error parsing JSON result", e);
      }

      return result;
    }

    @Override
    protected void onPostExecute(String[] forecast) {
      if (forecast != null) {
        adapter.clear();
        adapter.addAll(forecast);
      }
    }
  }
}
