package com.yikai.FARApp;



import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class AgentsAdapter extends RecyclerView.Adapter<AgentsAdapter.ViewHolder> {

    private String[] name;
    private int[] portrait;
    private String[] introduction;
    private String[] number;

    private Listener2 listener;

    public static interface Listener2 {
        public void onClick(int position);
    }

    public void setListener(Listener2 listener) {
        this.listener = listener;
    }


    public AgentsAdapter(String[] name, int[] portrait, String[] introduction, String[] number) {
        this.name = name;
        this.portrait = portrait;
        this.introduction = introduction;
        this.number = number;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;


        public ViewHolder(CardView v) {
            super(v);
            cardView = v;


        }

    }

    @Override
    public AgentsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //create a new view
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_agents, parent, false);

        return new ViewHolder(cv);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //set the values inside the given view;
        CardView cardView = holder.cardView;
        ImageView imgaeView = (ImageView) cardView.findViewById(R.id.image_agents);
        Resources a = cardView.getResources();
        Drawable drawable = a.getDrawable(portrait[position], a.newTheme());
        imgaeView.setImageDrawable(drawable);

        TextView name1 = (TextView) cardView.findViewById(R.id.name_agents);
        name1.setText(name[position]);

        TextView intro = (TextView) cardView.findViewById(R.id.intro_agents);
        intro.setText(introduction[position]);

        Button button = (Button) cardView.findViewById(R.id.phone_agents);
        button.setText(number[position]);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }

        });


    }

    @Override
    public int getItemCount() {
        return name.length;
    }


}
