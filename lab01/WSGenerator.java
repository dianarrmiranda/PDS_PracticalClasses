package lab01;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WSGenerator {
    public static void main(String[] args) {
        String file = null;
        int Soup_Size = 0;
        
        for(int i = 0; i < args.length; i++){
            switch (args[i]) {
                case "-i":
                    file = args[i + 1]; // o nome do ficheiro vem a seguir ao parametro -i
                    continue;
                case "-s":
                    Soup_Size = Integer.parseInt(args[i + 1]);
                    continue;
            }
        }
    
        if(Soup_Size > 40){ // Verificar o tamanho maximo que o puzzle pode ter
            System.out.println("O tamanho máximo do puzzle é 40.");
            System.exit(0);
        }
        
        List<String> words = ReadWordsFromFile(file);

        Validation validation = new Validation(words);
        validation.WordsinLowerCaseOrBoth(words); // Requisito de entrada 3
        validation.WordsAlphaChars(words); // Requisito de entrada 4
        validation.AtLeast3Characters(words);  // Requisito de entrada 7
        words= validation.BiggerWordWithSamePrefix(words); // Requisito de entrada 9
        
        String output = "";

        for (int i = 0; i < words.size(); i++) {
            output += words.get(i) + " ";
        }
        System.out.println(output);
    }

    public static List<String> ReadWordsFromFile(String file) {
        // List<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        String linha = "";
        // List<ArrayList<String>> puzzle = new ArrayList<ArrayList<String>>();
        // List<String> subPuzzle = new ArrayList<String>();
        List<String> words = new ArrayList<String>();
        
        try {
            FileReader arq = new FileReader(file);
            BufferedReader lerArq = new BufferedReader(arq);
            
            while ((linha = lerArq.readLine()) != null) {
                if (linha.isEmpty()) { // Requisito de entrada 5
                    System.out.println("Existem linhas vazias no ficheiro.");
                    System.exit(0); // sai do programa
                }
                
                for (String s : linha.split("[;, ]")) { // Requisito de entrada 6
                    words.add(s);
                }
            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage()); // aqui também podia ser System.out.println("Erro na abertura do arquivo: ");
        }
        
        return words;
    }
}
