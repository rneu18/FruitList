package com.example.fruits;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>  {
    private Context context;
    int myPosition;
    private ArrayList<String> items = new ArrayList<>();
    private ArrayList<Integer> prices = new ArrayList<>();
    private ArrayList<Integer> weights = new ArrayList<>();




    public MyAdapter(Context mContext, ArrayList<String> item, ArrayList<Integer> price, ArrayList<Integer> weight) {
        context = mContext;
        items = item;
        prices = price;
        weights = weight;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fruit_list_rv, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder( MyViewHolder currentViewHolder, final int i) {
        currentViewHolder.fruit.setText(items.get(i));
        //currentViewHolder.fruit.setText("Test");
        System.out.println("333333333333333333333333333 "+items.get(i));
        currentViewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myPosition = i;
                Intent intent = new Intent(context, FruitDetails.class);
                intent.putExtra("name", items.get(i));
                intent.putExtra("price", String.valueOf(prices.get(i)));
                intent.putExtra("weight", String.valueOf(weights.get(i)));
                context.startActivity(intent);


            }
        });


    }

    private void myOnclickEvent(int i) {


    }

    @Override
    public int getItemCount() {

        System.out.println("333333333333333333333333333 "+items.size());
        return items.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{


        TextView fruit;
       CardView parentLayout;



        public MyViewHolder(View itemView) {
            super(itemView);
            parentLayout = (CardView) itemView.findViewById(R.id.card_view_fruit);
            fruit = (TextView) itemView.findViewById(R.id.fruit);
        }
    }
}
