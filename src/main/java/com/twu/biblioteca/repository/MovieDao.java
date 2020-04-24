package com.twu.biblioteca.repository;

import java.util.ArrayList;
import java.util.List;

public class MovieDao implements Dao {
    @Override
    public List getAll() {
        return new ArrayList<>();
    }

    @Override
    public void save(Object o) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void update(Object o) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void delete(Object o) {
        throw new UnsupportedOperationException("Method not implemented");
    }
}
