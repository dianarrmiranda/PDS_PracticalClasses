package lab09.Ex01;

import java.util.Iterator;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {

        VectorGeneric<Integer> vec = new VectorGeneric<Integer>();
        VectorGeneric<String> vecStr = new VectorGeneric<String>();

        for (int i = 0; i < 10; i++) {
            vec.addElem(i);
        }

        for (int i = 0; i < 10; i++) {
            vecStr.addElem("str " + i);
        }

        System.out.println("Iterator:");

        Iterator<Integer> it = vec.Iterator();
        while (it.hasNext()) {
            int p = it.next();
            System.out.println("i: " + p);
        }

        System.out.println();

        Iterator<String> itStr = vecStr.Iterator();
        while (itStr.hasNext()) {
            String p = itStr.next();
            System.out.println("i: " + p);
        }
        System.out.println();
        System.out.println("ListIterator:");

        ListIterator<Integer> listIt = vec.listIterator();
        while (listIt.hasNext()) {
            int p = listIt.next();
            System.out.println("i: " + p + " - next i: " + listIt.next());
        }
        System.out.println();
        ListIterator<String> listItStr = vecStr.listIterator();
        while (listItStr.hasNext()) {
            String p = listItStr.next();
            System.out.println("i: " + p + " - next i: " + listItStr.next());
        }
    }

}
