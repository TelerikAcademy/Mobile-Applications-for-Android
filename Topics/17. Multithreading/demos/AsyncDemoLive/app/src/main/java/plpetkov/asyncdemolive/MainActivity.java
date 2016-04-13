package plpetkov.asyncdemolive;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements InterestingEvent {

    private Context mContext;
    private TextView firstCounter;
    private TextView secondCounter;
    private Integer staticCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firstCounter = (TextView)findViewById(R.id.tv_conter);
        secondCounter = (TextView)findViewById(R.id.tv_second_counter);
        mContext = this;

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
//                demoOne();

                demoTwo();
            }
        });
    }

    private void demoTwo() {
        new Thread(new Runnable() {
            @Override
            public void run() {


                // do hard work
                new Activity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //don't do it directly
                        firstCounter.setText("1");
                    }
                });
                // update main thread
                firstCounter.post(new Runnable() {
                    @Override
                    public void run() {
                        //don't do it directly
                        firstCounter.setText("1");
                    }
                });
            }
        }).start();
    }

    private void demoOne() {
        System.out.println("====== From MAIN: PID: " + android.os.Process.myPid());
        System.out.println("====== From MAIN: TID: " + Thread.currentThread().getId());
        incrementCounter();
    }

    private void incrementCounter() {
        secondCounter.setText("" + staticCount++);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
//            startAsyncTask(); //from demo 1
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private  void startAsyncTask () {
        DownloadAsync da = new DownloadAsync(mContext, (InterestingEvent)mContext);
        try {
            da.execute(new URL("https://www.task.com"), new URL("https://www.task.com"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void resolve(Integer progress) {
        firstCounter.setText("" + progress);
    }
}
