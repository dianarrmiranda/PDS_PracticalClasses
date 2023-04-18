package lab07.Ex02;

import java.util.Scanner;

public class CapitalizationFilter extends FilterDecorator {

    private Scanner sc;

    public CapitalizationFilter(TextReaderInterface textReader) {
        super(textReader);
    }

    public boolean hasNext() {
        if (sc != null && sc.hasNext())
            return true;
        return textReader.hasNext();
    }

    @Override
    public String next() {
        if (sc == null || sc != null && !sc.hasNext())
            sc = new Scanner(textReader.next());
        String text = sc.next();
        String output = "";
        if (hasNext()) {
            if (text.length() > 2) {
                output += text.substring(0, 1).toUpperCase() +
                        text.substring(1, text.length() - 1).toLowerCase() +
                        text.substring(text.length() - 1).toUpperCase() + " ";
            } else {
                output += text.toUpperCase() + " ";
            }
            return output;
        }
        return null;
    }

}
