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
import android.widget.ListView;


import com.google.android.gms.samples.vision.ocrreader.R;

import java.util.ArrayList;
import java.util.List;

import coldashes.data.DatabaseHandler;
import coldashes.data.WordInfo;


/**
 * Created by coldashes on 11/8/16.
 */

public class HistoryActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        DatabaseHandler db = new DatabaseHandler(this);


        // Reading all words
        List<WordInfo> words = db.getAllWordInfos();
        ArrayList<WordInfo> wordInfos = new ArrayList<WordInfo>();



        for (WordInfo cn : words) {
            String log = "Id: " + cn.getID() + " , Text: " + cn.getText() + " , Definition: " + cn.getDefinition();
            // Writing WordInfos to log
            Log.d("Name: ", log);

            wordInfos.add(new WordInfo(cn.getText(), cn.getDefinition()));

        }

        WordAdapter adapter = new WordAdapter(this, wordInfos);


        ListView listView = (ListView) findViewById(R.id.list);


        listView.setAdapter(adapter);
    }
}
