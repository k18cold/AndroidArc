package com.dba.db;

import android.arch.persistence.room.RoomDatabase;

/**
 *
 * Created by alan on 2017/6/13.
 */

//@Database(entities = LogItem.class, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    static final String DB_NAME = "mession-db";
}
