package coldashes.data;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 3;

	// Database Name
	private static final String DATABASE_NAME = "wordcollection";

	// Words table name
	private static final String TABLE_WORDINFOS = "words";

	// Words Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_TEXT = "text";
	private static final String KEY_DEF = "definition";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_WORDINFOS_TABLE = "CREATE TABLE " + TABLE_WORDINFOS + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_TEXT + " TEXT,"
				+ KEY_DEF + " TEXT" + ")";
		db.execSQL(CREATE_WORDINFOS_TABLE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORDINFOS);

		// Create tables again
		onCreate(db);
	}

	/**
	 * All CRUD(Create, Read, Update, Delete) Operations
	 */

	// Adding new word
	public void addWordInfo(WordInfo word) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_TEXT, word.getText()); // WordInfo Name
		values.put(KEY_DEF, word.getDefinition()); // WordInfo Phone

		// Inserting Row
		db.insert(TABLE_WORDINFOS, null, values);
		db.close(); // Closing database connection
	}

	// Getting single word
	WordInfo getWordInfo(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_WORDINFOS, new String[] { KEY_ID,
						KEY_TEXT, KEY_DEF}, KEY_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		WordInfo word = new WordInfo(Integer.parseInt(cursor.getString(0)),
				cursor.getString(1), cursor.getString(2));
		// return word
		return word;
	}
	
	// Getting All WordInfos
	public List<WordInfo> getAllWordInfos() {
		List<WordInfo> wordList = new ArrayList<WordInfo>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_WORDINFOS;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				WordInfo word = new WordInfo();
				word.setID(Integer.parseInt(cursor.getString(0)));
				word.setName(cursor.getString(1));
				word.setDefinition(cursor.getString(2));
				// Adding word to list
				wordList.add(word);
			} while (cursor.moveToNext());
		}

		// return word list
		return wordList;
	}

	// Updating single word
	public int updateWordInfo(WordInfo word) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_TEXT, word.getText());
		values.put(KEY_DEF, word.getDefinition());

		// updating row
		return db.update(TABLE_WORDINFOS, values, KEY_ID + " = ?",
				new String[] { String.valueOf(word.getID()) });
	}

	// Deleting single word
	public void deleteWordInfo(WordInfo word) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_WORDINFOS, KEY_ID + " = ?",
				new String[] { String.valueOf(word.getID()) });
		db.close();
	}


	// Getting words Count
	public int getWordInfosCount() {
		String countQuery = "SELECT  * FROM " + TABLE_WORDINFOS;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();

		// return count
		return cursor.getCount();
	}

}
