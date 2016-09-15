package com.yikai.bitsandpizzas;

/**
 * Created by Yikai on 2016/5/16.
 */
public class rent {
    private String address1;
    private String address2;
    private int bed;
    private int bath;
    private int sqft;
    private int price;
    private boolean save;
    private boolean compare;
    private int house_picture;


    public static final rent[] rents = {
            new rent("921 Meadow View Dr", "Richardson, TX 75080", 2, 3, 1245, 5463, false, false, R.drawable.rent1),
            new rent("jwe", "intro234", 4, 3, 1245, 545663, true, false, R.drawable.rent2),
            new rent("jsdds", "intro 567", 3, 3, 1245, 54763, false, true, R.drawable.rent3)
    };

    public rent(String address1, String address2, int bed, int bath, int sqft, int price, boolean save, boolean compare, int house_picture) {
        this.address1 = address1;
        this.address2 = address2;
        this.bed = bed;
        this.bath = bath;
        this.sqft = sqft;
        this.price = price;
        this.save = save;
        this.compare = compare;
        this.house_picture = house_picture;


    }

    public String getAddress1() {
        return address1;
    }
    public String getAddress2() {
        return address2;
    }
    public int getbed() {
        return bed;
    }

    public int getbath() {
        return bath;
    }

    public int getsqft() {
        return sqft;
    }

    public int getprice() {
        return price;
    }

    public boolean getsave() {
        return save;
    }

    public boolean getcompare() {
        return compare;
    }

    public int gethouse_picture() {
        return house_picture;
    }

}