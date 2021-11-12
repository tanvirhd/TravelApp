package com.example.travelapplication.network;

import com.example.travelapplication.model.response.ModelResponseLogin;
import com.example.travelapplication.model.ModelUser;
import com.example.travelapplication.model.ModelValidation;
import com.example.travelapplication.model.response.ModelResponseRegistration;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("checkUser.php")
    Observable<ModelValidation> checkUser(@Body ModelUser user);

    @POST ("login.php")
    Observable<ModelResponseLogin> loginUser(@Body ModelUser user);

    @POST("registerNewUser.php")
    Observable<ModelResponseRegistration> registerUser(@Body ModelUser user);
}
