package org.example;

/**
 * Classe principal que apenas inicia a aplicação.
 * Não contém lógica de desenho nem interação com o terminal,
 * apenas cria o controlador e inicia seu loop.
 */
public class App {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        controlador.executar();
    }
}

