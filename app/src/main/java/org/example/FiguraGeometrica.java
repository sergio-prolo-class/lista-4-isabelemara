package org.example;

import edu.princeton.cs.algs4.Draw;

/**
 * Interface que define o contrato para todas as figuras geométricas.
 * Força implementação de métodos para desenhar, mover, calcular perímetro e área.
 */
public interface FiguraGeometrica {
    void draw(Draw d);
    void move(double dx, double dy);
    double getPerimeter();
    double getArea();
}
