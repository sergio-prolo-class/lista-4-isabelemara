package org.example;

import edu.princeton.cs.algs4.Draw;
import java.awt.Color;

/**
 * Classe concreta que representa um círculo.
 * Herda atributos e movimento de FiguraBase.
 */
public class Circulo extends FiguraBase {

    public Circulo(double x, double y, double tamanho, Color cor, boolean preenchido) {
        super(x, y, tamanho, cor, preenchido);
    }

    @Override
    public void draw(Draw d) {
        d.setPenColor(cor);
        if (preenchido) {
            d.setPenColor(cor);
            d.filledCircle(x, y, tamanho);
        } else {
            d.circle(x, y, tamanho);
        }
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * tamanho;
    }

    @Override
    public double getArea() {
        return Math.PI * tamanho * tamanho;
    }
}
