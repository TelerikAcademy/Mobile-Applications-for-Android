package com.minkov.apiswithdagger2demos;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.minkov.apiswithdagger2demos.providers.ContactsObserver;
import com.minkov.apiswithdagger2demos.providers.LocationObserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;
import pl.aprilapps.easyphotopicker.EasyImage;

public class MainActivity extends AppCompatActivity
        implements Consumer<Object>, EasyImage.Callbacks {
    @Inject
    public LocationObserver locationObserver;

    @Inject
    public ContactsObserver contactsObserver;

    private TextView tvLatitude;
    private TextView tvLongitude;
    private TextView tvAltitude;
    private ListView lvContacts;
    private ArrayAdapter<String> adapter;
    private ImageView ivCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tvLatitude = (TextView) this.findViewById(R.id.tvLatitude);
        this.tvLongitude = (TextView) this.findViewById(R.id.tvLongitude);
        this.tvAltitude = (TextView) this.findViewById(R.id.tvAltitude);

        this.adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        this.lvContacts = (ListView) this.findViewById(R.id.lvContacts);
        this.lvContacts.setAdapter(this.adapter);

        this.ivCamera = (ImageView) this.findViewById(R.id.ivCamera);

        this.inject();

//        this.locationObserver.setActivityContext(this);

//        this.locationObserver.getLocationObserver()
//                .observeOn(Schedulers.io())
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .subscribe(this);

//        this.contactsObserver.setActivityContext(this);
//
//        this.contactsObserver.insertContact("John")
//                .switchMap(new Function<ContactsObserver.ContactInfo, ObservableSource<?>>() {
//                    @Override
//                    public ObservableSource<?> apply(ContactsObserver.ContactInfo contactInfo) throws Exception {
//                        return contactsObserver.getContacts();
//                    }
//                })
//                .observeOn(Schedulers.io())
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .subscribe(MainActivity.this);

        EasyImage.Configuration config = EasyImage.configuration(this)
                .saveInAppExternalFilesDir();

        EasyImage.openCamera(this, EasyImage.REQ_SOURCE_CHOOSER);
    }

    private void inject() {
        ((ApisApplication) this.getApplication())
                .getComponent()
                .inject(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        EasyImage.handleActivityResult(requestCode, resultCode, data, this, this);
    }

    @Override
    public void accept(final Object object) throws Exception {
        if (object instanceof Location) {
            this.updateLocation((Location) object);
        } else if (object instanceof List) {
            this.updateContacts((List<ContactsObserver.ContactInfo>) object);
        }
    }

    private void updateContacts(List<ContactsObserver.ContactInfo> contactInfos) {
        final List<String> names = new ArrayList<>(contactInfos.size());
        for (ContactsObserver.ContactInfo info : contactInfos) {
            names.add(info.getName());
        }

        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.clear();
                adapter.addAll(names);
            }
        });
    }

    private void updateLocation(final Location location) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvLatitude.setText(location.getLatitude() + "");
                tvLongitude.setText(location.getLongitude() + "");
                tvAltitude.setText(location.getAltitude() + "");
            }
        });
    }

    @Override
    public void onImagePickerError(Exception e, EasyImage.ImageSource source, int type) {
        int b = 5;
    }

    @Override
    public void onImagePicked(File imageFile, EasyImage.ImageSource source, int type) {
        String path = imageFile.getAbsolutePath();
        Bitmap bitmap = BitmapFactory.decodeFile(path);

        this.ivCamera.setImageBitmap(bitmap);
        this.tvLatitude.setText(path);

//        File destFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES + File.separator + "New");
//        if (!destFile.exists()) {
//            int b = 5;
//        }
//        try {
//            moveFile(imageFile, destFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        File outDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);


        try {
            moveFile(imageFile, outDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCanceled(EasyImage.ImageSource source, int type) {

    }

    private void moveFile(File inFile, File outDir) throws IOException {
        String outPath = outDir.getAbsolutePath() + File.separator + inFile.getName();
        File outFile = new File(outPath);

        FileInputStream in = new FileInputStream(inFile);
        FileOutputStream out = new FileOutputStream(outFile);

        byte[] buffer = new byte[4096];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }

        in.close();

        out.flush();
        out.close();
    }
}
