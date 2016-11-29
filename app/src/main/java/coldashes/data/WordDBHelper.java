package coldashes.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import coldashes.data.WordContract.WordEntry;

/**
 * Created by paul on 11/17/16.
 */

public class WordDBHelper extends SQLiteOpenHelper {
    
    public static final String LOG_TAG = WordDBHelper.class.getSimpleName();

    /** Name of the database file */
    private static final String DATABASE_NAME = "word_history.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link WordDBHelper}.
     *
     * @param context of the app
     */
    public WordDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the words table
        String SQL_CREATE_WORDS_TABLE =  "CREATE TABLE " + WordEntry.TABLE_NAME + " ("
                + WordEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + WordEntry.COLUMN_WORD_TEXT + " TEXT NOT NULL, "
                + WordEntry.COLUMN_WORD_DEFINITION + " TEXT);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_WORDS_TABLE);
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }
}
