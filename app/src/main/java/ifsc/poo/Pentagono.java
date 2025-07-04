package ifsc.poo;

import edu.princeton.cs.algs4.Draw;

public class Pentagono extends Figura {

    public Pentagono(double x, double y, int tamanho, java.awt.Color cor, boolean preenchida) {
        super(x, y, tamanho, cor, preenchida);
    }

    @Override
    public void desenhar(Draw draw) {
        draw.setPenColor(cor);
        double r = tamanho / 200.0;
        double[] xs = new double[5];
        double[] ys = new double[5];
        for (int i = 0; i < 5; i++) {
            xs[i] = x + r * Math.cos(2 * Math.PI * i / 5);
            ys[i] = y + r * Math.sin(2 * Math.PI * i / 5);
        }
        if (preenchida) {
            draw.filledPolygon(xs, ys);
        } else {
            draw.polygon(xs, ys);
        }
    }

    @Override
    public double getPerimetro() {
        double side = 2 * (tamanho / 200.0) * Math.sin(Math.PI / 5);
        return 5 * side;
    }

    @Override
    public double getArea() {
        double side = 2 * (tamanho / 200.0) * Math.sin(Math.PI / 5);
        return (5 * side * side) / (4 * Math.tan(Math.PI / 5));
    }
}
