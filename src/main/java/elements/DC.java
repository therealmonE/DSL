package elements;

import java.util.List;

public interface DC extends Element {

    List<String> inputs = List.of("E");
    enum Rectangles {

        FRAME(1.0, 1.0, 1.0, 1.0),
        BORDER(0.5,1.0,0.5,1.0),
        PORT(-0.5, -0.7, 1.0, 1.0);

        double neX;
        double neY;
        double swX;
        double swY;

        Rectangles(double neX, double neY, double swX, double swY){
            this.neX=neX;
            this.neY=neY;
            this.swX=swX;
            this.swY=swY;
        }
        public double getNeX(){
            return neX;
        }
        public double getNeY(){
            return neY;
        }
        public double getSwX(){
            return swX;
        }
        public double getSwY(){
            return swY;
        }
    }
}
