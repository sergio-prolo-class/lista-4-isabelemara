package org.example;

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.DrawListener;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por gerenciar toda a lógica da aplicação.
 * Implementa DrawListener para capturar eventos de mouse e teclado.
 */
public class Controlador implements DrawListener {

    private final Draw draw;
    private final List<FiguraGeometrica> figuras;
    private boolean precisaRedesenhar = true;

    // Estado atual de configuração
    private int formaAtual = 1;
    private Color corAtual = Color.RED;
    private boolean preenchido = false;
    private double tamanhoAtual = 0.05;

    /**
     * Construtor: cria janela Draw e registra este controlador como listener.
     */
    public Controlador() {
        draw = new Draw();
        draw.addListener(this);
        figuras = new ArrayList<>();
    }

    /**
     * Loop principal: redesenha apenas se houve alteração.
     */
    public void executar() {
        while (true) {
            if (precisaRedesenhar) {
                draw.clear();

                // Polimorfismo: chamando draw() de cada figura
                for (FiguraGeometrica f : new ArrayList<>(figuras)) {
                    f.draw(draw);
                }

                draw.show();
                precisaRedesenhar = false;
            }
            draw.pause(20);
        }
    }

    /**
     * Evento de clique do mouse: cria e adiciona uma figura.
     */
    @Override
    public void mousePressed(double x, double y) {
        figuras.add(criarFigura(x, y));
        precisaRedesenhar = true;
    }

    /**
     * Cria uma nova figura com os parâmetros atuais.
     */
    private FiguraGeometrica criarFigura(double x, double y) {
        switch (formaAtual) {
            case 1: return new Circulo(x, y, tamanhoAtual, corAtual, preenchido);
            case 2: return new Quadrado(x, y, tamanhoAtual, corAtual, preenchido);
            case 3: return new Losango(x, y, tamanhoAtual, corAtual, preenchido);
            case 4: return new Hexagono(x, y, tamanhoAtual, corAtual, preenchido);
            default: return new Circulo(x, y, tamanhoAtual, corAtual, preenchido);
        }
    }

    /**
     * Evento de teclado: trata todas as teclas de controle.
     */
    @Override
    public void keyPressed(int key) {
        // Seleção de formas
        if (key == 112) { formaAtual = 1; System.out.println("Figura: Círculo"); }
        else if (key == 113) { formaAtual = 2; System.out.println("Figura: Quadrado"); }
        else if (key == 114) { formaAtual = 3; System.out.println("Figura: Losango"); }
        else if (key == 115) { formaAtual = 4; System.out.println("Figura: Hexágono"); }

        // Seleção de cores
        else if (key == 116) { corAtual = Color.RED; System.out.println("Cor: Vermelho"); }
        else if (key == 117) { corAtual = Color.BLUE; System.out.println("Cor: Azul"); }
        else if (key == 118) { corAtual = Color.GREEN; System.out.println("Cor: Verde"); }
        else if (key == 119) { corAtual = Color.YELLOW; System.out.println("Cor: Amarelo"); }

        // Alternar modo de preenchimento
        else if (key == 'F' || key == 'f') {
            preenchido = !preenchido;
            System.out.println("Modo: " + (preenchido ? "Preenchido" : "Vazado"));
        }

        // Ajustar tamanho (exibido em dezenas)
        else if (key == 'Q' || key == 'q') {
            tamanhoAtual = Math.max(0.01, tamanhoAtual - 0.01);
            System.out.printf("Tamanho: %.0f%n", tamanhoAtual * 100);
        }
        else if (key == 'W' || key == 'w') {
            tamanhoAtual = Math.min(0.2, tamanhoAtual + 0.01);
            System.out.printf("Tamanho: %.0f%n", tamanhoAtual * 100);
        }

        // Movimento das figuras (↑ = sobe, ↓ = desce)
        else if (key == 37) { moverFiguras(+0.01, 0); }   // ←
        else if (key == 38) { moverFiguras(0, -0.01); }   // ↑
        else if (key == 39) { moverFiguras(-0.01, 0); }   // →
        else if (key == 40) { moverFiguras(0, +0.01); }   // ↓

        // Limpar tudo
        else if (key == 'C' || key == 'c') {
            figuras.clear();
            System.out.println("Tela limpa");
        }

        // Estatísticas
        else if (key == 'P' || key == 'p') {
            processarFiguras();
        }

        precisaRedesenhar = true;
    }

    /**
     * Move todas as figuras desenhadas.
     */
    private void moverFiguras(double dx, double dy) {
        // Uso de polimorfismo
        for (FiguraGeometrica f : figuras) {
            f.move(dx, dy);
        }
    }

    /**
     * Calcula e imprime informações das figuras no terminal.
     */
    private void processarFiguras() {
        int total = figuras.size();
        double somaPerimetros = 0;
        double somaAreas = 0;
        for (FiguraGeometrica f : figuras) {
            somaPerimetros += f.getPerimeter();
            somaAreas += f.getArea();
        }
        double areaMedia = total > 0 ? somaAreas / total : 0;
        System.out.printf("Figuras: %d, Soma perímetros: %.2f, Área média: %.2f%n",
                total, somaPerimetros, areaMedia);
    }

    // Outros métodos da interface que não usamos
    @Override public void mouseDragged(double x, double y) {}
    @Override public void mouseReleased(double x, double y) {}
    @Override public void keyReleased(int key) {}
}
