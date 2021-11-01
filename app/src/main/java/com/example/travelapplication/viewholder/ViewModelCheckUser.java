package com.example.travelapplication.viewholder;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.travelapplication.model.ModelUser;
import com.example.travelapplication.model.ModelValidation;
import com.example.travelapplication.repository.RepositoryCheckUser;

public class ViewModelCheckUser extends AndroidViewModel {
    private RepositoryCheckUser repositoryCheckUser;

    public ViewModelCheckUser(@NonNull Application application) {
        super(application);
        repositoryCheckUser=new RepositoryCheckUser();
    }

    public LiveData<ModelValidation> checkUserValidation(ModelUser user){
        return repositoryCheckUser.checkUserValidation(user);
    }
}
