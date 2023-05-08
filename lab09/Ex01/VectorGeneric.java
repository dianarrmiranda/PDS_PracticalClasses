package lab09.Ex01;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class VectorGeneric<T> {
    private T[] vec;
    private int nElem;
    private final static int ALLOC = 50;
    private int dimVec = ALLOC;

    @SuppressWarnings("unchecked")
    public VectorGeneric() {
        vec = (T[]) new Object[dimVec];
        nElem = 0;
    }

    public boolean addElem(T elem) {
        if (elem == null)
            return false;
        ensureSpace();
        vec[nElem++] = elem;
        return true;
    }

    private void ensureSpace() {
        if (nElem >= dimVec) {
            dimVec += ALLOC;
            @SuppressWarnings("unchecked")
            T[] newArray = (T[]) new Object[dimVec];
            System.arraycopy(vec, 0, newArray, 0, nElem);
            vec = newArray;
        }
    }

    public boolean removeElem(T elem) {
        for (int i = 0; i < nElem; i++) {
            if (vec[i].equals(elem)) {
                if (nElem - i - 1 > 0) // not last element
                    System.arraycopy(vec, i + 1, vec, i, nElem - i - 1);
                vec[--nElem] = null; // libertar último objecto para o GC
                return true;
            }
        }
        return false;
    }

    public int totalElem() {
        return nElem;
    }

    public T getElem(int i) {
        return (T) vec[i];
    }

    public Iterator<T> Iterator() {
        return new VectorIterator<T>();
    }

    public ListIterator<T> listIterator() {
        return new VectorListIterator<T>();
    }

    public ListIterator<T> listIterator(int index){ // start at index
        return new VectorListIterator<T>(index);
    } 

    private class VectorIterator<T> implements Iterator<T> {
        private int indice;
    
        public VectorIterator() {
            indice = 0;
        }
    
        public boolean hasNext() {
            return (this.indice < nElem);
        }
    
        public T next() {
            if (hasNext())
                return (T)VectorGeneric.this.vec[indice++];
            throw new NoSuchElementException("only " + nElem + " elements");
        }
    
        public void remove() {
            throw new UnsupportedOperationException("Operação não suportada!");
        }

    }
    
    private class VectorListIterator<T> implements ListIterator<T> {
    
        private int indice;
    
        public VectorListIterator() {
            indice = 0;
        }
    
        public VectorListIterator(int index) {
            this.indice = index;
        }
    
    
        @Override
        public void add(T e) {
            throw new UnsupportedOperationException("Unimplemented method 'add'");
        }
    
        @Override
        public boolean hasNext() {
            return (this.indice < nElem);
        }
    
        @Override
        public boolean hasPrevious() {
            return (this.indice > 0);
        }
    
        @Override
        public T next() {
            if (hasNext())
                return (T) VectorGeneric.this.vec[indice++];
            throw new NoSuchElementException("only " + nElem + " elements");
        }
    
        @Override
        public int nextIndex() {
            return this.indice + 1;
        }
    
        @Override
        public T previous() {
            if (hasPrevious())
                return (T) VectorGeneric.this.vec[indice--];
            throw new NoSuchElementException("only " + nElem + " elements");
        }
    
        @Override
        public int previousIndex() {
            return this.indice - 1;
        }
    
        @Override
        public void remove() {
            throw new UnsupportedOperationException("Unimplemented method 'remove'");
        }
    
        @Override
        public void set(T e) {
            throw new UnsupportedOperationException("Unimplemented method 'set'");
        }
    
    }
    
}



