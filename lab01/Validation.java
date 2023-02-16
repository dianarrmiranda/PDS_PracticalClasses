package lab01;

import java.util.ArrayList;
import java.util.List;

public class Validation {

    List<ArrayList<String>> puzzle;
    List<String> words;

    public Validation(List<ArrayList<String>> puzzle, List<String> words) {
        this.puzzle = puzzle;
        this.words = words;
    }

    public void MaximumSize(List<ArrayList<String>> puzzle){ // Requisito de entrada 1
        int Ncols= 0;
        if(puzzle.size() > 40){
            System.out.println("O puzzle tem de ter no máximo 40 linhas");
            System.exit(0);
        }
        for (int i = 0; i < puzzle.size(); i++) {
            if(puzzle.get(i).size() > 40){
                System.out.println("O puzzle tem de ter no máximo 40 colunas");
            System.exit(0);
            }
            Ncols= i;
        }
        if(puzzle.size() != puzzle.get(Ncols).size()){
            System.out.println("O puzzle tem de ser quadrado");
            System.exit(0);
        }
    }

    public void AtLeast3Characters(List<String> words){ // Requisito de entrada 7
        for (int i = 0; i < words.size(); i++) {
            if(words.get(i).length() < 3){
                System.out.println("As palavras têm de conter pelo menos 3 carateres");
                System.exit(0); // parar a execução do programa
            }
        }
    }
    
}
