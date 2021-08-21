package com.epam.jwd.repo;

public interface Specification<T> {
    boolean specified(T object);
}
