package com.yikai.bitsandpizzas;

/**
 * Created by Yikai on 2016/5/17.
 */

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class rentAdapter extends RecyclerView.Adapter<rentAdapter.ViewHolder> {

    private String[] address1;
    private String[] address2;
    private int[] bed;
    private int[] bath;
    private int[] sqft;
    private int[] price;
    private int[] save;
    private int[] compare;
    private int[] house_picture;
    private int[] rors;




    private Listener3 listener;

    public static interface Listener3 {
        public void onClick(int position, int pict, CardView cardView);
    }

    public void setListener(Listener3 listener) {
        this.listener = listener;
    }




    private Listener4 listener4;

    public static interface Listener4 {
        public void onClick(int position, int pict, CardView cardView);
    }

    public void setListener(Listener4 listener) {
        this.listener4 = listener;
    }





    public rentAdapter(String[] address1, String[] address2, int[] bed, int[] bath, int[] sqft, int[] price, int[] save, int[] compare, int[] house_picture, int[] rors) {
        this.address1 = address1;
        this.address2 = address2;
        this.bed = bed;
        this.bath = bath;
        this.sqft = sqft;
        this.price = price;
        this.save = save;
        this.compare = compare;
        this.house_picture = house_picture;
        this.rors = rors;


    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;


        public ViewHolder(CardView v) {
            super(v);
            cardView = v;

        }

    }

    @Override
    public rentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //create a new view
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_rent, parent, false);

        return new ViewHolder(cv);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder,  final int position) {
        //从零开始
        final int save_pict;
        final int comp_pict;
        final CardView cardView;

        //set the values inside the given view;
        cardView = holder.cardView;
        final ImageView imgaeView = (ImageView) cardView.findViewById(R.id.image_rent);
        Resources a = cardView.getResources();
        Drawable drawable = a.getDrawable(house_picture[position], a.newTheme());
        imgaeView.setImageDrawable(drawable);

        TextView add1 = (TextView) cardView.findViewById(R.id.address1_rent);
        add1.setText(address1[position]);

        TextView add2 = (TextView) cardView.findViewById(R.id.address2_rent);
        add2.setText(address2[position]);

        TextView sqft1 = (TextView) cardView.findViewById(R.id.bed_bath_sqft_rent);
        sqft1.setText(bed[position]+" beds·"+bath[position]+" baths·"+sqft[position]+" sqft");

        TextView price1 = (TextView) cardView.findViewById(R.id.price_rent);
        price1.setText("$"+price[position]+"/month");


        TextView rent_or_sale = (TextView) cardView.findViewById(R.id.FOR_RENT_OR_SALE);
        ImageView dot_image = (ImageView) cardView.findViewById(R.id.dot_rent);
        Resources d = cardView.getResources();

        if(rors[position] == 0){
            rent_or_sale.setText("FOR RENT");
            Drawable dot2 = d.getDrawable(R.drawable.dot, a.newTheme());
            dot_image.setImageDrawable(dot2);
        } else{
            rent_or_sale.setText("FOR SALE");
            Drawable dot3 = d.getDrawable(R.drawable.dot1, a.newTheme());
            dot_image.setImageDrawable(dot3);
        }










        if(save[position] == 1){
            save_pict = R.drawable.like2;
        }else{
            save_pict = R.drawable.like1;
        }

        if(compare[position] == 1){
            comp_pict = R.drawable.compare2;
        }else{
            comp_pict = R.drawable.compare1;
        }

        ImageView heart = (ImageView) cardView.findViewById(R.id.like_rent);
        Drawable drawable1 = a.getDrawable(save_pict, a.newTheme());
        heart.setImageDrawable(drawable1);

        ImageView comp = (ImageView) cardView.findViewById(R.id.compare_rent);
        Drawable drawable2 = a.getDrawable(comp_pict, a.newTheme());
        comp.setImageDrawable(drawable2);


        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                  listener.onClick(position, save_pict, cardView );
                }
            }
        });

        comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener4 != null) {
                    listener4.onClick(position, save_pict, cardView );
                }
            }
        });



    }

    @Override
    public int getItemCount() {
        return address1.length;
    }


}
