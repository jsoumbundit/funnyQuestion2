package thailand.soumbundit.jirawat.funnyquestion.utility;

import android.os.Parcel;
import android.os.Parcelable;

public class ScoreTestModel implements Parcelable {

    private  String Language,Listening,NameUnit,Practice, WarmUp;

    public ScoreTestModel(){
    }

    public ScoreTestModel(String language, String listening, String nameUnit, String practice, String warmUp) {
        Language = language;
        Listening = listening;
        NameUnit = nameUnit;
        Practice = practice;
        WarmUp = warmUp;
    }

    protected ScoreTestModel(Parcel in) {
        Language = in.readString();
        Listening = in.readString();
        NameUnit = in.readString();
        Practice = in.readString();
        WarmUp = in.readString();
    }

    public static final Creator<ScoreTestModel> CREATOR = new Creator<ScoreTestModel>() {
        @Override
        public ScoreTestModel createFromParcel(Parcel in) {
            return new ScoreTestModel(in);
        }

        @Override
        public ScoreTestModel[] newArray(int size) {
            return new ScoreTestModel[size];
        }
    };

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getListening() {
        return Listening;
    }

    public void setListening(String listening) {
        Listening = listening;
    }

    public String getNameUnit() {
        return NameUnit;
    }

    public void setNameUnit(String nameUnit) {
        NameUnit = nameUnit;
    }

    public String getPractice() {
        return Practice;
    }

    public void setPractice(String practice) {
        Practice = practice;
    }

    public String getWarmUp() {
        return WarmUp;
    }

    public void setWarmUp(String warmUp) {
        WarmUp = warmUp;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Language);
        parcel.writeString(Listening);
        parcel.writeString(NameUnit);
        parcel.writeString(Practice);
        parcel.writeString(WarmUp);
    }
}
