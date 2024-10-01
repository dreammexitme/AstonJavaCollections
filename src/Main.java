
import myCollections.MyLinkedList;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        MyLinkedList myList = new MyLinkedList();
        myList.add(5);
        myList.add(3);
        myList.add(8);
        myList.add(1);
        myList.add(4);
        myList.add(2);

        System.out.println("Initial list:");
        myList.printList();
        System.out.println("Size of the list: " + myList.getSize());

        int indexToGet = 2;
        if (myList.getSize() > indexToGet) {
            System.out.println("Element at index " + indexToGet + ": " + myList.get(indexToGet)); 
        }else {
            System.out.println("The list has less than " + (indexToGet + 1) + " elements.");
        }

        int indexToRemove = 1;
        if (myList.getSize() > indexToRemove) {
            myList.remove(indexToRemove);
            System.out.println("List after removing element at index " + indexToRemove + ":");
            myList.printList();
        } else {
            System.out.println("Cannot remove element at index " + indexToRemove + ": Index out of bounds.");
        }

        myList.addAll(Arrays.asList(6, 0, 7));
        System.out.println("List after adding additional elements:");
        myList.printList();

        myList.sort();
        System.out.println("List after sorting:");
        myList.printList();
    }
}
