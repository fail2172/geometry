import custom_math.ConeGeometry;
import custom_math.impl.ConeGeometryImpl;
import geometric_objects.Cone;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Run {
    public final static Logger LOG = LogManager.getLogger(Run.class);
    public static void main(String[] args) {
        LOG.info("Program start");

        ConeGeometry geometry = new ConeGeometryImpl();
        Cone cone = new Cone(0, 0,0,5,5);
        LOG.info("Объём конуса " + geometry.volume(cone));
        LOG.info("Площадь поверхности " + geometry.surfaceArea(cone));
    }
}
