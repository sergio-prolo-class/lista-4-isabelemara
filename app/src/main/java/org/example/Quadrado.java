package org.example;

import edu.princeton.cs.algs4.Draw;
import java.awt.Color;

/**
 * Classe concreta que representa um quadrado.
 * Usa FiguraBase para atributos comuns.
 */
public class Quadrado extends FiguraBase {

    public Quadrado(double x, double y, double tamanho, Color cor, boolean preenchido) {
        super(x, y, tamanho, cor, preenchido);
    }

    @Override
    public void draw(Draw d) {
        d.setPenColor(cor);
        if (preenchido) {
            d.setPenColor(cor);
            d.filledSquare(x, y, tamanho);
        } else {
            d.square(x, y, tamanho);
        }
    }

    @Override
    public double getPerimeter() {
        return 4 * (2 * tamanho);
    }

    @Override
    public double getArea() {
        return (2 * tamanho) * (2 * tamanho);
    }
}
