package linked;

import org.w3c.dom.Node;

public class LinkedList {
    private class Node {
        Integer value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    Node head;
    Node tail;
    Integer length;
    // These methods go in Linked List class
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        System.out.println("Head: " + head.value);
    }

    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }
    public void append(int value) {
        Node node = new Node(value);
        if(length == 0){
            tail = node;
            head = node;
            length = 1;
        } else {
            tail.next = node;
            tail = node;
            length++;
        }
    }
    public Node removeLast(){
        if (length == 0){ return null; }
        Node temp = head, pre = head;
        if(length>0){
            while (temp.next != null){
                pre = temp;
                temp = temp.next;
            }
            tail = pre;
            tail.next = null;
            length--;
        }
        if(length==0){
            temp = null;
            pre = null;
        }
        return pre;
    }
    public void prepend(int value){
        Node node = new Node(value);
        if(length==0){
            tail=node;
        }else{
            node.next = head;
        }
        head = node;
        length++;
    }
    public Node removeFirst(){
        if(length==0) return null;
        Node temp = head;
        head=head.next;
        temp.next=null;
        length--;
        if(length==0){
            tail=null;
        }
        return temp;
    }
}
