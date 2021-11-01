package com.example.travelapplication.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.travelapplication.model.ModelUser;
import com.example.travelapplication.model.ModelValidation;
import com.example.travelapplication.network.ApiClient;
import com.example.travelapplication.network.ApiInterface;

import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class RepositoryCheckUser {
    private static final String TAG = "RepositoryCheckUser";
    private ApiInterface apiInterface;

    public RepositoryCheckUser() {
        apiInterface= ApiClient.getApiInterface();
    }

    public LiveData<ModelValidation> checkUserValidation(ModelUser user){
        MutableLiveData<ModelValidation> result=new MutableLiveData<>();

        apiInterface.checkUser(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ModelValidation>() {
                    @Override
                    public void accept(ModelValidation modelValidation) throws Exception {
                        result.postValue(modelValidation);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "checkUserValidation:error "+throwable.getMessage());
                        result.postValue(null);
                    }
                });
        return  result;
    }
}
