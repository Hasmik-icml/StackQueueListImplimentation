package com.company.collections;

import com.company.collections.collectionsUtil.Node;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class List <Type> {
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

    public void push(int index, Type data) {
       if (index < 0){
           throw new RuntimeException("index out of bound exception");
       } else if (index > size || size == 0){
           push(data);
       } else if (size != 0 && index < size) {
           Node<Type> temp = first;
           for(int i = 0; i < index-1; i++){
               if (temp.getNext() != null){
                   temp = temp.getNext();
               }
           }
           Node<Type> node = new Node<>(data, temp, temp.getNext());
           temp.getNext().setPrev(node);
           temp.setNext(node);
           size++;
       }
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
    }                                // 0 1  2 3 4 5                      0 1 2 3  4
    public void remove(int index) { //                       {5,7,-1,8,0,14}
        if (index < 0 || index >= size || size == 0) {//       8.prev.next =8.next    8.next.prev = 8.prev
            throw new RuntimeException("index out of bound exception");//
        } else {
            Node<Type> temp = first;
            for(int i = 0; i < index; i++){//2
                if (temp.getNext() != null){
                    temp = temp.getNext();
                }
            }
            temp.getPrev().setNext(temp.getNext());
            temp.getNext().setPrev(temp.getPrev());
            temp.setPrev(null);
            temp.setNext(null);
            size--;
        }

    }

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

}