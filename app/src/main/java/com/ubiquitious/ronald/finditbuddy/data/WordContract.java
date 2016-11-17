package com.ubiquitious.ronald.finditbuddy.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by paul on 11/17/16.
 */

public final class WordContract {

    private WordContract() {}

    public static final String CONTENT_AUTHORITY = "com.ubiquitous.ronald.finditbuddy";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_WORDS = "finditbuddy";

    public static final class WordEntry implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_WORDS);

        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_WORDS;

        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_WORDS;


        public final static String TABLE_NAME = "words";

        public final static String _ID = BaseColumns._ID;

        public final static String COLUMN_WORD_TEXT = "word";
        public final static String COLUMN_WORD_DEFINITION = "definition";
    }

}
