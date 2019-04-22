package com.example.fruits;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FruitDetails extends AppCompatActivity {

    ArrayList<String> fruitName = new ArrayList<>();
    ArrayList<Integer> fruitWeight = new ArrayList<>();
    ArrayList<Integer> friutPrice = new ArrayList<>();
    TextView name, price, weight, serialN;
    ImageView backButton;
    int currentPosition;
    int zero = 0;
    int totalNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_details);

        name = (TextView) findViewById(R.id.fruit_name);
        price = (TextView) findViewById(R.id.fruit_price);
        weight = (TextView) findViewById(R.id.fruit_weight);
        serialN = (TextView) findViewById(R.id.fruit_SN);
        backButton = (ImageView) findViewById(R.id.backBtn);


        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(FruitDetails.this, MainActivity.class);
                startActivity(i);
            }
        });



        Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();
        try{
            currentPosition =  intent.getIntExtra("myPosition", 0);
            fruitName = (ArrayList<String>) bundle.getStringArrayList("MyArray_name");
            fruitWeight = (ArrayList<Integer>) bundle.getIntegerArrayList("MyArray_weight");
            friutPrice = (ArrayList<Integer>) bundle.getIntegerArrayList("MyArray_price");
            totalNumber = fruitName.size()-1;


        }catch(Exception e){

        }

        setText();





    }

    private void setText() {
        serialN.setText(String.valueOf(currentPosition+1));
        name.setText(fruitName.get(currentPosition).toUpperCase());
        price.setText(friutPrice.get(currentPosition)+ " £");
        weight.setText(fruitWeight.get(currentPosition)+ " Kg");

    }



    public void nextFruit(View view) {

        if(currentPosition == (totalNumber)){

            currentPosition = 0;

        }else{
            currentPosition = currentPosition +1;

        }
        setText();

    }
    public void previousFruit(View view) {

        if(currentPosition == zero){

            currentPosition = totalNumber;

        }else{

            currentPosition = currentPosition -1;


        }
        setText();

    }
}
