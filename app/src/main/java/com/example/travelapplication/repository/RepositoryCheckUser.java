package com.example.travelapplication.repository;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.travelapplication.model.ModelUser;
import com.example.travelapplication.model.ModelValidation;
import com.example.travelapplication.model.response.ModelResponseLogin;
import com.example.travelapplication.network.ApiClient;
import com.example.travelapplication.network.ApiInterface;

import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;

@SuppressLint("CheckResult")
public class RepositoryCheckUser {
    private static final String TAG = "RepositoryCheckUser";
    private ApiInterface apiInterface;

    public RepositoryCheckUser() {
        apiInterface= ApiClient.getApiInterface();
    }

    public LiveData<ModelValidation> checkUserValidation(ModelUser user){
        MutableLiveData<ModelValidation> response=new MutableLiveData<>();

        apiInterface.checkUser(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ModelValidation>() {
                    @Override
                    public void accept(ModelValidation modelValidation) throws Exception {
                        response.postValue(modelValidation);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "checkUserValidation:error "+throwable.getMessage());
                        response.postValue(null);
                    }
                });
        return  response;
    }

    public LiveData<ModelResponseLogin> loginUser(ModelUser newUser){
        MutableLiveData<ModelResponseLogin> response=new MutableLiveData<>();

        apiInterface.loginUser(newUser).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ModelResponseLogin>() {
                    @Override
                    public void accept(ModelResponseLogin modelResponseLogin) throws Exception {
                        response.postValue(modelResponseLogin);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "loginUser:error "+throwable.getMessage());
                        response.postValue(null);
                    }
                });

        return response;
    }
}
