package ifsc.poo;

import edu.princeton.cs.algs4.Draw;

public class Quadrado extends Figura {

    public Quadrado(double x, double y, int tamanho, java.awt.Color cor, boolean preenchida) {
        super(x, y, tamanho, cor, preenchida);
    }

    @Override
    public void desenhar(Draw draw) {
        draw.setPenColor(cor);
        double half = tamanho / 200.0;
        if (preenchida) {
            draw.filledSquare(x, y, half);
        } else {
            draw.square(x, y, half);
        }
    }

    @Override
    public double getPerimetro() {
        double side = 2 * (tamanho / 200.0);
        return 4 * side;
    }

    @Override
    public double getArea() {
        double side = 2 * (tamanho / 200.0);
        return side * side;
    }
}