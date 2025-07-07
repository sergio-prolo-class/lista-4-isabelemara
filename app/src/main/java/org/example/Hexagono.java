package org.example;

import edu.princeton.cs.algs4.Draw;
import java.awt.Color;

/**
 * Classe concreta que representa um hexágono regular.
 * Calcula os 6 vértices com trigonometria para desenho.
 */
public class Hexagono extends FiguraBase {

    public Hexagono(double x, double y, double tamanho, Color cor, boolean preenchido) {
        super(x, y, tamanho, cor, preenchido);
    }

    @Override
    public void draw(Draw d) {
        double[] xs = new double[6];
        double[] ys = new double[6];
        for (int i = 0; i < 6; i++) {
            xs[i] = x + tamanho * Math.cos(2 * Math.PI * i / 6);
            ys[i] = y + tamanho * Math.sin(2 * Math.PI * i / 6);
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
        // lado do hexágono = tamanho * 2 * sin(pi/6)
        double lado = 2 * tamanho * Math.sin(Math.PI / 6);
        return 6 * lado;
    }

    @Override
    public double getArea() {
        // área do hexágono regular = (3 * sqrt(3) * lado^2) / 2
        double lado = 2 * tamanho * Math.sin(Math.PI / 6);
        return (3 * Math.sqrt(3) * lado * lado) / 2;
    }
}
