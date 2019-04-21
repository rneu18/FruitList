package com.example.fruits;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FruitList {

    @SerializedName("fruit")
    @Expose
    private List<Fruit> fruit = null;

    public List<Fruit> getFruit() {
        return fruit;
    }

    public void setFruit(List<Fruit> fruit) {
        this.fruit = fruit;
    }

}
