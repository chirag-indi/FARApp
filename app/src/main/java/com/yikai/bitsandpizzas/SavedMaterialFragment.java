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


public class SavedMaterialFragment extends Fragment {

    private SQLiteDatabase db;
    private Cursor count_saved_n;
    private Cursor cursor;
    private int number_saved_rent =0;
    private int number_saved_sale = 0;
    private int number_total = 0;

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
        RecyclerView RentRecycler1 = (RecyclerView) inflater.inflate(R.layout.fragment_saved_material, container, false);

        try {


            SQLiteOpenHelper JiarunDatabaseHelper = new JiarunDatabaseHelper(getActivity());
            final SQLiteDatabase db = JiarunDatabaseHelper.getReadableDatabase();

            Cursor count_save_n = db.query("RENT",
                    new String[]{"SAVE", "COUNT(_id) AS count"},
                    null, null, "SAVE", null, null);

            Cursor count_save_m = db.query("SALE",
                    new String[]{"SAVE", "COUNT(_id) AS count"},
                    null, null, "SAVE", null, null);


            count_save_n.moveToFirst();
            if (count_save_n.getInt(0) == 1) {
                number_saved_rent = count_save_n.getInt(1);
            } else if (count_save_n.moveToNext()) {
                number_saved_rent = count_save_n.getInt(1);
            } else {
                number_saved_rent = 0;
            }

            count_save_m.moveToFirst();
            if (count_save_m.getInt(0) == 1) {
                number_saved_sale = count_save_m.getInt(1);
            } else if (count_save_m.moveToNext()) {
                number_saved_sale = count_save_m.getInt(1);
            } else {
                number_saved_sale = 0;
            }

            number_total = number_saved_rent + number_saved_sale;



            if (number_total != 0) {
                address_1 = new String[number_total];
                address_2 = new String[number_total];
                bed_1 = new int[number_total];
                bath_1 = new int[number_total];
                sqft_1 = new int[number_total];
                price_1 = new int[number_total];
                save_1 = new int[number_total];
                comp_1 = new int[number_total];
                pict_1 = new int[number_total];
                rors_1 = new int[number_total];

                Cursor cursor = db.query("RENT",
                        new String[]{"ADD1", "ADD2", "BED", "BATH", "SQFT", "PRICE", "SAVE", "COMP", "PICID", "RORS"},
                        "SAVE = ?",
                        new String[] {Integer.toString(1)},
                        null, null, null);

                Cursor cursor2 = db.query("SALE",
                        new String[]{"ADD1", "ADD2", "BED", "BATH", "SQFT", "PRICE", "SAVE", "COMP", "PICID", "RORS"},
                        "SAVE = ?",
                        new String[] {Integer.toString(1)},
                        null, null, null);


                int count = 0;
                if (cursor.moveToFirst()) {
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
                    } while (cursor.moveToNext());
                }

                if (cursor2.moveToFirst()) {
                    do {
                        address_1[count] = cursor2.getString(0);
                        address_2[count] = cursor2.getString(1);
                        bed_1[count] = cursor2.getInt(2);
                        bath_1[count] = cursor2.getInt(3);
                        sqft_1[count] = cursor2.getInt(4);
                        price_1[count] = cursor2.getInt(5);
                        save_1[count] = cursor2.getInt(6);
                        comp_1[count] = cursor2.getInt(7);
                        pict_1[count] = cursor2.getInt(8);
                        rors_1[count] = cursor2.getInt(9);
                        count++;
                    } while (cursor2.moveToNext());
                }

                rentAdapter adapter2 = new rentAdapter(address_1, address_2, bed_1, bath_1, sqft_1, price_1, save_1, comp_1, pict_1, rors_1);
                RentRecycler1.setAdapter(adapter2);
                LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity());
                RentRecycler1.setLayoutManager(layoutManager2);

                adapter2.setListener(new rentAdapter.Listener3() {
                    public void onClick(int position, int save_pict, CardView cardView) {
                        int newSave;
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
                        if((position+1) <= number_saved_rent) {

                            db.update("RENT",
                                    changeSAVE,
                                    "_id = ?",
                                    new String[]{Integer.toString(position + 1)});
                        }else{
                            db.update("SALE",
                                    changeSAVE,
                                    "_id = ?",
                                    new String[]{Integer.toString(position + 1)});
                        }

                    }

                });

                adapter2.setListener(new rentAdapter.Listener4() {
                    public void onClick(int position, int save_pict, CardView cardView) {
                        int newComp;
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
                        if((position+1) <= number_saved_rent) {

                            db.update("RENT",
                                    changeCOMP,
                                    "_id = ?",
                                    new String[]{Integer.toString(position + 1)});
                        }else{
                            db.update("SALE",
                                    changeCOMP,
                                    "_id = ?",
                                    new String[]{Integer.toString(position + 1)});
                        }

                    }

                });




            } else {
                Toast toast = Toast.makeText(getActivity(), "There are no saved homes.", Toast.LENGTH_SHORT);
                toast.show();
                // customers have no saved houses. So this fragment has nothing to present.
            }

        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(getActivity(), "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }

//        adapter.setListener(new CaptionedImagesAdapter.Listener(){
//            public void onClick(int position){
//                Intent intent = new Intent(getActivity(), SaleDetailActivity.class);
//                intent.putExtra(SaleDetailActivity.EXTRA_SALENO, position);
//                getActivity().startActivity(intent);
//            }
//        });


        return RentRecycler1;

    }

}
