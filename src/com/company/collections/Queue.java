package com.company.collections;

import com.company.collections.collectionsUtil.Node;

/***
 * Queue -> FIFO (First Input First Output)
 * @param <T> any type for initializing Collections info type
 */
public class Queue<T> {
    private Node<T> back;
    private Node<T> front;
    private int size;


    public Queue() {
        back = front = null;
        size = 0;
    }

    public void push(T val) {
        if (back == null) {
            back = front = new Node<>(val, null, null);
        } else {
            back.setPrev(new Node<>(val, null, back));
            back = back.getPrev();
        }
        size++;

    }

    public T pop() {
        if (size == 0) {
            try {
                throw new Exception("you can't remove element from empty Stack, modify your code");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return (T) new Object();
        } else if (size == 1) {
            size--;
            Node<T> temp = front;
            front = back = null;
            return temp.getInfo();
        } else {
            size--;
            Node<T> temp = front;
            front = front.getPrev();
            front.setNext(null);
            temp.setPrev(null);
            return temp.getInfo();
        }
    }

    public T front() {
        return front.getInfo();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Queue{ Back[");
        Node<T> temp = back;
        while (temp != null) {
            s.append(temp).append(", ");
            temp = temp.getNext();
        }
        s.append("]Front, size=").append(size).append(" }");

        return s.toString();
    }

}