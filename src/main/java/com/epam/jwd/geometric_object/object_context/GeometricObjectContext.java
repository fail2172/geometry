package com.epam.jwd.geometric_object.object_context;

import com.epam.jwd.exception.IncorrectInputException;
import com.epam.jwd.geometric_object.GeometricObjectType;
import com.epam.jwd.validation.Validator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class GeometricObjectContext {
    public static final String EXCEPTIONS_PROPERTIES = "src/main/resources/exceptions.properties";
    private final GeometricObjectType type;

    private final double x;
    private final double y;
    private final double z;

    private Double height;
    private Double radius;

    private GeometricObjectContext(GeometricObjectType type, double x, double y, double z) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public GeometricObjectType getType() {
        return type;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Double getHeight() {
        return height;
    }

    public Double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "GeometryObjectContext{" +
                "type=" + type +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", height=" + height +
                ", radius=" + radius +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeometricObjectContext context = (GeometricObjectContext) o;
        return x == context.x && y == context.y && z == context.z
                && Objects.equals(height, context.height)
                && Objects.equals(radius, context.radius);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, height, radius);
    }

    public static Builder of(GeometricObjectType type, double x, double y, double z) {
        return new GeometricObjectContext(type, x, y, z).new Builder();
    }

    public static GeometricObjectContext stringToContext(String stringContext) throws IncorrectInputException {
        Validator validator = Validator.instance();

        if (validator.checkContext(stringContext)) {
            final String SEMICOLON_SEPARATOR = ";";
            final String SPACE_SEPARATOR = ",";

            String[] coneParameters = stringContext.split(SEMICOLON_SEPARATOR);

            double height = Double.parseDouble(coneParameters[0]);
            double radius = Double.parseDouble(coneParameters[1]);

            String[] centerBaseCoordinates = coneParameters[2].split(SPACE_SEPARATOR);

            double x = Double.parseDouble(centerBaseCoordinates[0]);
            double y = Double.parseDouble(centerBaseCoordinates[1]);
            double z = Double.parseDouble(centerBaseCoordinates[2]);

            return GeometricObjectContext.of(GeometricObjectType.CONE, x, y, z).setHeight(height).setRadius(radius).build();
        } else {
            Properties properties = new Properties();
            try {
                FileInputStream stream = new FileInputStream(EXCEPTIONS_PROPERTIES);
                properties.load(stream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            throw new IncorrectInputException(properties.getProperty("INCORRECT_INPUT"));
        }
    }

    public class Builder {

        private Builder() {
        }

        public Builder setHeight(Double height) {
            GeometricObjectContext.this.height = height;
            return this;
        }

        public Builder setRadius(Double radius) {
            GeometricObjectContext.this.radius = radius;
            return this;
        }

        public GeometricObjectContext build() {
            return GeometricObjectContext.this;
        }
    }
}
