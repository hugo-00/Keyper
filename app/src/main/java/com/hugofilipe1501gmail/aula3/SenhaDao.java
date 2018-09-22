package com.hugofilipe1501gmail.aula3;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public abstract class SenhaDao {
    @Query("SELECT * FROM senhas")
    abstract List<Senha> getSenhas();

    @Insert
    abstract void insert(Senha s);
}
