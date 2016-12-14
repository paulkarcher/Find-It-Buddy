package coldashes.data;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.samples.vision.ocrreader.R;

import coldashes.data.WordInfo;
import coldashes.data.DatabaseHandler;


public class AddEntryActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_entry_activity);
        
        DatabaseHandler db = new DatabaseHandler(this);
        
        /**
         * CRUD Operations
         * */
        // Inserting WordInfos
        Log.d("Insert: ", "Inserting ..");
        db.addWordInfo(new WordInfo("Paul", "cool dude"));
        db.addWordInfo(new WordInfo("Test", "a procedure intended to test."));

 
        // Reading all words
        Log.d("Reading: ", "Reading all words..");
        List<WordInfo> words = db.getAllWordInfos();       
 
        for (WordInfo cn : words) {
            String log = "Id: "+cn.getID()+" , Text: " + cn.getText() + " , Definition: " + cn.getDefinition();
                // Writing WordInfos to log
        Log.d("Name: ", log);
        
        }
    }
}