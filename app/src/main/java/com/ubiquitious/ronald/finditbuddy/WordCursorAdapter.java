package com.ubiquitious.ronald.finditbuddy;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.ubiquitious.ronald.finditbuddy.data.WordContract.WordEntry;

/**
 * Created by paul on 11/17/16.
 */

public class WordCursorAdapter extends CursorAdapter {


    public WordCursorAdapter(Context context, Cursor c)
    {
        super(context, c, 0);
    }



}
