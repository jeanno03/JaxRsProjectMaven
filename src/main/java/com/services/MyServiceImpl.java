package com.services;

import com.beans.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class MyServiceImpl implements IMyService{

    public static EntityManager entityManager = Persistence
            .createEntityManagerFactory("NewPersistenceUnit")
            .createEntityManager();
    public static EntityTransaction entityTransaction = entityManager.getTransaction();

    @Override
    public User getPersistUser() {
        /* Persist a User entity */
        entityTransaction.begin();
        User user = new User("Alejandro", "alejandro@domain.com");
        entityManager.persist(user);
        entityTransaction.commit();
        return user;
    }

    @Override
    public List<User> getPersistUsers() {
        /* Persist a User entity */
        entityTransaction.begin();
        List<User> users = new ArrayList();
        for(int i =0;i<15;i++){
            User user = new User("Ramses_"+i+"", "Ramses_"+i+"@domain.com");
            entityManager.persist(user);
            users.add(user);
        }
        entityTransaction.commit();
        return users;
    }

    @Override
    public User getUpdateUser(int id, String name) {
        /* Update a User entity */
        entityTransaction.begin();
        User user = entityManager.find(User.class, id);
        user.setName(name);
        user.setEmail(name+"@domain.com");
        entityManager.merge(user);
        entityTransaction.commit();
        return user;
    }

    @Override
    public User getRemoveUser(int id) {
        /* Remove a User entity */
        entityTransaction.begin();
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        entityTransaction.commit();
        return user;
    }
}
