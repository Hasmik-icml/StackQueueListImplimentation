package com.company.collections;

import com.company.collections.collectionsUtil.Node;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class List <Type> implements Iterable {
    private Node<Type> first;
    private  Node <Type> last;
    private int size;


    public List() {
        first = last = null;
        size = 0;
      }

    public Node<Type> getFirst() {
        return first;
    }

    public void setFirst(Node<Type> first) {
        this.first = first;
    }

    public Node<Type> getLast() {
        return last;
    }

    public void setLast(Node<Type> last) {
        this.last = last;
    }

    public int size() {
        return size;
    }
    public void push(Type data) {
        if (first == null) {
            first = last = new Node <> (data, null, null);
        } else {
            last.setNext(new Node<>(data, last, null));
            last = last.getNext();
        }
        size++;
    }
    public Type pop() {
        if (size == 0) {
            throw new RuntimeException("massege this is error");
        } else if (size == 1) {
            Type temp = first.getInfo();
            first = last = null;
            size--;
            return temp;
        } else {
            Node <Type> temp = last;
            last = last.getPrev();
            last.setNext(null);
            temp.setPrev(null);
            size--;
            return temp.getInfo();
        }
    }                                // 0 1 2 3 4
//    public Type remove(int index) { // {5,7,8,0,14}
//        if (index < 0 || index >= size || size == 0) {
//            throw new RuntimeException("massege this is error");
//        } else {
//
//
//        }
//    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Stack{\t");

        if (size == 0) {
            s.append("no data, ");
        } else if (size == 1) {
            s.append("{").append(first.getInfo()).append("}, ");
        } else {
            Node<Type> temp = first;
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


    @Override
    public Iterator iterator() {

        return null;
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return Iterable.super.spliterator();
    }
}