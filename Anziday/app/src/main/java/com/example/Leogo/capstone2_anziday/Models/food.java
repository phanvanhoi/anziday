package com.example.Leogo.capstone2_anziday.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class food{
    private String foodID;
    private String decription;
    private ArrayList<String> formatly;
    private ArrayList<String> illness;
    private String image;
    private String link;
    private ArrayList<String> material;
    private String nameFood;
    private double rating;
    private ArrayList<String> region;
    private ArrayList<String> session;

    public food(){

    }
    public food(String nameFood, String image, double rating){
        this.nameFood = nameFood;
        this.image = image;
        this.rating = rating;
    }

    public food(String foodID,String decription, ArrayList<String> formatly, ArrayList<String> illness, String image, String link, ArrayList<String> material,
                String nameFood, double rating, ArrayList<String> region, ArrayList<String> session) {
        this.foodID = foodID;
        this.decription = decription;
        this.formatly = formatly;
        this.illness = illness;
        this.image = image;
        this.link = link;
        this.material = material;
        this.nameFood = nameFood;
        this.rating = rating;
        this.region = region;
        this.session = session;
    }


    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public ArrayList<String> getFormatly() {
        return formatly;
    }

    public void setFormatly(ArrayList<String> formatly) {
        this.formatly = formatly;
    }

    public ArrayList<String> getIllness() {
        return illness;
    }

    public void setIllness(ArrayList<String> illness) {
        this.illness = illness;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ArrayList<String> getMaterial() {
        return material;
    }

    public void setMaterial(ArrayList<String> material) {
        this.material = material;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public ArrayList<String> getRegion() {
        return region;
    }

    public void setRegion(ArrayList<String> region) {
        this.region = region;
    }

    public ArrayList<String> getSession() {
        return session;
    }

    public void setSession(ArrayList<String> session) {
        this.session = session;
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    /*food(Parcel in) {
        this.decription = in.readString();
        this.formatly = new ArrayList<>();
        this.illness = new ArrayList<>();
        this.image = in.readString();
        this.link = in.readString();
        this.material = new ArrayList<>();
        this.nameFood = in.readString();
        this.rating = in.readDouble();
        this.region = new ArrayList<>();
        this.session = new ArrayList<>();

        *//*this.name = in.readString();
        this.yearsOfExperience = in.readInt();
        this.skillSet = new ArrayList<Skill>();
        in.readTypedList(skillSet, Skill.CREATOR);
        this.favoriteFloat = in.readFloat();*//*
    }
    *//*this.decription = decription;
            this.formatly = formatly;
            this.illness = illness;
            this.image = image;
            this.link = link;
            this.material = material;
            this.nameFood = nameFood;
            this.rating = rating;
            this.region = region;
            this.session = session*//*
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(decription);
        dest.writeTypedList((List)formatly);
        dest.writeTypedList((List)illness);
        dest.writeString(image);
        dest.writeString(link);
        dest.writeTypedList((List)material);
        dest.writeString(nameFood);
        dest.writeDouble(rating);
        dest.writeTypedList((List) region);
        dest.writeTypedList((List)session);

        *//*dest.writeInt(yearsOfExperience);
        dest.writeTypedList(skillSet);
        dest.writeFloat(favoriteFloat);*//*
    }

    public int describeContents() {
        return 0;
    }


    static final Creator<food> CREATOR
            = new Creator<food>() {

        public food createFromParcel(Parcel in) {
            return new food(in);
        }

        public food[] newArray(int size) {
            return new food[size];
        }
    };

    static class Skill implements Parcelable {
        String name;
        boolean programmingRelated;

        Skill(Parcel in) {
            this.name = in.readString();
            this.programmingRelated = (in.readInt() == 1);
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(name);
            dest.writeInt(programmingRelated ? 1 : 0);
        }

        static final Creator<Skill> CREATOR
                = new Creator<Skill>() {

            public Skill createFromParcel(Parcel in) {
                return new Skill(in);
            }

            public Skill[] newArray(int size) {
                return new Skill[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }
    }
*/

}
