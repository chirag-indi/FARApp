package com.yikai.FARApp;


public class agents {
    private String name;
    private String intro;
    private int imageId;
    private String phoneNumber;


    public static final agents[] agent = {
            new agents("Agneev Saha", "Hello, I am a student of MIT looking for a roommate for a 2BHK house, feel free to contact me. ", R.drawable.agent1, "tel:9741528364"),
            new agents("John Dough", "Hi, I am currently living in Mumbai looking to move to Manipal. Contact me on the information provided below. ", R.drawable.agent2, "tel:6082257519"),
            new agents("Xi Jing Ping", "Hi, I am looking to buy/rent 2BHK/3BHK apartments in Manipal.Contact if interested in selling. ", R.drawable.agent3, "tel:9983121234")
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