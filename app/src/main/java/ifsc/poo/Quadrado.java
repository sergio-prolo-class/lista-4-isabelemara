package ifsc.poo;

import edu.princeton.cs.algs4.Draw;

public class Quadrado extends FiguraBase {
    public Quadrado(double x, double y, double tamanho, java.awt.Color cor, boolean preenchido) {
        super(x, y, tamanho, cor, preenchido);
    }

    @Override
    public void draw(Draw draw) {
        draw.setPenColor(cor);
        if (preenchido) draw.filledSquare(x, y, tamanho);
        else draw.square(x, y, tamanho);
    }

    @Override
    public double getArea() {
        double lado = 2 * tamanho;
        return lado * lado;
    }

    @Override
    public double getPerimeter() {
        return 8 * tamanho;
    }
}
