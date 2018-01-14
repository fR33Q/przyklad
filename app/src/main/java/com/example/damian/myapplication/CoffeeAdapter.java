package com.example.damian.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Damian on 2018-01-07.
 */

public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.ViewHolder> {

    private ArrayList<Coffee> kawy = new ArrayList<>();
    private OnClickPlace listener;

    CoffeeAdapter(ArrayList<Coffee> kawy , OnClickPlace listener)
    {
        this.kawy = kawy;
        this.listener = listener;


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, null);

        return new ViewHolder(itemLayoutView, listener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setCost(kawy.get(position).getCena());
        holder.setName(kawy.get(position).getNazwa_kawy());



    }

    @Override
    public int getItemCount() {
        return kawy.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.coffee_name)
        TextView name;

        @BindView(R.id.coffee_cost)
        TextView cost;

        private OnClickPlace listener;

        @BindView(R.id.check)
        ImageView Wybrane;


        @OnClick(R.id.button_wybierz)
        void onNameClick() {
            if (Wybrane.getVisibility() == View.INVISIBLE) {
                Wybrane.setVisibility(View.VISIBLE);
            } else {
                Wybrane.setVisibility(View.INVISIBLE);
            }
        }

        public ViewHolder(View itemView, OnClickPlace listener) {

            super(itemView);
            ButterKnife.bind(this,itemView);
            this.listener = listener;
            itemView.setOnClickListener(this::OnClick);

        }

        private void setName(String nazwa){name.setText(nazwa);}
        private void setCost(String cena) {cost.setText(cena);}



        public void OnClick(View view)
        {
            listener.onClickPlace(view, getAdapterPosition());


        }
    }


}
