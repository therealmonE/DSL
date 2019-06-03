package cecylb.dsl.modelv2.tmp;

import cecylb.dsl.modelv2.tmp.TexObject;
import org.immutables.value.Value;

@Value.Modifiable
public interface UJKTr extends TexObject {

    String[] INPUTS = new String[] {"S", "J", "C", "K", "R"};

    String[] OUTPUTS = new String[] {"Q", "Qn"};

    enum Rectangles {
        FRAME(1.0, 1.0, 1.0, 1.0),
        BORDER(0.5, 1.0, 0.5, 1.0),
        PORT(-0.5, -0.25, 1.0, 0.25);

        private final double neX;
        private final double neY;
        private final double swX;
        private final double swY;

        Rectangles(
                final double neX,
                final double neY,
                final double swX,
                final double swY) {
            this.neX = neX;
            this.neY = neY;
            this.swX = swX;
            this.swY = swY;
        }

        public double getNeX() {
            return neX;
        }

        public double getNeY() {
            return neY;
        }

        public double getSwX() {
            return swX;
        }

        public double getSwY() {
            return swY;
        }
    }
}
