package coldashes;


import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.google.android.gms.samples.vision.ocrreader.R;

import coldashes.data.WordContract;

/**
 * Created by paul on 11/17/16.
 */

public class WordCursorAdapter extends CursorAdapter {


    public WordCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // Inflate a list item view using the layout specified in list_item.xml
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }
    
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find individual views that we want to modify in the list item layout
        TextView WordTextView = (TextView) view.findViewById(R.id.word);
        TextView definitionTextView = (TextView) view.findViewById(R.id.definition);

        // Find the columns of word attributes that we're interested in
        int WordColumnIndex = cursor.getColumnIndex(WordContract.WordEntry.COLUMN_WORD_TEXT);
        int definitionColumnIndex = cursor.getColumnIndex(WordContract.WordEntry.COLUMN_WORD_DEFINITION);

        // Read the word attributes from the Cursor for the current word
        String wordName = cursor.getString(WordColumnIndex);
        String wordDefinition = cursor.getString(definitionColumnIndex);

        // If the word definition is empty string or null, then use some default text
        // that says "Unknown definition", so the TextView isn't blank.
        if (TextUtils.isEmpty(wordDefinition)) {
            wordDefinition = context.getString(R.string.unknown_definition);
        }

        // Update the TextViews with the attributes for the current word
        WordTextView.setText(wordName);
        definitionTextView.setText(wordDefinition);
    }


}
