package coldashes;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.samples.vision.ocrreader.R;

/**
 * Created by Coldashes on 11/29/2016.
 */

public class dataEntryActivity extends Activity {
    public void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.data_entry_activity);

        TextView searchedterm = (TextView) findViewById(R.id.foundword);
        searchedterm.setText(DataHolder.getData());
    }

    public void save(View view) {
        finish();
    }
}
