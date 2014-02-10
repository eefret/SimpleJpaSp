package com.example.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Eefret on 1/31/14.
 */
public class JPAUTIL {
    private static EntityManagerFactory entityManagerFactory;

    static{
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("SpJpaTaskPU");
        }catch (Throwable ex){
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManagerFactory getEntityManagerFactory(){
        return entityManagerFactory;
    }
    public static void shutdown(){
        getEntityManagerFactory().close();
    }
}
