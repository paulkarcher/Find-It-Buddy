package coldashes;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ronald on 12/1/16.
 */

public class Word implements Parcelable {
    private String mWord = "";
    private String mSource = "";
    private String mDefinition = "";
    private String mDescription = "";

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(mWord);
        out.writeString(mSource);
        out.writeString(mDefinition);
        out.writeString(mDescription);
    }

    public static final Parcelable.Creator<Word> CREATOR = new Parcelable.Creator<Word>() {
        public Word createFromParcel(Parcel in) {
            return new Word(in);
        }

        public Word[] newArray(int size) {
            return new Word[size];
        }
    };

    Word(Parcel in){
        mWord = in.readString();
        mSource = in.readString();
        mDefinition = in.readString();
        mDescription = in.readString();
    }

    Word(String theWord, String theSource, String theDefinition, String theDescription) {
        mWord = theWord;
        mSource = theSource;
        mDefinition = theDefinition;
        mDescription = theDescription;
    }

    void setWord(String theWord) {
        mWord = theWord;
    }

    String getWord() {
        return mWord;
    }

    void setSoiurce(String theDescription) {
        mSource = theDescription;
    }

    String getSource() {
        return mSource;
    }

    void setDefinition(String theDefinitoin) {
        mDefinition = theDefinitoin;
    }

    String getDefinition() {
        return mDefinition;
    }
}


