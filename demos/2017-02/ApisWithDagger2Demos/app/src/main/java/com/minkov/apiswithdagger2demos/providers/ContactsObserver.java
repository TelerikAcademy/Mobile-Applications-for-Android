package com.minkov.apiswithdagger2demos.providers;

// ContentProvider
//  ContentResolver

import android.Manifest;
import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;

import com.minkov.apiswithdagger2demos.MainActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

import static android.provider.ContactsContract.*;

public class ContactsObserver {
    private final Context appContext;
    private MainActivity activityContext;

    String[] PROJECTION = {
            Data._ID,
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB
                    ? Data.DISPLAY_NAME_PRIMARY
                    : Data.DISPLAY_NAME,
            Data.LOOKUP_KEY
    };

    @Inject
    public ContactsObserver(Context appContext) {
        this.appContext = appContext;
    }

    public Observable<ContactInfo> insertContact(final String name) {
        return Observable.create(new ObservableOnSubscribe<ContactInfo>() {
            @Override
            public void subscribe(ObservableEmitter<ContactInfo> e) throws Exception {
                ContentResolver contentResolver = appContext.getContentResolver();

                ArrayList<ContentProviderOperation> ops = new ArrayList<>();
                int rawContactInsertIndex = ops.size();

                ops.add(ContentProviderOperation.newInsert(RawContacts.CONTENT_URI)
                        .withValue(RawContacts.ACCOUNT_TYPE, null)
                        .withValue(RawContacts.ACCOUNT_NAME, null).build());

                ops.add(ContentProviderOperation
                        .newInsert(Data.CONTENT_URI)
                        .withValueBackReference(Data.RAW_CONTACT_ID,
                                rawContactInsertIndex)
                        .withValue(Data.MIMETYPE, CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
                        .withValue(CommonDataKinds.StructuredName.DISPLAY_NAME, name)
                        .build());

                ContentProviderResult[] res = contentResolver.applyBatch(
                        ContactsContract.AUTHORITY, ops);

                e.onNext(new ContactInfo(name));
            }
        });
    }

    public Observable<List<ContactInfo>> getContacts() {
        if (ActivityCompat.checkSelfPermission(activityContext, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activityContext, new String[]{Manifest.permission.READ_CONTACTS}, 0);
        }

        return Observable.create(new ObservableOnSubscribe<List<ContactInfo>>() {
            @Override
            public void subscribe(ObservableEmitter<List<ContactInfo>> e) throws Exception {
                Cursor cursor = appContext.getContentResolver()
                        .query(Contacts.CONTENT_URI,
                                PROJECTION,
                                null,
                                null,
                                null
                        );
                int count = 0;
                ArrayList<ContactInfo> contactInfos = new ArrayList<ContactInfo>();
                while (cursor.moveToNext()) {
                    int columnIndex = cursor.getColumnIndex(Data.DISPLAY_NAME);
                    String name = cursor.getString(columnIndex);
                    contactInfos.add(new ContactInfo(name));
                }
                e.onNext(contactInfos);
            }
        });

    }

    public void setActivityContext(MainActivity activityContext) {
        this.activityContext = activityContext;
    }

    public class ContactInfo {

        private final String name;

        public ContactInfo(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
