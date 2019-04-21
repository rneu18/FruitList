package com.example.fruits;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface FruitListInterfaceApi {

    @GET("fmtvp/recruit-test-data/master/data.json")
    Call<FruitList> getFruits();

}
