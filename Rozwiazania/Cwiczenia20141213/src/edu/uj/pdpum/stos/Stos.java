package edu.uj.pdpum.stos;

public class Stos {
    private Element top = null;

    public void push(Object o) {
        top = new Element(o, top);
    }

    public Object pop() {
        if (isEmpty()) {
            return null;
        } else {
            Object o = top.dane;
            top = top.nastepny;
            return o;
        }
    }

    public Object top() {
        if (isEmpty()) {
            return null;
        } else {
            return top.dane;
        }
    }

    public boolean isEmpty() {
        return (top == null);
    }
}
