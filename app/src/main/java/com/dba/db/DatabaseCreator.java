package com.dba.db;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * Created by alan on 2017/6/13.
 */

public class DatabaseCreator {

    private static DatabaseCreator sInstance;
    private final MutableLiveData<Boolean> mIsDbCreated = new MutableLiveData<>();
    private AppDatabase mDb;
    private final AtomicBoolean mInitializing = new AtomicBoolean(true);

    private static final Object LOCK = new Object();

    public static DatabaseCreator getInstance(Context context){
        if (sInstance == null){
            synchronized (LOCK){
                if (sInstance == null){
                    sInstance = new DatabaseCreator();
                }
            }
        }
        return sInstance;
    }

    public LiveData<Boolean> isDatabaseCreated(){return mIsDbCreated;}

    public AppDatabase getDb() {return mDb;}

    @SuppressLint("StaticFieldLeak")
    public void createDb(Context context){

        if (!mInitializing.compareAndSet(true,false)){
            return;
        }

        mIsDbCreated.setValue(false);
        new AsyncTask<Context, Void, AppDatabase>(){

            @Override
            protected AppDatabase doInBackground(Context... params) {
                Context ct = params[0].getApplicationContext();
                ct.deleteDatabase(AppDatabase.DB_NAME);

                return Room.databaseBuilder(ct, AppDatabase.class, AppDatabase.DB_NAME).build();
            }

            @Override
            protected void onPostExecute(AppDatabase appDatabase) {
                super.onPostExecute(appDatabase);
                mDb = appDatabase;
                mIsDbCreated.setValue(true);
            }
        }.execute(context.getApplicationContext());
    }
}
