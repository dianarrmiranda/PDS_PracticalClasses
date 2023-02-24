package lab01;

import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class RequisitosEntrada {
  public static void main(String[] args) {

    int count=0, linesize=0;
    String regEx = "[A-Z]\\w*";
    List<String> words = new ArrayList<String> (); 

    try {
      File entry = new File("source.txt");            // numa primeria leitura, verificar apenas se o puzzel cumpre os requisitos
      Scanner myReader = new Scanner(entry);          // noutro file, após verificação, ler e guardar em vars para descobrir
      while (myReader.hasNextLine() && count < 40) {
        String data = myReader.nextLine();

        if(count==0){
            linesize = data.length(); // tamanho da 1ª linha tem que ser igual ao count de linhas
        }else if(data.length()!=linesize){
          System.out.println("As linhas do puzzle têm que ter todas a mesma dimensão!\n");
          System.exit(0);
        }
        
        if(data.matches(regEx)){  // verificar sempre quando saímos do puzzle e entramos na solução
          count++;
        }else{
          String[] parts = data.split("[,; ]");
          for(String x : parts){
            words.add(x); // saindo do puzzle, estamos na parte das soluções, que vamos guardar em 'words'
          } 
        }  
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    if(count == linesize){
        char [][] soup = new char [count][linesize]; // onde vamos guardar o puzzle
    }
  }
}
