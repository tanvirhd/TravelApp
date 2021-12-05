package com.example.travelapplication.viewholder;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.travelapplication.model.ModelImage;
import com.example.travelapplication.model.ModelTourPackage;
import com.example.travelapplication.model.ModelUser;
import com.example.travelapplication.model.ModelValidation;
import com.example.travelapplication.model.response.ModelResponseLogin;
import com.example.travelapplication.model.response.ModelResponseRegistration;
import com.example.travelapplication.repository.RepositoryCheckUser;
import com.example.travelapplication.repository.RepositoryTravelApp;

import java.util.List;

public class ViewModelTravelApp extends AndroidViewModel {
    private RepositoryCheckUser repositoryCheckUser;
    private RepositoryTravelApp repositoryTravelApp;

    public ViewModelTravelApp(@NonNull Application application) {
        super(application);
        repositoryCheckUser=new RepositoryCheckUser();
        repositoryTravelApp=new RepositoryTravelApp();
    }

    public LiveData<ModelValidation> checkUserValidation(ModelUser user){
        return repositoryCheckUser.checkUserValidation(user);
    }

    public LiveData<ModelResponseLogin> loginUser(ModelUser newUser){
        return repositoryCheckUser.loginUser(newUser);
    }

    public LiveData<List<ModelTourPackage>> getAllPublishedEvents(){
        return repositoryTravelApp.getAllPublishedEvents();
    }

    public LiveData<List<ModelImage>> getAllImages() {
        return repositoryTravelApp.getAllImages();
    }

    public LiveData<ModelResponseRegistration> regUser(ModelUser user){
        return repositoryTravelApp.regUser(user);
    }
}
