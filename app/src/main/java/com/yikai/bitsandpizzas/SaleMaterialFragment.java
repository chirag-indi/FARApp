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
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


public class SaleMaterialFragment extends Fragment {

    private SQLiteDatabase db;
    private Cursor count_sale_n;
    private Cursor cursor;
    private SQLiteOpenHelper JiarunDatabaseHelper;

    String[] address_1;
    String[] address_2;
    int[] bed_1;
    int[] bath_1;
    int[] sqft_1;
    int[] price_1;
    int[] save_1;
    int[] comp_1;
    int[] pict_1;
    int[] rors_1;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RecyclerView SaleRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_sale_material, container, false);

        try {
            int number_sale;

            JiarunDatabaseHelper = new JiarunDatabaseHelper(getActivity());
            db = JiarunDatabaseHelper.getReadableDatabase();

            Cursor count_sale_n = db.query("SALE",
                    new String[]{"COUNT(_id) AS count_rent"},
                    null, null, null, null, null);
            count_sale_n.moveToFirst();
            number_sale = count_sale_n.getInt(0);

            address_1 = new String[number_sale];
            address_2 = new String[number_sale];
            bed_1 = new int[number_sale];
            bath_1 = new int[number_sale];
            sqft_1 = new int[number_sale];
            price_1 = new int[number_sale];
            save_1 = new int[number_sale];
            comp_1 = new int[number_sale];
            pict_1 = new int[number_sale];
            rors_1 = new int[number_sale];

            Cursor cursor = db.query("SALE",
                    new String[]{"ADD1", "ADD2", "BED", "BATH", "SQFT", "PRICE", "SAVE", "COMP", "PICID", "RORS"},
                    null,
                    null,
                    null, null, null);

            int count = 0;
            if(cursor.moveToFirst()){

                do {

                    address_1[count] = cursor.getString(0);
                    address_2[count] = cursor.getString(1);
                    bed_1[count] = cursor.getInt(2);
                    bath_1[count] = cursor.getInt(3);
                    sqft_1[count] = cursor.getInt(4);
                    price_1[count] = cursor.getInt(5);
                    save_1[count] = cursor.getInt(6);
                    comp_1[count] = cursor.getInt(7);
                    pict_1[count] = cursor.getInt(8);
                    rors_1[count] = cursor.getInt(9);
                    count++;
                }while(cursor.moveToNext());
            }

            rentAdapter adapter3 = new rentAdapter(address_1,address_2, bed_1, bath_1, sqft_1, price_1, save_1, comp_1, pict_1, rors_1);
            SaleRecycler.setAdapter(adapter3);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            SaleRecycler.setLayoutManager(layoutManager);

            adapter3.setListener(new rentAdapter.Listener3() {
                int newSave;
                public void onClick(int position, int save_pict, CardView cardView) {
                    if(save_1[position] ==1) {
                        save_1[position] = 0;
                        newSave = R.drawable.like1;
                    }else{
                        save_1[position]=1;
                        newSave = R.drawable.like2;
                    }
                    Resources a = cardView.getResources();
                    ImageView heart = (ImageView) cardView.findViewById(R.id.like_rent);
                    Drawable drawable1 = a.getDrawable(newSave, a.newTheme());
                    heart.setImageDrawable(drawable1);

                    ContentValues changeSAVE = new ContentValues();
                    changeSAVE.put("SAVE",save_1[position]);
                    db.update("SALE",
                            changeSAVE,
                            "_id = ?",
                            new String[] {Integer.toString(position+1)});
                }

            });

            adapter3.setListener(new rentAdapter.Listener4() {
                int newComp;
                public void onClick(int position, int save_pict, CardView cardView) {
                    if(comp_1[position] ==1) {
                        comp_1[position] = 0;
                        newComp = R.drawable.compare1;
                    }else{
                        comp_1[position]=1;
                        newComp = R.drawable.compare2;
                    }
                    Resources a = cardView.getResources();
                    ImageView comp = (ImageView) cardView.findViewById(R.id.compare_rent);
                    Drawable drawable1 = a.getDrawable(newComp, a.newTheme());
                    comp.setImageDrawable(drawable1);

                    ContentValues changeCOMP = new ContentValues();
                    changeCOMP.put("COMP",comp_1[position]);
                    db.update("SALE",
                            changeCOMP,
                            "_id = ?",
                            new String[] {Integer.toString(position+1)});
                }

            });

        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(getActivity(), "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }




        return SaleRecycler;

    }



}
