package ifsc.poo;

import edu.princeton.cs.algs4.Draw;

public class Pentagono extends FiguraBase {
    public Pentagono(double x, double y, double tamanho, java.awt.Color cor, boolean preenchido) {
        super(x, y, tamanho, cor, preenchido);
    }

    @Override
    public void draw(Draw draw) {
        double[] xs = new double[5];
        double[] ys = new double[5];
        for (int i = 0; i < 5; i++) {
            double angle = 2 * Math.PI * i / 5 - Math.PI / 2;
            xs[i] = x + tamanho * Math.cos(angle);
            ys[i] = y + tamanho * Math.sin(angle);
        }

        draw.setPenColor(cor);
        if (preenchido) draw.filledPolygon(xs, ys);
        else draw.polygon(xs, ys);
    }

    @Override
    public double getArea() {
        double lado = 2 * tamanho;
        return (5.0 / 4.0) * lado * lado * (1 / Math.tan(Math.PI / 5));
    }

    @Override
    public double getPerimeter() {
        double lado = 2 * tamanho;
        return 5 * lado;
    }
}

