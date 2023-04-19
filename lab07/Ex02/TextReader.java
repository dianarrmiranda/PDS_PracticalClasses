package lab07.Ex02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TextReader implements TextReaderInterface {

    private File filename;

    List<String> lines = new ArrayList<String>();
    String line = "";

    public TextReader(File fileName) {
        this.filename = fileName;

        try (Scanner sc = new Scanner(filename)) {
            sc.useDelimiter(System.getProperty("line.separator"));
            if (sc.hasNext()) {
                this.lines.add(sc.next());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
            
    }

    @Override
    public boolean hasNext() {
        return !(this.lines == null || this.lines.size() == 0);
    }

    @Override
    public String next() {
        if (this.hasNext()) {
            this.line = this.lines.get(0);
            this.line = this.lines.remove(0);
            return line;
        }
        return null;
    }
}
