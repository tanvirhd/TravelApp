package com.example.travelapplication.network;

import com.example.travelapplication.model.ModelUser;
import com.example.travelapplication.model.ModelValidation;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("travellapp/checkUser.php")
    Observable<ModelValidation> checkUser(@Body ModelUser user);
}
