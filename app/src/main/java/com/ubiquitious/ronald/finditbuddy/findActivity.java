package com.ubiquitious.ronald.finditbuddy;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.MenuItem;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import static android.R.attr.bitmap;
import static android.R.attr.format;

/**
 * Created by ronald on 11/8/16.
 */

public class findActivity extends AppCompatActivity {
    protected void onCreate() {
        setContentView(R.layout.find_activity);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            Drawable d = new BitmapDrawable(getResources(), imageBitmap);



            ImageView theImage = (ImageView) findViewById(R.id.thePicture);

            theImage.setImageDrawable(d);

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.done:

                return true;
            case R.id.add:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
