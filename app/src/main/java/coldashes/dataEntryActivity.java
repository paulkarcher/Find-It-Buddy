package coldashes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.samples.vision.ocrreader.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import coldashes.data.DataHolder;
import coldashes.data.DatabaseHandler;
import coldashes.data.WordInfo;

import static android.R.attr.key;
import static android.util.Log.d;

/**
 * Created by Coldashes on 11/29/2016.
 */


public class dataEntryActivity extends Activity {
    private EditText sourceText;
    private EditText descriptionText;
    private EditText definitionText;
    static int num = 0;

    public void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.data_entry_activity);

        TextView searchedterm = (TextView) findViewById(R.id.foundword);
        descriptionText = (EditText) findViewById(R.id.descr_tv);
        definitionText = (EditText) findViewById(R.id.def_tv);
        sourceText = (EditText) findViewById(R.id.source_tv);
        searchedterm.setText(DataHolder.getData());
        Log.v("DataEntryActivity", definitionText.getText().toString());
    }

    public void save(View view) {
        HttpURLConnection con = null;
        InputStream is = null;
        StringBuffer buffer = new StringBuffer();

        String theWord = DataHolder.getData();

        Log.v("DataEntryActivity", definitionText.getText().toString());
        if(definitionText.getText().toString().matches("")) {
            MyAsyncThread job = new MyAsyncThread();
        }

        num++;
        Word newWord = new Word (DataHolder.getData(), sourceText.getText().toString(), definitionText.getText().toString(), descriptionText.getText().toString());

        WordInfo newWordInfo = new WordInfo(newWord.getWord(), newWord.getDefinition());

        DatabaseHandler db = new DatabaseHandler(this);

        db.addWordInfo(new WordInfo(newWordInfo.getText(), newWordInfo.getDefinition()));

        Intent addToHistory = new Intent(getApplicationContext(), HistoryActivity.class);

        addToHistory.putExtra("Word", newWord);
        startActivity(addToHistory);
    }

}

