package lab01;

import java.util.ArrayList;
import java.util.List;


public class Solver {
    
    private List<ArrayList<String>> puzzle;
    private List<String> words;
    private List<String> temp = new ArrayList<String>();

    private List<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
    private List<ArrayList<String>> finalPuzzle = new ArrayList<ArrayList<String>>();


    public Solver(List<ArrayList<String>> puzzle, List<String> words) {
        this.puzzle = puzzle;
        this.words = words;
    }

    public void solve() {

        for(int w = 0; w < words.size(); w++){
            int x = FindDiagonal(words.get(w));
            if(x == 0){
                x = FindHorizontal(words.get(w));
                if(x == 0){
                    x = FindVertical(words.get(w));
                }
            }   
        }  
    }

    private int FindDiagonal(String string) {
        int find = 0;
        
        for(int i = 0; i < puzzle.size(); i++){
            for(int j = 0; j < puzzle.get(i).size(); j++){
                if(puzzle.get(i).get(j).equals(string.substring(0, 1).toUpperCase())){
                    if(i + string.length() <= puzzle.size() && j + string.length() <= puzzle.get(i).size()){
                        for(int k = 0; k < string.length(); k++){
                            if(puzzle.get(i + k).get(j + k).equals(string.substring(k, k + 1).toUpperCase())){
                                find = 1;
                            }else{
                                find = 0;
                                break;
                            }
                        }
                        if(find == 1){
                            temp = new ArrayList<String>();
                            temp.add(string);
                            temp.add(Integer.toString(string.length()));
                            temp.add(Integer.toString(i+1) + "," + Integer.toString(j+1));
                            temp.add(Positions.DownRight.toString()); // usar o enumerate
                            result.add((ArrayList<String>) temp);
                        }
                    }else if (i + string.length() <= puzzle.size() && j - string.length() >= 0){
                        for(int k = 0; k < string.length(); k++){
                            if(puzzle.get(i + k).get(j - k).equals(string.substring(k, k + 1).toUpperCase())){
                                find = 1;
                            }else{
                                find = 0;
                                break;
                            }
                        }
                        if(find == 1){
                            temp = new ArrayList<String>();
                            temp.add(string);
                            temp.add(Integer.toString(string.length()));
                            temp.add(Integer.toString(i+1) + "," + Integer.toString(j+1));
                            temp.add(Positions.DownLeft.toString()); // usar o enumerate
                            result.add((ArrayList<String>) temp);
                        }
                    }else if (i - string.length() >= 0 && j + string.length() <= puzzle.get(i).size()){
                        for(int k = 0; k < string.length(); k++){
                            if(puzzle.get(i - k).get(j + k).equals(string.substring(k, k + 1).toUpperCase())){
                                find = 1;
                            }else{
                                find = 0;
                                break;
                            }
                        }
                        if(find == 1){
                            temp = new ArrayList<String>();
                            temp.add(string);
                            temp.add(Integer.toString(string.length()));
                            temp.add(Integer.toString(i+1) + "," + Integer.toString(j+1));
                            temp.add(Positions.UpRight.toString()); // usar o enumerate
                            result.add((ArrayList<String>) temp);
                        }
                    }else if (i - string.length() >= 0 && j - string.length() >= 0){
                        for(int k = 0; k < string.length(); k++){
                            if(puzzle.get(i - k).get(j - k).equals(string.substring(k, k + 1).toUpperCase())){
                                find = 1;
                            }else{
                                find = 0;
                                break;
                            }
                        }
                        if(find == 1){
                            temp = new ArrayList<String>();
                            temp.add(string);
                            temp.add(Integer.toString(string.length()));
                            temp.add(Integer.toString(i+1) + "," + Integer.toString(j+1));
                            temp.add(Positions.UpLeft.toString()); // usar o enumerate
                            result.add((ArrayList<String>) temp);
                        }
                    }
                 
                }
            }
        }

        return find;
    }

