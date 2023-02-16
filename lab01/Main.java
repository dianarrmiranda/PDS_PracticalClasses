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
    
    List<ArrayList<String>> data = readData(file);

    List<ArrayList<String>> puzzle = data.subList(0, data.size() - 1);
    List<String> words = data.get(data.size() - 1);

    // print do puzzle
    for (int i = 0; i < puzzle.size(); i++) {
      for (int j = 0; j < puzzle.get(i).size(); j++) {
        System.out.print(puzzle.get(i).get(j));
      }
      System.out.println();
    }

    // print das palavras
    for (int i = 0; i < words.size(); i++) {
      System.out.println(words.get(i));
    }

    Solver solver = new Solver(puzzle, words);
    solver.MaximumSize(puzzle); // Requisito de entrada 1
    solver.AtLeast3Characters(words);  // Requisito de entrada 7
    solver.solve();

    
  }

  public static List<ArrayList<String>> readData(String file){

    List<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    String linha = "";
    List<ArrayList<String>> puzzle = new ArrayList<ArrayList<String>>();
    List<String> subPuzzle = new ArrayList<String>();
    List<String> words = new ArrayList<String>();

    try {
      FileReader arq = new FileReader(file);
      BufferedReader lerArq = new BufferedReader(arq);
      String linha1 = lerArq.readLine(); // lê a primeira linha do arquivo
      for (int i = 0; i < linha1.length(); i++) {
        subPuzzle.add(linha1.substring(i, i + 1));
      }
      puzzle.add((ArrayList<String>) subPuzzle);

      for (int count = 1; count < linha1.length(); count++) {
        linha = lerArq.readLine(); // lê da segunda até a última linha
        subPuzzle = new ArrayList<String>();
        for (int i = 0; i < linha.length(); i++) {
          subPuzzle.add(linha.substring(i, i + 1));
        }
        puzzle.add((ArrayList<String>) subPuzzle);
      }

      while ((linha = lerArq.readLine()) != null) {
        for (String s : linha.split("[; ]")) {
            words.add(s);
        }
    }

      arq.close();
    } catch (IOException e) {
      System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage()); // aqui também podia ser System.out.println("Erro na abertura do arquivo: ");
    }

    data.addAll(puzzle);
    data.add((ArrayList<String>) words);

    return data;
  } 
}
