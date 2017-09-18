package plpetkov.everlivedemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.telerik.everlive.sdk.core.EverliveApp;
import com.telerik.everlive.sdk.core.EverliveAppSettings;
import com.telerik.everlive.sdk.core.query.definition.FileField;
import com.telerik.everlive.sdk.core.result.RequestResult;
import com.telerik.everlive.sdk.core.result.RequestResultCallbackAction;

import org.apache.http.HttpRequest;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
//import com.telerik.everlive.*;

public class MainActivity extends AppCompatActivity {

    EverliveApp myApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                getAllEntries();
//                createEntry();
                uploadFile();
            }

        });

        initializeSdk();
    }

    private void uploadFile() {
        InputStream is = getResources().openRawResource(R.raw.cloud);

        FileField ff = new FileField("cloud.png", "image/png", is);

        myApp.workWith().files().upload(ff).executeAsync(new RequestResultCallbackAction() {
            @Override
            public void invoke(RequestResult requestResult) {
                if(requestResult.getSuccess()) {
                    System.out.println("Success");
                }
                else {
                    System.out.println("Error");
                }
            }
        });
    }

    private void initializeSdk() {
        String appId = "pgropx6b52e4bmkk";
        EverliveAppSettings appSettings = new EverliveAppSettings();
        appSettings.setAppId(appId);
        appSettings.setUseHttps(true);

        myApp = new EverliveApp(appSettings);
    }

    private void createEntry() {
        CommonTable ct = new CommonTable();
        ct.setName("pesho");
        ct.setCount(10);
        myApp.workWith().data(CommonTable.class).create(ct).executeAsync(new RequestResultCallbackAction<CommonTable>() {
            @Override
            public void invoke(RequestResult<CommonTable> requestResult) {
                if(requestResult.getSuccess()) {
                    System.out.println("===== Success: " +requestResult.getValue().getName());
                }
                else {
                    System.out.println("===== Errror: " + requestResult.getError().toString());
                }
            }
        });
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void getAllEntries() {
        myApp.workWith().data(CommonTable.class).getAll().executeAsync(new RequestResultCallbackAction<ArrayList<CommonTable>>() {

            @Override
            public void invoke(RequestResult<ArrayList<CommonTable>> requestResult) {
                if(requestResult.getSuccess()) {
                    for (CommonTable res  : requestResult.getValue()) {
                        System.out.println("===== Success: " +res.getName());
                    }
                }
                else {
                    System.out.println("===== Errror: " + requestResult.getError().toString());
                }
            }
        });
    }
}
