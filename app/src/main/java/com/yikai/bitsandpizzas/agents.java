package com.yikai.bitsandpizzas;

/**
 * Created by Yikai on 2016/5/16.
 */
public class agents {
    private String name;
    private String intro;
    private int imageId;
    private String phoneNumber;


    public static final agents[] agent = {
            new agents("Fenghua Gao", "Hello, I am the chief realtor. I have more than 10 years of experience. I sold 38 homes in last 12 months. Please feel free to contact me. ", R.drawable.agent1, "tel:6086479233"),
            new agents("Da Gao", "Hello, I have more than 5 years of real estate experience. I sold 26 homes in last 12 months. Please feel free to contact me. ", R.drawable.agent2, "tel:6082257519"),
            new agents("Dongying Li", "Hello, I have more than 4 years of real estate experience. I sold 25 homes in last 12 months. Please feel free to contact me. ", R.drawable.agent3, "tel:6087582251")
    };

    private agents(String name, String intro, int imageId, String phoneNumber) {

        this.name = name;
        this.intro = intro;
        this.imageId = imageId;
        this.phoneNumber = phoneNumber;

    }

    public String getIntro() {
        return intro;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getImageId() {
        return imageId;
    }

}