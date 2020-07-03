package com.hh1995.health;

public class Item {
    int img;
    String date;

    String weigh;
    String fat;
    String muscle;

    String tvWeigh;
    String tvFat;
    String tvMuscle;

    public Item() {
    }

    public Item(int img, String date, String weigh, String fat, String muscle, String tvWeigh, String tvFat, String tvMuscle) {
        this.img = img;
        this.date = date;
        this.weigh = weigh;
        this.fat = fat;
        this.muscle = muscle;
        this.tvWeigh = tvWeigh;
        this.tvFat = tvFat;
        this.tvMuscle = tvMuscle;
    }
}
