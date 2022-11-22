package com.crud.boot.dao;

import com.crud.boot.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepositoryClass implements UserRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(User user) {
        em.persist(user);
    }

    @Override
    public User read(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public void update(User user) {
        em.merge(user);
    }


    @Override
    public void delete(Long id) {
        User removeUser = em.find(User.class, id);
        em.remove(removeUser);
    }

    @Override
    public List<User> allUsers() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }
}
