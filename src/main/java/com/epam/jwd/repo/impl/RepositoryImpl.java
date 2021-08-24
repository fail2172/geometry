package com.epam.jwd.repo.impl;

import com.epam.jwd.entity.GeometricObject;
import com.epam.jwd.entity.impl.GeometricContext;
import com.epam.jwd.exception.GeometricObjectNotFoundException;
import com.epam.jwd.reader.MessageReader;
import com.epam.jwd.reader.impl.MessageReaderImpl;
import com.epam.jwd.repo.Repository;
import com.epam.jwd.repo.Specification;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RepositoryImpl<T extends GeometricObject> implements Repository<T> {

    private final static MessageReader messageReader = MessageReaderImpl.getInstance();
    private final static String EXCEPTIONS_PROPERTIES = "src/main/resources/exceptions.properties";
    private final List<T> geometricObjects;

    public RepositoryImpl(List<T> geometricObjects) {
        this.geometricObjects = geometricObjects;
    }

    @Override
    public void save(T object) {
        geometricObjects.add(object);
    }

    @Override
    public void remove(int id) throws GeometricObjectNotFoundException {
        T removeCone = this.read(id);
        geometricObjects.remove(removeCone);
    }

    @Override
    public T update(int id, GeometricContext newContext) throws GeometricObjectNotFoundException {
        T variableCone = this.read(id);
        variableCone.setContext(newContext);

        return variableCone;
    }

    @Override
    public T read(int id) throws GeometricObjectNotFoundException {
        try {
            return geometricObjects.get(id);
        } catch (IndexOutOfBoundsException e){
            throw new GeometricObjectNotFoundException(messageReader.
                    getMessage(EXCEPTIONS_PROPERTIES,"NOT_FOUND_GEOMETRIC_OBJECT"), e);
        }
    }

    @Override
    public int size() {
        return geometricObjects.size();
    }

    @Override
    public void sort(Comparator<T> comparator) {
        geometricObjects.sort(comparator);
    }

    @Override
    public void sort() {
        Collections.sort(geometricObjects);
    }

    @Override
    public List<T> query(Specification<T> specification) {
        List<T> requiredObjects = new ArrayList<>();

        for (T object : geometricObjects
        ) {
            if (specification.specified(object)) {
                requiredObjects.add(object);
            }
        }

        return requiredObjects;
    }
}
