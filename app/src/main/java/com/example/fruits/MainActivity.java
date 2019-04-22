package com.example.fruits;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private List<String> fruits = new ArrayList<>();
    List<Integer> price = new ArrayList<>();
    List<Integer> weight = new ArrayList<>();
    SwipeRefreshLayout swipeRefreshLayout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                // implement Handler to wait for 3 seconds and then update UI means update value of TextView
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // cancle the Visual indication of a refresh
                        swipeRefreshLayout.setRefreshing(false);
                        price.clear();
                        weight.clear();
                        fruits.clear();
                        initilizedRetroFit();
                    }
                }, 2000);
            }
        });
        initilizedRetroFit();

    }

    private void initilizedRetroFit() {
        String Base_Url = "https://raw.githubusercontent.com/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FruitListInterfaceApi fruitListInterfaceApi = retrofit.create(FruitListInterfaceApi.class);
        fruitListInterfaceApi.getFruits().enqueue(new Callback<FruitList>() {

            // @SuppressLint("ResourceAsColor")
            //http://openweathermap.org/img/w/10d.png
            @Override
            public void onResponse(Call<FruitList> call, Response<FruitList> response) {
                if (response.body() !=null){

                  //  System.out.println("1111111111111111111111111111111111111 "+ response.body().getFruit().size());
                    int i;
                    for(i =0; i<response.body().getFruit().size(); i++){
                        fruits.add(response.body().getFruit().get(i).getType());
                        price.add(response.body().getFruit().get(i).getPrice());
                        weight.add(response.body().getFruit().get(i).getWeight());

                    }

                }

                initRecyclerView();


            }

            @Override
            public void onFailure(Call<FruitList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_LONG).show();
            }
        });




    }

    private void initRecyclerView() {
        RecyclerView recyclerView;
       // RecyclerView.Adapter mAdapter;
        //RecyclerView.LayoutManager layoutManager;

        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        MyAdapter adapter = new MyAdapter(MainActivity.this, (ArrayList<String>) fruits, (ArrayList<Integer>) price, (ArrayList<Integer>) weight);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }


}
