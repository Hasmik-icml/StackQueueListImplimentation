package com.company.collections;

import com.company.collections.collectionsUtil.Node;

/***
 * Stack -> LIFO (Last Input First Output)
 * @param <T> any type for initializing Collections info type
 */
public class Stack<T> {
    private Node<T> top; // {null,info,null}
    private int size;

    public Stack() {
        this.top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T val) {
        if (top == null) {                                //next   prev
            top = new Node<T>(val, null, null); //
        } else {
            Node<T> temp = top;// {5,15}
            top = new Node<T>(val, temp, null);// 15
            temp.setNext(top);//5.next 15
        }
        size++;
    }

    public T top() {
        return top.getInfo();
    }

    public T pop() {
        if (size == 0) {
            try {
                throw new Exception("you can't remove element from empty Stack, modify your code");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return (T) new Object();//Հարցնել Կարենից
        }
        if (size == 1) {
            T temp = top.getInfo();// առանց էս տողի աշխատեց
            top = null;
            size--;//0
            return temp; // return (T) top

        } else {
            Node<T> temp = top; // {5,15} // top > 15
            top = top.getPrev(); // top - 5
            top.setNext(null);
            temp.setPrev(null);//
            size--;

            return temp.getInfo();

        }


    }

    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();
        s.append("Stack{\t");

        if (size == 0) {
            s.append("no data, ");
        } else if (size == 1) {
            s.append("{").append(top.getInfo()).append("}, ");
        } else {
            Node<T> temp = top;
            while (temp.getPrev() != null) {
                temp = temp.getPrev();
            }
            while (temp != null) {
                s.append("{").append(temp.getInfo()).append("}, ");
                temp = temp.getNext();

            }
        }


        s.append("size=").append(size).append("\t}");

        return s.toString();
    }
}