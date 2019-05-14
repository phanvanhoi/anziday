package com.example.Leogo.capstone2_anziday.Models;

public class Rating {
    private String user;
    private String foodID;
    private double pointRate;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public double getPointRate() {
        return pointRate;
    }

    public void setPointRate(double pointRate) {
        this.pointRate = pointRate;
    }
}
