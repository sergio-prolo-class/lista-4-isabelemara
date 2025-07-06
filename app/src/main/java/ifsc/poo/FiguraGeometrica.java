package ifsc.poo;

import edu.princeton.cs.algs4.Draw;

public interface FiguraGeometrica {
    void draw(Draw draw);
    void move(double dx, double dy);
    double getArea();
    double getPerimeter();
}
