package lab01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import javax.swing.UIDefaults.ProxyLazyValue;

public class Main {
  public static void main(String[] args) {
    String file = args[0];
    String linha = "";
    List<ArrayList<String>> puzzle = new ArrayList<ArrayList<String>>();
    List<String> subPuzzle = new ArrayList<String>();

    try {
      FileReader arq = new FileReader(file);
      BufferedReader lerArq = new BufferedReader(arq);
      String linha1 = lerArq.readLine(); // lê a primeira linha do arquivo

      int count = 0;

      while (count < linha1.length()) {
        subPuzzle = new ArrayList<String>();
        for (int i = 0; i < linha.length(); i++) {
          subPuzzle.add(linha.substring(i, i + 1));
        }
        puzzle.add((ArrayList<String>) subPuzzle);
        linha = lerArq.readLine(); // lê da segunda até a última linha
        count++;
      }

      arq.close();
    } catch (IOException e) {
      System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage()); // aqui também podia ser System.out.println("Erro na abertura do arquivo: ");
    }

    // print do puzzle
    for (int i = 0; i < puzzle.size(); i++) {
      for (int j = 0; j < puzzle.get(i).size(); j++) {
        System.out.print(puzzle.get(i).get(j));
      }
      System.out.println();
    }
  }
}
