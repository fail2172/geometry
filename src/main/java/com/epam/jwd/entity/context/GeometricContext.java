package com.epam.jwd.entity.context;

import com.epam.jwd.exception.IncorrectInputException;
import com.epam.jwd.entity.GeometricObjectType;
import com.epam.jwd.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GeometricContext {
    private final static Logger LOG = LogManager.getLogger(GeometricContext.class);
    private static final String EXCEPTIONS_PROPERTIES = "src/main/resources/exceptions.properties";
    private static final String CREATING_GEOMETRIC_CONTEXT = "creating geometric context";
    private final GeometricObjectType type;

    private final double x;
    private final double y;
    private final double z;

    private Double height;
    private Double radius;

    private GeometricContext(GeometricObjectType type, double x, double y, double z) {
        LOG.trace(CREATING_GEOMETRIC_CONTEXT);
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

        GeometricContext that = (GeometricContext) o;

        if (Double.compare(that.x, x) != 0) return false;
        if (Double.compare(that.y, y) != 0) return false;
        if (Double.compare(that.z, z) != 0) return false;
        if (type != that.type) return false;
        if (!height.equals(that.height)) return false;
        return radius.equals(that.radius);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = type.hashCode();
        temp = Double.doubleToLongBits(x);
        result = 17 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 71 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z);
        result = 33 * result + (int) (temp ^ (temp >>> 32));
        result = 11 * result + height.hashCode();
        result = 19 * result + radius.hashCode();
        return result;
    }

    public static Builder of(GeometricObjectType type, double x, double y, double z) {
        return new GeometricContext(type, x, y, z).new Builder();
    }

    public static GeometricContext stringToContext(String stringContext) throws IncorrectInputException {
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

            return GeometricContext.of(GeometricObjectType.CONE, x, y, z).setHeight(height).setRadius(radius).build();
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
            GeometricContext.this.height = height;
            return this;
        }

        public Builder setRadius(Double radius) {
            GeometricContext.this.radius = radius;
            return this;
        }

        public GeometricContext build() {
            return GeometricContext.this;
        }
    }
}
