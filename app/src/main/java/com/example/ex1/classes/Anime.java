package com.example.ex1.classes;

import android.os.Parcel;
import android.os.Parcelable;

public class Anime implements Parcelable {
    private int id;
    private String name;
    private int n_eps;

    public Anime (String name, int eps, int id) {
        setN_eps(eps);
        setName(name);
        setId(id);
    }

    public void setId(int id) { this.id = id; }

    public void setN_eps(int n_eps) {
        this.n_eps = n_eps;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getN_eps() {
        return n_eps;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "Name: " + getName() + "\nN eps:" + getN_eps();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Anime> CREATOR = new Creator<Anime>() {
        @Override
        public Anime createFromParcel(Parcel in) {
            return new Anime(in);
        }

        @Override
        public Anime[] newArray(int size) {
            return new Anime[size];
        }
    };

    private Anime(Parcel in) {
        name = in.readString();
        n_eps = in.readInt();
        id = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(n_eps);
        dest.writeInt(id);
    }
}
