package com.feelingsapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class FeelingViewModel extends AndroidViewModel {

    private FeelingRepository repository;
    private LiveData<List<Feeling>> feelings;

    public FeelingViewModel(Application application){
        super(application);
        repository = new FeelingRepository(application);
        feelings = repository.getAllFeelings();
    }

    public LiveData<List<Feeling>> getAllFeelings() {
        return feelings;
    }

    public void insert(Feeling feeling) {
        repository.insert(feeling);
    }

    public void delete(Feeling feeling){
        repository.delete(feeling);
    }

}
