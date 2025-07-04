package ifsc.poo;

import edu.princeton.cs.algs4.Draw;

public class Hexagono extends Figura {

    public Hexagono(double x, double y, int tamanho, java.awt.Color cor, boolean preenchida) {
        super(x, y, tamanho, cor, preenchida);
    }

    @Override
    public void desenhar(Draw draw) {
        draw.setPenColor(cor);
        double r = tamanho / 200.0;
        double[] xs = new double[6];
        double[] ys = new double[6];
        for (int i = 0; i < 6; i++) {
            xs[i] = x + r * Math.cos(2 * Math.PI * i / 6);
            ys[i] = y + r * Math.sin(2 * Math.PI * i / 6);
        }
        if (preenchida) {
            draw.filledPolygon(xs, ys);
        } else {
            draw.polygon(xs, ys);
        }
    }

    @Override
    public double getPerimetro() {
        double side = (tamanho / 200.0);
        return 6 * side;
    }

    @Override
    public double getArea() {
        double side = (tamanho / 200.0);
        return ((3 * Math.sqrt(3)) / 2) * side * side;
    }
}
