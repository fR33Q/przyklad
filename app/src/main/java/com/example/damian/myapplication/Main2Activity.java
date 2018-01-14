package com.example.damian.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity {
@BindView(R.id.recyclerView)
    RecyclerView recView;
String coffeeText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ButterKnife.bind(this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recView.setLayoutManager(layoutManager);

        ArrayList<Coffee> kawy = new ArrayList<>();

       kawy.add(new Coffee("10.00 zł","Latte" ));
        kawy.add(new Coffee("12.00 zł","Cappucino" ));
        kawy.add(new Coffee("11.00 zł","Basic" ));
        kawy.add(new Coffee("19.00 zł","Z mlekiem" ));

        OnClickPlace listener = (view, position) -> {

            coffeeText = kawy.get(position).getNazwa_kawy();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("CoffeeName", coffeeText);
            intent.putExtras(bundle);
            startActivity(intent);
        };

        CoffeeAdapter coffeeAdapter = new CoffeeAdapter(kawy , listener);
        recView.setAdapter(coffeeAdapter);

    }
}
