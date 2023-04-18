package lab07.Ex02;

import java.text.Normalizer;
import java.util.Scanner;

public class NormalizationFilter extends FilterDecorator {

    private Scanner sc;

    public NormalizationFilter(TextReaderInterface textReader) {
        super(textReader);
    }

    @Override
    public boolean hasNext() {
        if (sc != null && sc.hasNext())
            return true;
        return textReader.hasNext();
    }

    public String next() {
        if (sc == null || sc != null && !sc.hasNext())
            sc = new Scanner(textReader.next());
        if (this.hasNext()) {
            String[] words = sc.next().replaceAll("[,./]", "").split("\\s+");
            String output = String.join(" ", words);
            return Normalizer.normalize(output, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
        }
        return null;
    }

}
