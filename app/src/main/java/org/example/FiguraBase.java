package org.example;

import java.awt.Color;

/**
 * Classe abstrata que centraliza atributos comuns entre figuras.
 * Serve como base para herança, evitando duplicação de código.
 */
public abstract class FiguraBase implements FiguraGeometrica {
    protected double x, y;
    protected double tamanho;
    protected Color cor;
    protected boolean preenchido;

    public FiguraBase(double x, double y, double tamanho, Color cor, boolean preenchido) {
        this.x = x;
        this.y = y;
        this.tamanho = tamanho;
        this.cor = cor;
        this.preenchido = preenchido;
    }

    @Override
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }
}
