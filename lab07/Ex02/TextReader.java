package lab07.Ex02;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TextReader implements TextReaderInterface {

    private Scanner sc;

    public TextReader(String fileName) {
        try {
            sc = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.err.println("ERROR! File Not Found!");
            System.exit(1);
        }
    }

    @Override
    public boolean hasNext() {
        return sc.hasNextLine();
    }

    @Override
    public String next() {
        if (hasNext()) {
            return sc.nextLine();
        }
        return null;
    }
}
