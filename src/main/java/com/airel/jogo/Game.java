package com.airel.jogo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
  public void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<Carta> baralho = new ArrayList<>();

    // Inicializa o baralho com valores de cartas de 1 a 13 (sem naipes)
    for (int i = 1; i <= 13; i++) {
      for (int j = 0; j < 4; j++) {
        baralho.add(new Carta(i));
      }
    }

    // Embaralha o baralho
    // https://dicasdeprogramacao.com.br/java-como-embaralhar-uma-lista/
    Collections.shuffle(baralho);

    int pontuacaoJogador = 0;

    System.out.println("\nVamos começar o jogo!");

    do {
      Carta carta = baralho.remove(0);
      System.out.println("\nVocê recebeu uma carta com valor: " + carta.getValor());
      pontuacaoJogador += carta.getValor();
      System.out.println("Pontuação total: " + pontuacaoJogador);

      if (pontuacaoJogador >= 21) {
        break;
      }

      System.out.println("\nDeseja pedir outra carta? (Digite 's' para sim, ou 'n' para não)");
      String resposta = scanner.next().toLowerCase();

      if (!resposta.equalsIgnoreCase("s")) {
        break;
      }
      Collections.shuffle(baralho);
    } while (pontuacaoJogador < 21);

    if (pontuacaoJogador == 21) {
      System.out.println("\n\nVocê fez 21! Parabéns!".toUpperCase());
    } else if (pontuacaoJogador > 21) {
      System.out.println("\n\nVocê estourou! Sua pontuação é maior que 21. Você perdeu.");
    } else {
      System.out.println("\n\nFim do jogo. Sua pontuação final: " + pontuacaoJogador);
    }

    scanner.close();
  }
}
