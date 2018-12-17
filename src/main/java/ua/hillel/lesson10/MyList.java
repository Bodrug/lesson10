package ua.hillel.lesson10;

import java.util.*;
import java.util.function.Consumer;

public class MyList<E> implements List<E> {

    private Node<E> head;

    @Override
    public int size() {

        int count=0;
        for (Node<E> node = head; node !=null ; node = node.next) {
            count++;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return head==null;
    }

    @Override
    public boolean contains(Object o) {
        for (Node<E> node = head; node !=null ; node = node.next) {
            if (Objects.equals(node.value,o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            Node<E> node = head;
            @Override
            public boolean hasNext() {
                return node == null;
            }

            @Override
            public E next() {
                E value = node.value;
                node =node.next;
                return value;
            }
        };
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    public class Node<T>{
       public T value;
       public Node<T> next;

       public Node(T value, Node<T> next) {
           this.value = value;
           this.next = next;
       }

       public T getValue() {
           return value;
       }

       public Node(T value) {
           this.value = value;
       }
   }

    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public boolean add(E e){
       Node<E> tail = tail();
       if (tail==null){
           head = new Node<E>(e);
       }
       else {
           tail.next = new Node<E>(e);
       }
       return true;
    }

    @Override
    public boolean remove(Object o) {
        Node<E> node = head;
        Node<E> prev = null;

        while (node!=null && node.next!=null){
            if(Objects.equals(node.value,o)){
                if (prev==null){
                    head = node.next;
                }
                else {
                    prev.next = node.next;
                }
            }

                prev = node;
                node = node.next;

        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o:c) {
            if(!contains(o)){
                return false;
            }

        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o:c) {
            remove(o);
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = head;
        int i = 0;

        while (node!=null && i != index){
            node = node.next;
            i++;
        }

        return node.value;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }


    public Node<E> tail(){
       Node<E> node = head;
       while (node!=null && node.next!=null){
           node = node.next;
       }
       return node;
   }

   void iterate(Consumer<E> consumer){
       for (Node<E> node = head; node !=null ; node = node.next) {
           consumer.accept(node.value);
       }
   }

   public void print(){
       for (Node<E> node = head; node != null; node = node.next) {
           System.out.println(node.value);
       }
   }
}

