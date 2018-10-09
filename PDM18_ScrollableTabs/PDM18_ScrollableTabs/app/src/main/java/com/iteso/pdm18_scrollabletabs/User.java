package com.iteso.pdm18_scrollabletabs;
import android.os.Parcel;
import android.os.Parcelable;
public class User implements Parcelable {
    String name, password;
    boolean isLogged;
    public User(){
    }
    public User(String name, String password, boolean isLogged) {
        this.name = name;
        this.password = password;
        this.isLogged = isLogged;
    }

    protected User(Parcel in) {
        this.name = in.readString();
        this.password = in.readString();
        this.isLogged = in.readByte() != 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.password);
        dest.writeByte(this.isLogged ? (byte) 1 : (byte) 0);

    }
    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogged()
    {
        return isLogged;
    }

    public void setLogged(boolean logged) {

        isLogged = logged;
    }


}

