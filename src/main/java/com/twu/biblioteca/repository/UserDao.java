package com.twu.biblioteca.repository;

import com.twu.biblioteca.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao implements Dao<User> {
    @Override
    public List<User> getAll() {
        return new ArrayList<>();
    }

    @Override
    public void save(User user) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void update(User user) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void delete(User user) {
        throw new UnsupportedOperationException("Method not implemented");
    }
}
