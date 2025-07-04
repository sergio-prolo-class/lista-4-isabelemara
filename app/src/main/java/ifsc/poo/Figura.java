package ifsc.poo;

import edu.princeton.cs.algs4.Draw;
import java.awt.Color;

public abstract class Figura {
    protected double x, y;
    protected int tamanho;
    protected Color cor;
    protected boolean preenchida;

    public Figura(double x, double y, int tamanho, Color cor, boolean preenchida) {
        this.x = x;
        this.y = y;
        this.tamanho = tamanho;
        this.cor = cor;
        this.preenchida = preenchida;
    }

    public abstract void desenhar(Draw draw);
    public abstract double getPerimetro();
    public abstract double getArea();

    public void mover(double dx, double dy) {
        x += dx;
        y += dy;
    }
}
