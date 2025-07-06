package ifsc.poo;

import edu.princeton.cs.algs4.Draw;

public class Losango extends FiguraBase {
    public Losango(double x, double y, double tamanho, java.awt.Color cor, boolean preenchido) {
        super(x, y, tamanho, cor, preenchido);
    }

    @Override
    public void draw(Draw draw) {
        double[] xs = {x, x + tamanho, x, x - tamanho};
        double[] ys = {y + tamanho, y, y - tamanho, y};

        draw.setPenColor(cor);
        if (preenchido) draw.filledPolygon(xs, ys);
        else draw.polygon(xs, ys);
    }

    @Override
    public double getArea() {
        return 2 * tamanho * tamanho;
    }

    @Override
    public double getPerimeter() {
        return 4 * Math.sqrt(2 * tamanho * tamanho);
    }
}
