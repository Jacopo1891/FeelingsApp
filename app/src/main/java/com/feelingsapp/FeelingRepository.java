package com.feelingsapp;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class FeelingRepository {

    private FeelingDao feelingDao;
    private LiveData<List<Feeling>> feelings;

    FeelingRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        feelingDao = db.feelingDao();
        feelings = feelingDao.getAll();
    }

    LiveData<List<Feeling>> getAllFeelings(){
        return feelings;
    }

    public void insert (Feeling feeling){
        new insertAsyncTask(feelingDao).execute(feeling);
    }

    public void delete (Feeling feeling){
        feelingDao.delete(feeling);
    }

    private static class insertAsyncTask extends AsyncTask<Feeling, Void, Void> {

        private FeelingDao syncTaskDao;

        insertAsyncTask(FeelingDao feelingDao){
            syncTaskDao = feelingDao;
        }

        @Override
        protected Void doInBackground(final Feeling... params){
            syncTaskDao.insert(params[0]);
            return null;
        }
    }
}
