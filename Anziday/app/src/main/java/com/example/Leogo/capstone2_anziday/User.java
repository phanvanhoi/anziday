package com.example.Leogo.capstone2_anziday;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String fullName;
    private String userName;
    private String passWord;
    private String dateBirth;
    private String address;
    private String allergy;
    private String illness;
    private String groupPerson;

    public User(String fullName, String userName, String passWord, String address, String allergy, String illness, String groupPerson,String dateBirth) {
        this.fullName = fullName;
        this.userName = userName;
        this.passWord = passWord;
        this.address = address;
        this.allergy = allergy;
        this.illness = illness;
        this.groupPerson = groupPerson;
        this.dateBirth = dateBirth;
    }

    public User(){

    }

    protected User(Parcel in) {
        this.fullName = in.readString();
        this.userName = in.readString();
        this.passWord = in.readString();
        this.address = in.readString();
        this.allergy = in.readString();
        this.illness = in.readString();
        this.groupPerson = in.readString();
        this.dateBirth = in.readString();
    }

    public String getFullName() {
        return fullName;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getGroupPerson() {
        return groupPerson;
    }

    public void setGroupPerson(String groupPerson) {
        this.groupPerson = groupPerson;
    }

    public static Creator<User> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fullName);
        dest.writeString(userName);
        dest.writeString(passWord);
        dest.writeString(address);
        dest.writeString(allergy);
        dest.writeString(illness);
        dest.writeString(groupPerson);
        dest.writeString(dateBirth);
    }
    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

}
