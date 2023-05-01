package lab07.Ex02;

public class TermFilter extends FilterDecorator {

    private String[] words;

    public TermFilter(TextReaderInterface textReader) {
        super(textReader);
    }

    @Override
    public boolean hasNext() {
        if (this.words == null || this.words.length == 0) {
            if (textReader.hasNext()) {
                this.words = textReader.next().split(" ");
            }
        }
        return !(this.words == null || this.words.length == 0);
    }

    @Override
    public String next() {
        String returnStr = "";
        if (this.hasNext()) {
            returnStr = this.words[0];
            String[] temp = new String[this.words.length - 1];
            for (int i = 1; i < this.words.length; i++) {
                temp[i - 1] = this.words[i];
            }
            this.words = temp;
        }
        return returnStr;
    }

}
