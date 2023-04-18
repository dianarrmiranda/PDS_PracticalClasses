package lab07.Ex02;

import java.util.Scanner;

public class TermFilter extends FilterDecorator{

    private Scanner sc;

    public TermFilter(TextReaderInterface textReader) {
        super(textReader);
    }

    @Override public boolean hasNext() {
        if(sc!=null && sc.hasNext())
            return true;
        return textReader.hasNext();
    }

    @Override public String next() {
        if(sc==null || sc!=null && !sc.hasNext())
            sc = new Scanner(textReader.next());
        return sc.next();
    }

    
}
