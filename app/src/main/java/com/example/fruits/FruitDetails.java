package com.example.fruits;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FruitDetails extends AppCompatActivity {

    String fruitName = " ";
    String friutPrice ="";
    String fruitWeight="";
    TextView name, price, weight;
    ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_details);

        name = (TextView) findViewById(R.id.fruit_name);
        price = (TextView) findViewById(R.id.fruit_price);
        weight = (TextView) findViewById(R.id.fruit_weight);
        backButton = (ImageView) findViewById(R.id.backBtn);
        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(FruitDetails.this, MainActivity.class);
                startActivity(i);
            }
        });

        Intent intent = getIntent();
        try{
            fruitName= intent.getStringExtra("name");
            friutPrice= intent.getStringExtra("price");
            fruitWeight = intent.getStringExtra("weight");

        }catch(Exception e){

        }
        name.setText("Name: "+fruitName);
        price.setText("Price: "+friutPrice+ " £");
        weight.setText("Weight: "+fruitWeight+ " Kg");


    }
}
