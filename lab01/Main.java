package lab01;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.UIDefaults.ProxyLazyValue;


public class Main {
    public static void main(String[] args) {
        String file = args[0];
        String linha = "";
        String puzzle[][] ;

        try {
          FileReader arq = new FileReader(file);
          BufferedReader lerArq = new BufferedReader(arq);
          linha = lerArq.readLine(); // lê a primeira linha - a variável "linha" recebe o valor "null" quando o processo - de repetição atingir o final do arquivo texto
          
          puzzle = new String[linha.length()][linha.length()];
          int count = 0;
          while (count < linha.length()){
            for(int i = 0; i<linha.length(); i++){
              puzzle[count][i] = linha.substring(i, i);
            }
            linha = lerArq.readLine();
            count++;
          }
          
          arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
              e.getMessage());
        }

        System.out.print(puzzle[0][0]);
    
        System.out.println();
    }
}
