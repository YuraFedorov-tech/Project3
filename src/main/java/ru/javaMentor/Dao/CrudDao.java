package ru.javaMentor.Dao;
/*
 *
 *@Data 02.02.2020
 *@autor Fedorov Yuri
 *@project CRUD_HIBERNATE
 *
 */

import java.util.List;

public interface CrudDao<T> {
        T  find(Long id);
        void save(T model);
        void update(T model);
        void delete(Long id);
        List<T> findAll();
    }

