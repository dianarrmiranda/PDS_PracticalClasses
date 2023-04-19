package lab07.Ex02;

import java.text.Normalizer;

public class NormalizationFilter extends FilterDecorator {

    private String word;

    public NormalizationFilter(TextReaderInterface textReader) {
        super(textReader);
    }

    @Override
    public boolean hasNext() {
        if (this.word == null || this.word.equals("")){
            if (textReader.hasNext()) {
                this.word = textReader.next();
            }
        }
        return !(this.word == null || this.word.equals(""));
    }

    public String next() {
        String returnStr = "";
        if (this.hasNext()) {
            returnStr = this.word.replaceAll("(?![@',&])\\p{Punct}", "");
            returnStr = Normalizer.normalize(returnStr, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
            returnStr = returnStr.replaceAll("[^\\p{Alnum} ]", "");
            this.word = "";
        }
        return returnStr;
    }

}
