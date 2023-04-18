package lab07.Ex02;

import java.util.Scanner;

public class VowelFilter extends FilterDecorator {

    private Scanner sc;

    public VowelFilter(TextReaderInterface textReader) {
        super(textReader);
    }

    @Override
    public boolean hasNext() {
        if (sc != null && sc.hasNext())
            return true;
        return textReader.hasNext();
    }

    @Override
    public String next() {
        if (sc == null || sc != null && !sc.hasNext())
            sc = new Scanner(textReader.next());
        return this.hasNext() ? sc.next().replaceAll("[AEIOUaeiou]", "") : null;
    }

}
