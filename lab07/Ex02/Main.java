package lab07.Ex02;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        File file = new File("./lab07/Ex02/text.txt");

        System.out.println("TextReader:");
        TextReaderInterface textReader = new TextReader(file);
        while (textReader.hasNext()) {
            System.out.println(textReader.next());
        }

        System.out.println();
        System.out.println("TermFilter:");
        textReader = new TermFilter(new TextReader(file));
        while (textReader.hasNext()) {
            System.out.println(textReader.next());
        }

        System.out.println();
        System.out.println("NormalizationFilter:");
        textReader = new NormalizationFilter(new TextReader(file));
        while (textReader.hasNext()) {
            System.out.println(textReader.next());
        }

        System.out.println();
        System.out.println("VowelFilter:");
        textReader = new VowelFilter(new TextReader(file));
        while (textReader.hasNext()) {
            System.out.println(textReader.next());
        }

        System.out.println();
        System.out.println("CapitalizationFilter:");
        textReader = new CapitalizationFilter(new TextReader(file));
        while (textReader.hasNext()) {
            System.out.println(textReader.next());
        }

        

    }

}
