package ifsc.poo;

import edu.princeton.cs.algs4.Draw;

public class Losango extends Figura {

    public Losango(double x, double y, int tamanho, java.awt.Color cor, boolean preenchida) {
        super(x, y, tamanho, cor, preenchida);
    }

    @Override
    public void desenhar(Draw draw) {
        draw.setPenColor(cor);
        double h = tamanho / 200.0;
        double[] xs = {x, x + h, x, x - h};
        double[] ys = {y + h, y, y - h, y};
        if (preenchida) {
            draw.filledPolygon(xs, ys);
        } else {
            draw.polygon(xs, ys);
        }
    }

    @Override
    public double getPerimetro() {
        double side = Math.sqrt(2) * (tamanho / 200.0);
        return 4 * side;
    }

    @Override
    public double getArea() {
        double d = 2 * (tamanho / 200.0);
        return (d * d) / 2;
    }
}