package com.yikai.bitsandpizzas;

/**
 * Created by Yikai on 2016/5/13.
 */
public class Sale {

    private String name;
    private int imageResourceId;

    public static final Sale[] Sales = {
            new Sale("2 bds 1 ba 900sqft Apartment ask for %130,000", R.drawable.sale1),
            new Sale("2 bds 1 ba 900sqft Apartment ask for %130,000", R.drawable.sale2),
            new Sale("2 bds 1 ba 900sqft Apartment ask for %130,000", R.drawable.sale3),
            new Sale("2 bds 1 ba 900sqft Apartment ask for %130,000", R.drawable.sale4),
            new Sale("2 bds 1 ba 900sqft Apartment ask for %130,000", R.drawable.sale5)
    };

    private Sale(String name, int imageResourceId){
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName(){
        return name;
    }

    public int getImageResourceId(){
        return imageResourceId;
    }

}
