package coldashes;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import coldashes.data.DataHolder;

/**
 * Created by ronald on 12/8/16.
 */

public class MyAsyncThread extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String[] params) {


        String xml = getDefinition(DataHolder.getData());
        Log.v("MyAyncTask", xml);
        return "Data fetch was attempted.";
    }

    @Override
    protected void onPostExecute(String message) {
        Log.v("MyAyncTask", message);
    }

    public String getDefinition(String word) {
        HttpURLConnection con = null;
        InputStream is = null;
        String key = "6574d3d5-aa7a-4a8a-9063-e312b096015f";
        String theUrl = "http://www.dictionaryapi.com/api/v1/references/collegiate/xml/" + word + "?key=" + key;
        StringBuffer buffer = new StringBuffer();
        try {
            con = (HttpURLConnection) (new URL(theUrl)).openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.connect();

            Log.d("ADebugTag", "Value: " + "weatherdata");


            is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = br.readLine()) != null) {
                buffer.append(line + "\r\n");
            }

            is.close();
            con.disconnect();
            return buffer.toString();
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (Throwable t) {
            }
            try {
                con.disconnect();
            } catch (Throwable t) {
            }
        }
        return buffer.toString();
    }

}