    private int FindVertical(String string) {
        int find = 0;

        for(int i = 0; i < puzzle.size(); i++){
            for(int j = 0; j < puzzle.get(i).size(); j++){
                if(puzzle.get(i).get(j).equals(string.substring(0, 1).toUpperCase())){
                    if(i + string.length() <= puzzle.size()){
                        for(int k = 0; k < string.length(); k++){
                            if(puzzle.get(i + k).get(j).equals(string.substring(k, k + 1).toUpperCase())){
                                find = 1;
                            }else{
                                find = 0;
                                break;
                            }
                        }
                        if(find == 1){
                            temp = new ArrayList<String>();
                            temp.add(string);
                            temp.add(Integer.toString(string.length()));
                            temp.add(Integer.toString(i+1) + "," + Integer.toString(j+1));
                            temp.add(Positions.Down.toString()); // usar o enumerate
                            result.add((ArrayList<String>) temp);
                        }
                    }else if (i - string.length() >= 0){
                        for(int k = 0; k < string.length(); k++){
                            if(puzzle.get(i - k).get(j).equals(string.substring(k, k + 1).toUpperCase())){
                                find = 1;
                            }else{
                                find = 0;
                                break;
                            }
                        }
                        if(find == 1){
                            temp = new ArrayList<String>();
                            temp.add(string);
                            temp.add(Integer.toString(string.length()));
                            temp.add(Integer.toString(i+1) + "," + Integer.toString(j+1));
                            temp.add(Positions.Up.toString()); // usar o enumerate
                            result.add((ArrayList<String>) temp);
                        }
                    }
                }
            }
        }
        return 0;
    }

    public int FindHorizontal(String word){
        
        int find = 0;

        for(int i = 0; i < puzzle.size(); i++){
            for(int j = 0; j < puzzle.get(i).size(); j++){
                if(puzzle.get(i).get(j).equals(word.substring(0, 1).toUpperCase())){
                    if(j + word.length() <= puzzle.get(i).size()){
                        for(int k = 0; k < word.length(); k++){
                            if(puzzle.get(i).get(j + k).equals(word.substring(k, k + 1).toUpperCase())){
                                find = 1;
                            }else{
                                find = 0;
                                break;
                            }
                        }
                        if(find == 1){
                            temp = new ArrayList<String>();
                            temp.add(word);
                            temp.add(Integer.toString(word.length()));
                            temp.add(Integer.toString(i+1) + "," + Integer.toString(j+1));
                            temp.add(Positions.Right.toString()); // usar o enumerate
                            result.add((ArrayList<String>) temp);
                        }
                    }else if(j - word.length() >= 0){
                        for(int k = 0; k < word.length(); k++){
                            if(puzzle.get(i).get(j - k).equals(word.substring(k, k + 1).toUpperCase())){
                                find = 1;
                            }else{
                                find = 0;
                                break;
                            }
                        }
                        if(find == 1){
                            temp = new ArrayList<String>();
                            temp.add(word);
                            temp.add(Integer.toString(word.length()));
                            temp.add(Integer.toString(i+1) + "," + Integer.toString(j+1));
                            temp.add(Positions.Left.toString()); // usar o enumerate
                            result.add((ArrayList<String>) temp);
                        }
                    }
                }
            }
        }

        return find;
    }

    public void makeFinalPuzzle()
    {
        int size = puzzle.size();
        for (int i = 0; i<result.size(); i++){
            if(result.get(i).get(result.size()-1) == "Up"){ // seria preciso trocar a string "Up" com as positions
                ArrayList<Integer> cords = new ArrayList<>();
                for (String s : result.get(i).get(2).split(",")) {
                    cords.add(Integer.parseInt(s));
                }
                for(int x = 0; x < result.get(i).get(0).length();x++){
                    finalPuzzle.get(cords.get(0)).set(cords.get(1),result.get(i).get(0));
                }
            }
        }
        
    }

    public List<ArrayList<String>> getResult() {
        return result;
    }

    public void toStringResult(){
        System.out.printf("%-13s %-13s %-13s %-13s %n", "Word", "Length", "Start", "Direction");
        System.out.printf("-----------------------------------------------------------%n");
        for(int i = 0; i < result.size(); i++){
            for(int j = 0; j < result.get(i).size(); j++){
                System.out.printf("%-13s ", result.get(i).get(j));
            }
            System.out.println("");
        }
    }
    


}
