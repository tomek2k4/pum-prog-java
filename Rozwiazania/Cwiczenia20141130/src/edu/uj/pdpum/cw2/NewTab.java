package edu.uj.pdpum.cw2;

import java.util.Iterator;


public class NewTab<E> extends Tab<E> implements Iterable<E> {
   
    @Override
    public Iterator<E> iterator() {
        return new InternalIterator();
    }
    
    class InternalIterator implements Iterator<E> {
        
        private int pozycja = 0;

        @Override
        public boolean hasNext() {
            return pozycja < size();
        }

        @Override
        public E next() {
            return get(pozycja++);
        }
        
    }

}
