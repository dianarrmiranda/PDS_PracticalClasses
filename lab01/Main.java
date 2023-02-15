package lab01;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//import javax.swing.UIDefaults.ProxyLazyValue;


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
          while (count < linha.length()-1){ // tem de ter aqui -1 por causa do 1º readLine
            for(int i = 0; i<linha.length(); i++){
              // colocar em cada posição do array puzzle a letra correspondente
              puzzle[count][i] = linha.substring(i, i+1);
              
            }
            linha = lerArq.readLine();
            count++; 
          }

          System.out.println(count);
          for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                System.out.print(puzzle[i][j] + " ");
            }
            System.out.println();
        }
          
          arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
              e.getMessage()); // aqui também podia ser System.out.println("Erro na abertura do arquivo: ");
        }
    }
}
