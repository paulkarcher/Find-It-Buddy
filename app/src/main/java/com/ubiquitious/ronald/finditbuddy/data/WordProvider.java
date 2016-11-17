package com.ubiquitious.ronald.finditbuddy.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import com.ubiquitious.ronald.finditbuddy.data.WordContract.WordEntry;

/**
 * Created by paul on 11/17/16.
 */

public class WordProvider extends ContentProvider {
    public static final String LOG_TAG = WordProvider.class.getSimpleName();
}
