package coldashes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.samples.vision.ocrreader.R;

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

    }

    public void save(View view) {
        num++;
        Word newWord = new Word (DataHolder.getData(), sourceText.getText().toString(), definitionText.getText().toString(), descriptionText.getText().toString());
        Intent addToHistory = new Intent(getApplicationContext(), HistoryActivity.class);

        addToHistory.putExtra("Word", newWord);
        startActivity(addToHistory);
    }
}

