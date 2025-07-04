package ifsc.poo;

import java.awt.Color;

public class Configuracao {
    private String formaAtual = "Circulo";
    private Color corAtual = Color.BLACK;
    private boolean preenchida = false;
    private int tamanho = 50;
    private double movimentoDelta = 0.05;

    public String getFormaAtual() {
        return formaAtual;
    }

    public void setFormaAtual(String formaAtual) {
        this.formaAtual = formaAtual;
        System.out.println("Forma selecionada: " + formaAtual);
    }

    public Color getCorAtual() {
        return corAtual;
    }

    public void setCorAtual(Color corAtual) {
        this.corAtual = corAtual;
        System.out.println("Cor selecionada: " + corAtual);
    }

    public boolean isPreenchida() {
        return preenchida;
    }

    public void alternarPreenchimento() {
        preenchida = !preenchida;
        System.out.println("Modo preenchido: " + preenchida);
    }

    public int getTamanho() {
        return tamanho;
    }

    public void aumentarTamanho() {
        if (tamanho < 200) {
            tamanho += 10;
            System.out.println("Novo tamanho: " + tamanho);
        }
    }

    public void diminuirTamanho() {
        if (tamanho > 10) {
            tamanho -= 10;
            System.out.println("Novo tamanho: " + tamanho);
        }
    }

    public double getMovimentoDelta() {
        return movimentoDelta;
    }
}
