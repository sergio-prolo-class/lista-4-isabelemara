package ifsc.poo;

import java.awt.Color;

public abstract class FiguraBase implements FiguraGeometrica {
    protected double x, y, tamanho;
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

