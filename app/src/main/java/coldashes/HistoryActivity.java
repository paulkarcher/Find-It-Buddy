package coldashes;

import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.samples.vision.ocrreader.R;

import coldashes.data.WordContract.WordEntry;

/**
 * Created by coldashes on 11/8/16.
 */

public class HistoryActivity extends AppCompatActivity implements
        LoaderManager.LoaderCallbacks<Cursor> {
    Word newWord;
    /** Identifier for the word data loader */
    private static final int WORD_LOADER = 0;

    /** Adapter for the ListView */
    WordCursorAdapter mCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        if(getIntent().getParcelableExtra("Word") != null){
            newWord = (Word) getIntent().getParcelableExtra("Word");
            Log.v("historyactivity ", newWord.getWord());
        }
        //getLoaderManager().initLoader(WORD_LOADER, null, this);
    }

    /**
     * Helper method to insert hardcoded word data into the database. For debugging purposes only.
     */
    private void insertWord() {
        ContentValues values = new ContentValues();
        values.put(WordEntry.COLUMN_WORD_TEXT, "Rush");
        values.put(WordEntry.COLUMN_WORD_DEFINITION, "A great band.");

        // Insert a new row for dummy data into the provider using the ContentResolver.
        // Use the {@link WordEntry#CONTENT_URI} to indicate that we want to insert
        // into the words database table.
        // Receive the new content URI that will allow us to access dummy data in the future.
        Uri newUri = getContentResolver().insert(WordEntry.CONTENT_URI, values);
    }

    /**
     * Helper method to delete all words in the database.
     */
    private void deleteAllWords() {
        int rowsDeleted = getContentResolver().delete(WordEntry.CONTENT_URI, null, null);
        Log.v("HistoryActivity", rowsDeleted + " rows deleted from word database");
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        // Define a projection that specifies the columns from the table we care about.
        String[] projection = {
                WordEntry._ID,
                WordEntry.COLUMN_WORD_TEXT,
                WordEntry.COLUMN_WORD_DEFINITION };

        // This loader will execute the ContentProvider's query method on a background thread
        return new CursorLoader(this,   // Parent activity context
                WordEntry.CONTENT_URI,   // Provider content URI to query
                projection,             // Columns to include in the resulting Cursor
                null,                   // No selection clause
                null,                   // No selection arguments
                null);                  // Default sort order
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        // Update {@link WordCursorAdapter} with this new cursor containing updated word data
        mCursorAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        // Callback called when the data needs to be deleted
        mCursorAdapter.swapCursor(null);
    }

    @Override
    public void onResume(){
        super.onResume();

        // When the activity is resumed it will get the word if there is one
        if(getIntent().getParcelableExtra("Word") != null){
            newWord = (Word) getIntent().getParcelableExtra("Word");
            // Need to add this word to the database
            // then create the
            Log.v("historyactivity ", newWord.getWord());
        }
    }
}
