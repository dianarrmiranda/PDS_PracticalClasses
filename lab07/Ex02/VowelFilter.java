package lab07.Ex02;

public class VowelFilter extends FilterDecorator {

    private String word;

    public VowelFilter(TextReaderInterface textReader) {
        super(textReader);
    }

    @Override
    public boolean hasNext() {
        if (word == null || word.equals("")) {
            if (textReader.hasNext()) {
                word = textReader.next();
            }
        }
        return !(word == null || word.equals(""));
    }

    @Override
    public String next() {
        String returnStr = "";
        if (this.hasNext()) {
            returnStr = this.word.replaceAll("[aeiouAEIOU]", "");
            this.word = "";
        }
        return returnStr;
    }

}
    