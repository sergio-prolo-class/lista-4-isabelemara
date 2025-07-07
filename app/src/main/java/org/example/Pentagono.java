package org.example;

import edu.princeton.cs.algs4.Draw;
import java.awt.Color;

/**
 * Classe concreta que representa um pentágono regular.
 * Calcula 5 vértices ao redor do centro.
 */
public class Pentagono extends FiguraBase {

    public Pentagono(double x, double y, double tamanho, Color cor, boolean preenchido) {
        super(x, y, tamanho, cor, preenchido);
    }

    @Override
    public void draw(Draw d) {
        double[] xs = new double[5];
        double[] ys = new double[5];
        for (int i = 0; i < 5; i++) {
            xs[i] = x + tamanho * Math.cos(2 * Math.PI * i / 5);
            ys[i] = y + tamanho * Math.sin(2 * Math.PI * i / 5);
        }

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
        return 5 * 2 * tamanho * Math.sin(Math.PI / 5);
    }

    @Override
    public double getArea() {
        return (5 * tamanho * tamanho * Math.tan(Math.PI / 5)) / 4;
    }
}
