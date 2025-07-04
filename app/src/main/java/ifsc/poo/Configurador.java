package ifsc.poo;

import edu.princeton.cs.algs4.Draw;

public class Configurador {
    public void iniciar() {
        Draw draw = new Draw();
        draw.setCanvasSize(800, 600);
        draw.enableDoubleBuffering();
        draw.clear();

        Configuracao config = new Configuracao();
        Desenhista desenhista = new Desenhista(draw, config);
        draw.addListener(desenhista);

        System.out.println("""
==========================
CONTROLES DO DESENHO
==========================

-> Escolha de forma:
   - Tecla 1: Círculo
   - Tecla 2: Quadrado
   - Tecla 3: Losango
   - Tecla 4: Hexágono
   - Tecla 5: Pentágono   <--- adicionado aqui

-> Escolha de cor:
   - Tecla 6: Preto
   - Tecla 7: Vermelho
   - Tecla 8: Azul
   - Tecla 9: Magenta

-> Outros comandos:
   - F: Alternar preenchimento
   - Q: Diminuir tamanho
   - W: Aumentar tamanho
   - C: Limpar todos os desenhos
   - P: Mostrar resumo (número de figuras, perímetro total, área média)
""");


        while (true) {}
    }
}
