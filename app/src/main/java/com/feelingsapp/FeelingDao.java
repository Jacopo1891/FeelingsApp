package com.feelingsapp;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.Date;
import java.util.List;

@Dao
public interface FeelingDao {

    @Query("SELECT * FROM feeling")
    LiveData<List<Feeling>> getAll();

    @Query("SELECT * FROM feeling WHERE date == (:dateToFind)")
    LiveData<List<Feeling>> getFeelingByDate(Long dateToFind);

    @Query("SELECT * FROM feeling WHERE name == (:nameToFind)")
    LiveData<List<Feeling>> getFeelingByName(String nameToFind);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Feeling feeling);

    @Delete
    void delete(Feeling feeling);

    @Query("DELETE FROM feeling")
    void deleteAll();


}
