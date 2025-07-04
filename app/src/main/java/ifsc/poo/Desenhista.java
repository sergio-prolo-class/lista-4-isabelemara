package ifsc.poo;

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.DrawListener;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Desenhista implements DrawListener {
    private final Draw draw;
    private final Configuracao config;
    private final List<Figura> figuras;

    public Desenhista(Draw draw, Configuracao config) {
        this.draw = draw;
        this.config = config;
        this.figuras = new ArrayList<>();
    }

    @Override
    public void mousePressed(double x, double y) {
        Figura figura = criarFigura(config.getFormaAtual(), x, y, config.getTamanho(), config.getCorAtual(), config.isPreenchida());
        if (figura != null) {
            figuras.add(figura);
            System.out.println("Figura adicionada: " + config.getFormaAtual());
            desenharTudo();
        }
    }

    // Substituímos a lógica principal para funcionar aqui:
    @Override
    public void keyTyped(char c) {
        System.out.println("Tecla digitada: '" + c + "' código: " + (int) c);
        switch (Character.toUpperCase(c)) {
            case 'F' -> config.alternarPreenchimento();
            case 'Q' -> config.diminuirTamanho();
            case 'W' -> config.aumentarTamanho();
            case 'C' -> {
                figuras.clear();
                System.out.println("Todos os desenhos foram apagados.");
            }
            case 'P' -> mostrarResumo();
            case 'A' -> moverTodasFiguras(-config.getMovimentoDelta(), 0);
            case 'D' -> moverTodasFiguras(config.getMovimentoDelta(), 0);
            case 'S' -> moverTodasFiguras(0, -config.getMovimentoDelta());
            case 'Z' -> moverTodasFiguras(0, config.getMovimentoDelta());
            default -> processarAtalhoEspecial(c);
        }
        desenharTudo();
    }

    // Método keyPressed vazio (obrigatório pela interface)

    public void keyPressed(char c) {
        // não usamos mais esse método
    }


    public void keyReleased(char c) {}

    @Override
    public void mouseReleased(double x, double y) {}

    private void moverTodasFiguras(double dx, double dy) {
        for (Figura f : figuras) {
            f.mover(dx, dy); // aqui eu uso polimorfismo
        }
    }

    private void processarAtalhoEspecial(char c) {
        switch (c) {
            case '1' -> config.setFormaAtual("Circulo");
            case '2' -> config.setFormaAtual("Quadrado");
            case '3' -> config.setFormaAtual("Losango");
            case '4' -> config.setFormaAtual("Hexagono");
            case '5' -> config.setFormaAtual("Pentagono");
            case '6' -> config.setCorAtual(Color.BLACK);
            case '7' -> config.setCorAtual(Color.RED);
            case '8' -> config.setCorAtual(Color.BLUE);
            case '9' -> config.setCorAtual(Color.MAGENTA);
            default -> System.out.println("Tecla não mapeada: '" + c + "'");
        }
    }

    private void desenharTudo() {
        draw.clear();
        for (Figura f : figuras) {
            f.desenhar(draw); // aqui eu uso polimorfismo
        }
        draw.show();
    }

    private Figura criarFigura(String tipo, double x, double y, int tamanho, Color cor, boolean preenchida) {
        return switch (tipo) {
            case "Circulo" -> new Circulo(x, y, tamanho, cor, preenchida);
            case "Quadrado" -> new Quadrado(x, y, tamanho, cor, preenchida);
            case "Losango" -> new Losango(x, y, tamanho, cor, preenchida);
            case "Hexagono" -> new Hexagono(x, y, tamanho, cor, preenchida);
            case "Pentagono" -> new Pentagono(x, y, tamanho, cor, preenchida);
            default -> null;
        }; // aqui eu uso polimorfismo
    }

    private void mostrarResumo() {
        int total = figuras.size();
        double somaPerimetros = 0;
        double somaAreas = 0;

        for (Figura f : figuras) {
            somaPerimetros += f.getPerimetro();
            somaAreas += f.getArea();
        }

        double mediaArea = total > 0 ? somaAreas / total : 0;

        System.out.println("\n=== RESUMO DAS FIGURAS ===");
        System.out.println("- Total de figuras: " + total);
        System.out.printf("- Soma dos perímetros: %.2f%n", somaPerimetros);
        System.out.printf("- Área média: %.2f%n", mediaArea);
        System.out.println("==========================\n");
    }
}
