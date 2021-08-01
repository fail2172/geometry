import geometric_object.*;
import geometric_object.object_context.GeometricObjectContext;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Run {
    public final static Logger LOG = LogManager.getLogger(Run.class);
    public static void main(String[] args) {
        GeometricObjectContext context =
                GeometricObjectContext.of(GeometricObjectType.CONE, 0,0,0).setRadius(15.0).build();

        GeometricFactory factory = GeometricFactory.instance();
        GeometricObject cone = factory.createObject(context);

        LOG.info(cone);
    }
}
