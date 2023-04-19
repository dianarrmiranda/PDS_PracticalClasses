package lab07.Ex02;

public class CapitalizationFilter extends FilterDecorator {

    private String word;

    public CapitalizationFilter(TextReaderInterface textReader) {
        super(textReader);
    }

    public boolean hasNext() {
        if (this.word == null || this.word.equals("")) {
            if (textReader.hasNext()) {
                this.word = textReader.next();
            }
        }
        return !(this.word == null || this.word.equals(""));
    }

    @Override
    public String next() {
        String returnStr = "";
        if (this.hasNext()) {

            returnStr = this.word.substring(0, 1).toUpperCase() + this.word.substring(1);
            
            for (int i = returnStr.length() - 1; i >= 0; i--) {
                if (Character.isLetter(returnStr.charAt(i))) {
                    returnStr = returnStr.substring(0, i) + returnStr.substring(i, i + 1).toUpperCase() + returnStr.substring(i + 1);
                    break;
                }
            }

            this.word = "";
        }

        return returnStr;
    }

}
