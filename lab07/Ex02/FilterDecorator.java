package lab07.Ex02;

public class FilterDecorator implements TextReaderInterface {
    
    protected TextReaderInterface textReader;

    public FilterDecorator(TextReaderInterface textReader) {
        this.textReader = textReader;
    }

    @Override
    public boolean hasNext(){
        textReader.hasNext();
        return false;
    }

    @Override
    public String next(){
        textReader.next();
        return null;
    }
}
