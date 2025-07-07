package org.example;

import edu.princeton.cs.algs4.Draw;
import java.awt.Color;

/**
 * Classe concreta que representa um losango.
 * Calcula vértices a partir do centro.
 */
public class Losango extends FiguraBase {

    public Losango(double x, double y, double tamanho, Color cor, boolean preenchido) {
        super(x, y, tamanho, cor, preenchido);
    }

    @Override
    public void draw(Draw d) {
        double[] xs = {x, x + tamanho, x, x - tamanho};
        double[] ys = {y + tamanho, y, y - tamanho, y};

        d.setPenColor(cor);
        if (preenchido) {
            d.setPenColor(cor);
            d.filledPolygon(xs, ys);
        } else {
            d.polygon(xs, ys);
        }
    }

    @Override
    public double getPerimeter() {
        return 4 * Math.sqrt(2) * tamanho;
    }

    @Override
    public double getArea() {
        return 2 * tamanho * 2 * tamanho / 2;
    }
}
