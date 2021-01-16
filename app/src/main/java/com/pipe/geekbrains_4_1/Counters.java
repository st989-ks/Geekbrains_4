package com.pipe.geekbrains_4_1;

import android.os.Parcel;
import android.os.Parcelable;

public class Counters implements Parcelable {

    private StringBuffer counter = new StringBuffer("");
    private String counterParcel;

    public Counters() {
        this.counter.append("");
    }

    protected Counters(Parcel in) {
        counterParcel = in.readString();
    }

    public static final Creator<Counters> CREATOR = new Creator<Counters>() {
        @Override
        public Counters createFromParcel(Parcel in) {
            return new Counters(in);
        }

        @Override
        public Counters[] newArray(int size) {
            return new Counters[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Integer.parseInt(counter.toString()));
    }

    public void setCounter(String counter) {
        this.counter.append(counter);
    }

    public void clearCounter() {
        counter.setLength(counter.length() - 1);
    }

    public String getCounter() {
        return counter.toString();
    }

//    public void incrementView(String counter) {
//        this.counter = counter;
//    }
}