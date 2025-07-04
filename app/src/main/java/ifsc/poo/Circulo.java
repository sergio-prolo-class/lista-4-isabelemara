package ifsc.poo;

import edu.princeton.cs.algs4.Draw;

public class Circulo extends Figura {

    public Circulo(double x, double y, int tamanho, java.awt.Color cor, boolean preenchida) {
        super(x, y, tamanho, cor, preenchida);
    }

    @Override
    public void desenhar(Draw draw) {
        draw.setPenColor(cor);
        double r = tamanho / 200.0;
        if (preenchida) {
            draw.filledCircle(x, y, r);
        } else {
            draw.circle(x, y, r);
        }
    }

    @Override
    public double getPerimetro() {
        double r = tamanho / 200.0;
        return 2 * Math.PI * r;
    }

    @Override
    public double getArea() {
        double r = tamanho / 200.0;
        return Math.PI * r * r;
    }
}