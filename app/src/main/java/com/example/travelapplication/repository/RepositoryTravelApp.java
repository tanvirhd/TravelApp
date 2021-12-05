package com.example.travelapplication.repository;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.travelapplication.model.ModelImage;
import com.example.travelapplication.model.ModelTourPackage;
import com.example.travelapplication.model.ModelUser;
import com.example.travelapplication.model.response.ModelResponseRegistration;
import com.example.travelapplication.network.ApiClient;
import com.example.travelapplication.network.ApiInterface;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

@SuppressLint("CheckResult")
public class RepositoryTravelApp {
    private static final String TAG = "RepositoryTravelApp";
    private ApiInterface apiInterface;

    public RepositoryTravelApp() {
        apiInterface= ApiClient.getApiInterface();
    }


    public LiveData<List<ModelTourPackage>> getAllPublishedEvents(){
        MutableLiveData<List<ModelTourPackage>> result=new MutableLiveData<>();

        apiInterface.getAllPublishedEvents().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<ModelTourPackage>>() {
                    @Override
                    public void accept(List<ModelTourPackage> modelTourPackages) throws Exception {
                        if(modelTourPackages!=null){
                            result.postValue(modelTourPackages);
                        }else {
                            result.postValue(null);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        result.postValue(null);
                        Log.d(TAG, "getAllPublishedEvents: error:"+throwable.getMessage());
                    }
                });
        return  result;
    }


    public LiveData<List<ModelImage>> getAllImages() {
        MutableLiveData<List<ModelImage>> result=new MutableLiveData<>();
        apiInterface.getAllImages().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<ModelImage>>() {
                    @Override
                    public void accept(List<ModelImage> modelImages) throws Exception {
                        if(modelImages!=null){
                            result.postValue(modelImages);
                        }else {
                            result.postValue(null);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        result.postValue(null);
                        Log.d(TAG, "getAllImages: error:"+throwable.getMessage());
                    }
                });
        return result;
    }


    public LiveData<ModelResponseRegistration> regUser(ModelUser user){
        MutableLiveData<ModelResponseRegistration> result=new MutableLiveData<>();
        apiInterface.registerUser(user).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ModelResponseRegistration>() {
                    @Override
                    public void accept(ModelResponseRegistration modelResponseRegistration) throws Exception {
                        if(modelResponseRegistration!=null){
                            result.postValue(modelResponseRegistration);
                        }else {
                            result.postValue(null);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        result.postValue(null);
                        Log.d(TAG, "accept: error:"+throwable.getMessage());
                    }
                });
        return result;
    }
}
