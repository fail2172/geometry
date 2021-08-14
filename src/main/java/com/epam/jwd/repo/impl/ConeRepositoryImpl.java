package com.epam.jwd.repo.impl;

import com.epam.jwd.entity.impl.Cone;
import com.epam.jwd.entity.context.GeometricContext;
import com.epam.jwd.exception.NotFoundGeometricObjectException;
import com.epam.jwd.reader.MessageReader;
import com.epam.jwd.repo.ConeRepository;
import com.epam.jwd.repo.ConeSpecification;

import java.util.ArrayList;
import java.util.List;

public class ConeRepositoryImpl implements ConeRepository {

    private final static MessageReader messageReader = MessageReader.getInstance();
    private final static String EXCEPTIONS_PROPERTIES = "src/main/resources/exceptions.properties";

    private static ConeRepositoryImpl instance;
    private final List<Cone> cones;

    ConeRepositoryImpl(List<Cone> cones) {
        this.cones = cones;
    }

    public static ConeRepositoryImpl getInstance(List<Cone> cones){
        if(instance == null){
            instance = new ConeRepositoryImpl(cones);
        }
        return instance;
    }

    @Override
    public void save(Cone cone) {
        cones.add(cone);
    }

    @Override
    public void remove(int id) throws NotFoundGeometricObjectException {
        Cone removeCone = this.read(id);
        cones.remove(removeCone);
    }

    @Override
    public Cone update(int id, GeometricContext newContext) throws NotFoundGeometricObjectException {
        Cone variableCone = this.read(id);
        variableCone.setHeight(newContext.getHeight());
        variableCone.setRadius(newContext.getRadius());
        variableCone.setCenter(newContext.getX(), newContext.getY(), newContext.getZ());

        return variableCone;
    }

    @Override
    public Cone read(int id) throws NotFoundGeometricObjectException {
        try {
            return cones.get(id);
        } catch (IndexOutOfBoundsException e){
            throw new NotFoundGeometricObjectException(messageReader.
                    getMessage(EXCEPTIONS_PROPERTIES,"NOT_FOUND_GEOMETRIC_OBJECT"), e);
        }
    }

    @Override
    public List<Cone> query(ConeSpecification specification) {

        List<Cone> requiredCones = new ArrayList<>();

        for (Cone cone : cones
        ) {
            if (specification.specified(cone)) {
                requiredCones.add(cone);
            }
        }

        return requiredCones;
    }
}
