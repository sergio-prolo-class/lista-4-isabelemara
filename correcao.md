# Correção

## Diagrama

- ausente

## Implementação

- while true nunca é indicado, mesmo nessa situação!
  - quando vocês se dedicarem a estudar sistemas operacionais, vocês vão se debruçar mais sobre loops
  - de qualquer forma, nessa situação atual o loop não é necessário!
  - só há alteração no desenho quando o mouse é pressionado
    - ou seja, é uma execução assíncrona. basta executar um método para desenhar cada vez que há click
  - além do mais, DrawListener e Draw oferecem soluções mais robustas para fazer loops de animação
    - se quiser, veja os métodos DrawListener.update() e Draw.setTimer()
- toda vez que precisaRedesenhar, você está criando uma nova lista vetorial (linha 44), o que não é eficiente
  - provavelmente é por isso que seu desenho pisca toda vez que há uma nova figura
- O desenho preechido não possui borda preta, como exigido
- As setas movem para o lado oposto
- suas indicações do polimorfismo estão corretas

## Requisitos funcionais

- [x] Impressão com o mouse
- [x] Seleção de figuras
- [x] Seleção de cores
- [x] Seleção de modo
- [x] Seleção de tamanho
- [ ] Movimento
- [x] Limpeza
- [x] Processamento

## Nota

8.5



