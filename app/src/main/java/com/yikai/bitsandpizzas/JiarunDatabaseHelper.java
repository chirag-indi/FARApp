package com.yikai.bitsandpizzas;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Yikai on 2016/5/24.
 */
public class JiarunDatabaseHelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "Jiarun";
    private static final int DB_VERSION = 2;              // the version of the database

    JiarunDatabaseHelper(Context context){
    super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db){

       updateMyDatabase(db, 0, DB_VERSION);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        updateMyDatabase(db, oldVersion, newVersion);

    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion){
        if(oldVersion < 1){
            db.execSQL( "CREATE TABLE RENT ( _id INTEGER PRIMARY KEY AUTOINCREMENT, ADD1 TEXT, ADD2 TEXT, BED INTEGER, BATH INTEGER, SQFT INTEGER, PRICE INTEGER, SAVE INTEGER, COMP INTEGER, PICID INTEGER, RORS INTEGER, HOMETYPE TEXT, STROIES INTEGER, YEAR INTEGER, LOT INTEGER, ARCHITECTURAL TEXT, CONSTRUCTION TEXT );"  );
            insertRent(db, "921 Meadow View Dr", "Richardson, TX 75080", 3, 2, 1672, 2200, 0, 0, R.drawable.rent1, 0, "Apartment", 2, 1998, 4500, "Modern", "Brick");    // RORS: 0:rent 1:sale
            insertRent(db, "800 West Renner Rd", "Richardson, TX 75080", 3, 2, 1432, 1500, 1, 0, R.drawable.rent2, 0, "Apartment", 2, 1998, 4500, "Modern", "Brick");
            insertRent(db, "5001 Sheboygan Ave, APT 114", "Madison, WI 57305", 2, 2, 1231, 1300, 0, 1, R.drawable.rent3, 0, "Apartment", 2, 1998, 4500, "Modern", "Brick");
            insertRent(db, "5001 Sheboygan Ave, APT 114", "Madison, WI 57305", 2, 2, 1231, 1300, 0, 1, R.drawable.rent4, 0, "Apartment", 2, 1998, 4500, "Modern", "Brick");
            insertRent(db, "5001 Sheboygan Ave, APT 114", "Madison, WI 57305", 2, 2, 1231, 1300, 0, 1, R.drawable.rent5, 0, "Apartment", 2, 1998, 4500, "Modern", "Brick");
            insertRent(db, "5001 Sheboygan Ave, APT 114", "Madison, WI 57305", 2, 2, 1231, 1300, 0, 1, R.drawable.rent6, 0, "Apartment", 2, 1998, 4500, "Modern", "Brick");
            insertRent(db, "5001 Sheboygan Ave, APT 114", "Madison, WI 57305", 2, 2, 1231, 1300, 0, 1, R.drawable.rent7, 0, "Apartment", 2, 1998, 4500, "Modern", "Brick");
            insertRent(db, "5001 Sheboygan Ave, APT 114", "Madison, WI 57305", 2, 2, 1231, 1300, 0, 1, R.drawable.rent8, 0, "Apartment", 2, 1998, 4500, "Modern", "Brick");
            insertRent(db, "5001 Sheboygan Ave, APT 114", "Madison, WI 57305", 2, 2, 1231, 1300, 0, 1, R.drawable.rent9, 0, "Apartment", 2, 1998, 4500, "Modern", "Brick");
            insertRent(db, "5001 Sheboygan Ave, APT 114", "Madison, WI 57305", 2, 2, 1231, 1300, 0, 1, R.drawable.rent10, 0, "Apartment", 2, 1998, 4500, "Modern", "Brick");

            db.execSQL( "CREATE TABLE SALE ( _id INTEGER PRIMARY KEY AUTOINCREMENT, ADD1 TEXT, ADD2 TEXT, BED INTEGER, BATH INTEGER, SQFT INTEGER, PRICE INTEGER, SAVE INTEGER, COMP INTEGER, PICID INTEGER, RORS INTEGER, HOMETYPE TEXT, STROIES INTEGER, YEAR INTEGER, LOT INTEGER, ARCHITECTURAL TEXT, CONSTRUCTION TEXT );"  );
            insertSale(db, "921 Meadow View Dr", "Richardson, TX 75080", 3, 2, 1672, 2200, 0, 0, R.drawable.sale1, 1, "Apartment", 2, 1998, 4500, "Modern", "Brick");
            insertSale(db, "800 West Renner Rd", "Richardson, TX 75080", 3, 2, 1432, 1500, 1, 0, R.drawable.sale2, 1, "Apartment", 2, 1998, 4500, "Modern", "Brick");
            insertSale(db, "5001 Sheboygan Ave, APT 114", "Madison, WI 57305", 2, 2, 1231, 1300, 0, 1, R.drawable.sale3, 1, "Apartment", 2, 1998, 4500, "Modern", "Brick");
            insertSale(db, "5012 Sheboygan Ave, APT 114", "Madison, WI 57305", 2, 2, 1231, 1300, 0, 1, R.drawable.sale4, 1, "Apartment", 2, 1998, 4500, "Modern", "Brick");
            insertSale(db, "5012 Sheboygan Ave, APT 114", "Madison, WI 57305", 2, 2, 1231, 1300, 0, 1, R.drawable.sale5, 1, "Apartment", 2, 1998, 4500, "Modern", "Brick");
            insertSale(db, "5012 Sheboygan Ave, APT 114", "Madison, WI 57305", 2, 2, 1231, 1300, 0, 1, R.drawable.sale6, 1, "Apartment", 2, 1998, 4500, "Modern", "Brick");
            insertSale(db, "5012 Sheboygan Ave, APT 114", "Madison, WI 57305", 2, 2, 1231, 1300, 0, 1, R.drawable.sale7, 1, "Apartment", 2, 1998, 4500, "Modern", "Brick");
            insertSale(db, "5012 Sheboygan Ave, APT 114", "Madison, WI 57305", 2, 2, 1231, 1300, 0, 1, R.drawable.sale8, 1, "Apartment", 2, 1998, 4500, "Modern", "Brick");
            insertSale(db, "5012 Sheboygan Ave, APT 114", "Madison, WI 57305", 2, 2, 1231, 1300, 0, 1, R.drawable.sale9, 1, "Apartment", 2, 1998, 4500, "Modern", "Brick");
            insertSale(db, "5012 Sheboygan Ave, APT 114", "Madison, WI 57305", 2, 2, 1231, 1300, 0, 1, R.drawable.sale10, 1, "Apartment", 2, 1998, 4500, "Modern", "Brick");
        }
        if(oldVersion < 2 ){
//            db.execSQL("ALTER TABLE DRINK ADD COLUMN FAVORITE NUMERIC;");
        }

    }

    private static void insertRent(SQLiteDatabase db, String add1, String add2, int bed, int bath, int sqft, int price, int save, int comp, int picid, int rors, String hometype, int stories, int year, int lot, String architectural_material, String construction){

        ContentValues rentValues = new ContentValues();
        rentValues.put("ADD1", add1);
        rentValues.put("ADD2", add2);
        rentValues.put("BED", bed);
        rentValues.put("BATH", bath);
        rentValues.put("SQFT", sqft);
        rentValues.put("PRICE", price);
        rentValues.put("SAVE", save);
        rentValues.put("COMP", comp);
        rentValues.put("PICID", picid);
        rentValues.put("RORS", rors);
        rentValues.put("HOMETYPE", hometype);
        rentValues.put("STROIES", stories);
        rentValues.put("YEAR", year);
        rentValues.put("LOT", lot);
        rentValues.put("ARCHITECTURAL", architectural_material);
        rentValues.put("CONSTRUCTION", construction);




        db.insert("RENT", null,rentValues);

    }
    private static void insertSale(SQLiteDatabase db, String add1, String add2, int bed, int bath, int sqft, int price, int save, int comp, int picid, int rors, String hometype, int stories, int year, int lot, String architectural_material, String construction){

        ContentValues SaleValues = new ContentValues();
        SaleValues.put("ADD1", add1);
        SaleValues.put("ADD2", add2);
        SaleValues.put("BED", bed);
        SaleValues.put("BATH", bath);
        SaleValues.put("SQFT", sqft);
        SaleValues.put("PRICE", price);
        SaleValues.put("SAVE", save);
        SaleValues.put("COMP", comp);
        SaleValues.put("PICID", picid);
        SaleValues.put("RORS", rors);
        SaleValues.put("HOMETYPE", hometype);
        SaleValues.put("STROIES", stories);
        SaleValues.put("YEAR", year);
        SaleValues.put("LOT", lot);
        SaleValues.put("ARCHITECTURAL", architectural_material);
        SaleValues.put("CONSTRUCTION", construction);

        db.insert("SALE", null,SaleValues);

    }






}
