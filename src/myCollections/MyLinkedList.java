package myCollections;

import java.util.Collection;

public class MyLinkedList {

    private class Node {

        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public <T> MyLinkedList(Collection<T> collection) {
        this();
        for (T item : collection) {
            Node newNode = new Node(item);
            if (head == null) {
                head = newNode; 
            }else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            size++;
        }
    }

    public int getSize() {
        return size;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }

    public void add(Object data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode; 
        }else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public Object get(int index) {
        validateIndex(index);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public Object remove(int index) {
        validateIndex(index);
        Object removedData;
        if (index == 0) {
            removedData = head.data;
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedData = current.next.data;
            current.next = current.next.next;
        }
        size--;
        return removedData;
    }

    public void addAll(Collection<?> collection) {
        for (Object item : collection) {
            add(item);
        }
    }

    public void sort() {
        if (head == null || head.next == null) {
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current != null && current.next != null) {
                if (current.data instanceof Comparable) { // Check if the data is comparable
                    @SuppressWarnings("unchecked") // Suppress unchecked cast warning
                    Comparable<Object> currentData = (Comparable<Object>) current.data;
                    if (currentData.compareTo(current.next.data) > 0) {
                        Object temp = current.data;
                        current.data = current.next.data;
                        current.next.data = temp;
                        swapped = true;
                    }
                } else {
                    throw new ClassCastException("Data in the list is not comparable");
                }
                current = current.next;
            }
        } while (swapped);
    }

}
