package com.example.android.datademo.helpers;

import android.text.format.Time;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;

public class DataParser {
  private static final String LOG_TAG = DataParser.class.getSimpleName();

  public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex) throws JSONException {
    JSONObject jsonRootObject = new JSONObject(weatherJsonStr);
    JSONArray days = jsonRootObject.getJSONArray("list");
    JSONObject dayInfo = days.getJSONObject(dayIndex);
    JSONObject temperatureInfo = dayInfo.getJSONObject("temp");
    return temperatureInfo.getDouble("max");
  }

  /* The date/time conversion code is going to be moved outside the asynctask later,
   * so for convenience we're breaking it out into its own method now.
   */
  private static String getReadableDateString(long time){
    // Because the API returns a unix timestamp (measured in seconds),
    // it must be converted to milliseconds in order to be converted to valid date.
    SimpleDateFormat shortenedDateFormat = new SimpleDateFormat("EEE MMM dd");
    return shortenedDateFormat.format(time);
  }

  /**
   * Prepare the weather high/lows for presentation.
   */
  private static String formatHighLows(double high, double low) {
    // For presentation, assume the user doesn't care about tenths of a degree.
    long roundedHigh = Math.round(high);
    long roundedLow = Math.round(low);

    String highLowStr = roundedHigh + "/" + roundedLow;
    return highLowStr;
  }

  /**
   * Take the String representing the complete forecast in JSON Format and
   * pull out the data we need to construct the Strings needed for the wireframes.
   *
   * Fortunately parsing is easy:  constructor takes the JSON string and converts it
   * into an Object hierarchy for us.
   */
  public static String[] getWeatherDataFromJson(String forecastJsonStr, int numDays)
          throws JSONException {

    // These are the names of the JSON objects that need to be extracted.
    final String OWM_LIST = "list";
    final String OWM_WEATHER = "weather";
    final String OWM_TEMPERATURE = "temp";
    final String OWM_MAX = "max";
    final String OWM_MIN = "min";
    final String OWM_DESCRIPTION = "main";

    JSONObject forecastJson = new JSONObject(forecastJsonStr);
    JSONArray weatherArray = forecastJson.getJSONArray(OWM_LIST);

    // OWM returns daily forecasts based upon the local time of the city that is being
    // asked for, which means that we need to know the GMT offset to translate this data
    // properly.

    // Since this data is also sent in-order and the first day is always the
    // current day, we're going to take advantage of that to get a nice
    // normalized UTC date for all of our weather.

    Time dayTime = new Time();
    dayTime.setToNow();

    // we start at the day returned by local time. Otherwise this is a mess.
    int julianStartDay = Time.getJulianDay(System.currentTimeMillis(), dayTime.gmtoff);

    // now we work exclusively in UTC
    dayTime = new Time();

    String[] resultStrs = new String[numDays];
    for(int i = 0; i < weatherArray.length(); i++) {
      // For now, using the format "Day, description, hi/low"
      String day;
      String description;
      String highAndLow;

      // Get the JSON object representing the day
      JSONObject dayForecast = weatherArray.getJSONObject(i);

      // The date/time is returned as a long.  We need to convert that
      // into something human-readable, since most people won't read "1400356800" as
      // "this saturday".
      long dateTime;
      // Cheating to convert this to UTC time, which is what we want anyhow
      dateTime = dayTime.setJulianDay(julianStartDay+i);
      day = getReadableDateString(dateTime);

      // description is in a child array called "weather", which is 1 element long.
      JSONObject weatherObject = dayForecast.getJSONArray(OWM_WEATHER).getJSONObject(0);
      description = weatherObject.getString(OWM_DESCRIPTION);

      // Temperatures are in a child object called "temp".  Try not to name variables
      // "temp" when working with temperature.  It confuses everybody.
      JSONObject temperatureObject = dayForecast.getJSONObject(OWM_TEMPERATURE);
      double high = temperatureObject.getDouble(OWM_MAX);
      double low = temperatureObject.getDouble(OWM_MIN);

      highAndLow = formatHighLows(high, low);
      resultStrs[i] = day + " - " + description + " - " + highAndLow;
    }

//    for (String s : resultStrs) {
//      Log.v(LOG_TAG, "Forecast entry: " + s);
//    }
    return resultStrs;

  }
}