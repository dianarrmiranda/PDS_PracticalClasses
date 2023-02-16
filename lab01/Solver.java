package lab01;

import java.util.ArrayList;
import java.util.List;

public class Solver {
    
    List<ArrayList<String>> puzzle;
    List<String> words;

    public Solver(List<ArrayList<String>> puzzle, List<String> words) {
        this.puzzle = puzzle;
        this.words = words;
    }

    public void solve() {
        System.out.println("Solving puzzle...");
    }

}
