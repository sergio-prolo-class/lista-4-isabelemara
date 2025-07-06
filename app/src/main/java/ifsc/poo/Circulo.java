package ifsc.poo;

import edu.princeton.cs.algs4.Draw;

public class Circulo extends FiguraBase {
    public Circulo(double x, double y, double tamanho, java.awt.Color cor, boolean preenchido) {
        super(x, y, tamanho, cor, preenchido);
    }

    @Override
    public void draw(Draw draw) {
        draw.setPenColor(cor);
        if (preenchido) draw.filledCircle(x, y, tamanho);
        else draw.circle(x, y, tamanho);
    }

    @Override
    public double getArea() {
        return Math.PI * tamanho * tamanho;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * tamanho;
    }
}
