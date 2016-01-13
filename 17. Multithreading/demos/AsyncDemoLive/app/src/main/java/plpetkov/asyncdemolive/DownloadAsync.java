package plpetkov.asyncdemolive;

import android.content.Context;
import android.os.AsyncTask;

import java.net.URL;

/**
 * Created by 20473 on 1/12/2016.
 */
public class DownloadAsync extends AsyncTask<URL, Integer, Void> {

    private Context mContext;
    private  InterestingEvent mIe;
    public  DownloadAsync(Context context, InterestingEvent ie) {
        mContext = context;
        mIe = ie;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(URL... params) {

        for (int i = 0; i < params.length; i++) {
            try {
                Thread.sleep(1000);
//                publishProgress(i);

                System.out.println("====== From BGT: PID: " + android.os.Process.myPid());
                System.out.println("====== From BGT: TID: " + Thread.currentThread().getId());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //cancel
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        mIe.resolve(values[0]);
    }
}
