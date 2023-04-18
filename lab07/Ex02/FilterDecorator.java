package lab07.Ex02;

abstract class FilterDecorator implements TextReaderInterface {
    
    protected TextReaderInterface textReader;

    public FilterDecorator(TextReaderInterface textReader) {
        this.textReader = textReader;
    }

    @Override
    public abstract boolean hasNext();

    @Override
    public abstract String next();
}
