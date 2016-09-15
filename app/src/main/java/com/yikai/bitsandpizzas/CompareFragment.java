package com.yikai.bitsandpizzas;


import android.app.Fragment;
import android.content.ContentValues;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class CompareFragment extends Fragment {

    private int number_comp_rent = 0;
    private int number_comp_sale = 0;
    private int number_total = 0;
    private  boolean rent_has_COMP = false;
    private boolean sale_has_COMP = false;

    private SQLiteDatabase db;
    private Cursor count_saved_n;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_compare, container, false);

        try {


            SQLiteOpenHelper JiarunDatabaseHelper = new JiarunDatabaseHelper(getActivity());
            final SQLiteDatabase db = JiarunDatabaseHelper.getReadableDatabase();

            Cursor count_comp_n = db.query("RENT",
                    new String[]{"COMP", "COUNT(_id) AS count"},
                    null, null, "COMP", null, null);

            Cursor count_comp_m = db.query("SALE",
                    new String[]{"COMP", "COUNT(_id) AS count"},
                    null, null, "COMP", null, null);

            count_comp_n.moveToFirst();
            if (count_comp_n.getInt(0) == 1) {
                number_comp_rent = count_comp_n.getInt(1);
            } else if (count_comp_n.moveToNext()) {
                number_comp_rent = count_comp_n.getInt(1);
            } else {
                number_comp_rent = 0;
            }
            if(number_comp_rent != 0){
                rent_has_COMP = true;
            }else{
                rent_has_COMP = false;
            }


            count_comp_m.moveToFirst();
            if (count_comp_m.getInt(0) == 1) {
                number_comp_sale = count_comp_m.getInt(1);
            } else if (count_comp_m.moveToNext()) {
                number_comp_sale = count_comp_m.getInt(1);
            } else {
                number_comp_sale = 0;
            }
            if(number_comp_sale != 0){
                sale_has_COMP = true;
            }else{
                sale_has_COMP = false;
            }

            number_total = number_comp_rent + number_comp_sale;

            if (number_total < 2) {
                Toast toast1 = Toast.makeText(getActivity(), "Number of homes to be compared is "+ number_total+". Two homes are needed.", Toast.LENGTH_SHORT);
                toast1.show();
            } else if (number_total > 2) {
                Toast toast1 = Toast.makeText(getActivity(), "Number of homes to be compared is "+ number_total+". Can not compare more than two homes.", Toast.LENGTH_SHORT);
                toast1.show();
            } else {

                Cursor cursor = db.query("RENT",
                        new String[]{"ADD1", "ADD2", "BED", "BATH", "SQFT", "PRICE", "SAVE", "COMP", "PICID", "RORS", "HOMETYPE", "STROIES", "YEAR", "LOT", "ARCHITECTURAL", "CONSTRUCTION"},
                        "COMP = ?",
                        new String[]{Integer.toString(1)},
                        null, null, null);

                Cursor cursor2 = db.query("SALE",
                        new String[]{"ADD1", "ADD2", "BED", "BATH", "SQFT", "PRICE", "SAVE", "COMP", "PICID", "RORS", "HOMETYPE", "STROIES", "YEAR", "LOT", "ARCHITECTURAL", "CONSTRUCTION"},
                        "COMP = ?",
                        new String[]{Integer.toString(1)},
                        null, null, null);

                if (cursor.moveToFirst()) {
                       setInformation1(cursor,rootview);
                    if(cursor.moveToNext()){
                        setInformation2(cursor,rootview);
                    }else{
                        cursor2.moveToNext();
                        setInformation2(cursor2,rootview);
                    }
                }else{
                    cursor2.moveToFirst();
                    setInformation1(cursor2,rootview);
                    cursor2.moveToNext();
                    setInformation2(cursor2,rootview);
                }

            }

            ImageView delete = (ImageView) rootview.findViewById(R.id.delete_icon);
            delete.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                    ContentValues changeCOMP = new ContentValues();
                    changeCOMP.put("COMP",0);

                    if(rent_has_COMP) {
                        db.update("RENT",
                                changeCOMP,
                                null,
                                null);
                        rent_has_COMP=false;
                    }
                    if(sale_has_COMP) {
                        db.update("SALE",
                                changeCOMP,
                                null,
                                null);
                        sale_has_COMP=false;
                    }
                    Toast toast2 = Toast.makeText(getActivity(), "All homes to be compared have been deleted", Toast.LENGTH_SHORT);
                    toast2.show();

                }
            } );

        } catch (SQLiteException e) {

        }


        return rootview;

    }

    private void setInformation1(Cursor cursor, View rootview) {
    ImageView com1_pic = (ImageView) rootview.findViewById(R.id.com1_pic);
    Resources a = getResources();
    Drawable drawable1 = a.getDrawable(cursor.getInt(8), a.newTheme());
    com1_pic.setImageDrawable(drawable1);

    TextView com1_street = (TextView) rootview.findViewById(R.id.com1_street);
    com1_street.setText(cursor.getString(0));

    TextView com1_city = (TextView) rootview.findViewById(R.id.com1_city);
    com1_city.setText(cursor.getString(1));

    TextView com1_beds = (TextView) rootview.findViewById(R.id.com1_beds);
    com1_beds.setText(Integer.toString(cursor.getInt(2)));

    TextView com1_bath = (TextView) rootview.findViewById(R.id.com1_bath);
    com1_bath.setText(Integer.toString(cursor.getInt(3)));

    TextView com1_sqft = (TextView) rootview.findViewById(R.id.com1_sqft);
    com1_sqft.setText(Integer.toString(cursor.getInt(4)));

    TextView com1_price = (TextView) rootview.findViewById(R.id.com1_price);
    com1_price.setText(Integer.toString(cursor.getInt(5)));

    TextView com1_transaction_type = (TextView) rootview.findViewById(R.id.com1_transaction_type);
    if(cursor.getInt(9)==0)
    {
        com1_transaction_type.setText("Rent");
    }else
    {
        com1_transaction_type.setText("Sale");
    }
        TextView com1_hometype = (TextView) rootview.findViewById(R.id.com1_home_type);
        com1_hometype.setText(cursor.getString(10));

        TextView com1_stories = (TextView) rootview.findViewById(R.id.com1_stories);
        com1_stories.setText(Integer.toString(cursor.getInt(11)));

        TextView com1_year = (TextView) rootview.findViewById(R.id.com1_year_built);
        com1_year.setText(Integer.toString(cursor.getInt(12)));

        TextView com1_lot = (TextView) rootview.findViewById(R.id.com1_lot_size);
        com1_lot.setText(Integer.toString(cursor.getInt(13)));

        TextView com1_architectural = (TextView) rootview.findViewById(R.id.com1_architectural_style);
        com1_architectural.setText(cursor.getString(14));

        TextView com1_construction = (TextView) rootview.findViewById(R.id.com1_construction_material);
        com1_construction.setText(cursor.getString(15));

        TextView com1_price_sqft = (TextView) rootview.findViewById(R.id.com1_price_sqft);
        if(cursor.getInt(9)==0) {
            com1_price_sqft.setText("NA");
        }       else {
            com1_price_sqft.setText(Integer.toString(cursor.getInt(5) / cursor.getInt(4)));
        }





}

    private void setInformation2(Cursor cursor,View rootview) {
        ImageView com1_pic = (ImageView) rootview.findViewById(R.id.com2_pic);
        Resources a = getResources();
        Drawable drawable1 = a.getDrawable(cursor.getInt(8), a.newTheme());
        com1_pic.setImageDrawable(drawable1);

        TextView com1_street = (TextView) rootview.findViewById(R.id.com2_street);
        com1_street.setText(cursor.getString(0));

        TextView com1_city = (TextView) rootview.findViewById(R.id.com2_city);
        com1_city.setText(cursor.getString(1));

        TextView com1_beds = (TextView) rootview.findViewById(R.id.com2_beds);
        com1_beds.setText(Integer.toString(cursor.getInt(2)));

        TextView com1_bath = (TextView) rootview.findViewById(R.id.com2_bath);
        com1_bath.setText(Integer.toString(cursor.getInt(3)));

        TextView com1_sqft = (TextView) rootview.findViewById(R.id.com2_sqft);
        com1_sqft.setText(Integer.toString(cursor.getInt(4)));

        TextView com1_price = (TextView) rootview.findViewById(R.id.com2_price);
        com1_price.setText(Integer.toString(cursor.getInt(5)));

        TextView com1_transaction_type = (TextView) rootview.findViewById(R.id.com2_transaction_type);
        if(cursor.getInt(9)==0)
        {
            com1_transaction_type.setText("Rent");
        }else
        {
            com1_transaction_type.setText("Sale");
        }

        TextView com1_hometype = (TextView) rootview.findViewById(R.id.com2_home_type);
        com1_hometype.setText(cursor.getString(10));

        TextView com1_stories = (TextView) rootview.findViewById(R.id.com2_stories);
        com1_stories.setText(Integer.toString(cursor.getInt(11)));

        TextView com1_year = (TextView) rootview.findViewById(R.id.com2_year_built);
        com1_year.setText(Integer.toString(cursor.getInt(12)));

        TextView com1_lot = (TextView) rootview.findViewById(R.id.com2_lot_size);
        com1_lot.setText(Integer.toString(cursor.getInt(13)));

        TextView com1_architectural = (TextView) rootview.findViewById(R.id.com2_architectural_style);
        com1_architectural.setText(cursor.getString(14));

        TextView com1_construction = (TextView) rootview.findViewById(R.id.com2_construction_material);
        com1_construction.setText(cursor.getString(15));

        TextView com1_price_sqft = (TextView) rootview.findViewById(R.id.com2_price_sqft);
        if(cursor.getInt(9)==0) {
            com1_price_sqft.setText("NA");
        }       else {
            com1_price_sqft.setText(Integer.toString(cursor.getInt(5) / cursor.getInt(4)));
        }




    }


}
