package linked;

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
    public Node get(int index) {
        if(index < 0 || index >= length){
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    public boolean set(int index, int val) {
        Node temp = get(index);
        if(temp != null){
            temp.value = val;
            return true;
        }
        return true;
    }
    public boolean insert(int index, int val) {
        if(index <0|| index > length){
            return false;
        }
        if(index==0){
            prepend(val);
            return true;
        }
        if (index==length){
            append(val);
            return true;
        }
        Node insert = new Node(val);
        Node temp = get(index-1);
        insert.next = temp.next;
        temp.next = insert;
        length++;
        return true;
    }
    public boolean remove(int index) {
        if(index<0||index>=length){
            return false;
        }
        if(index==0){
            removeFirst();
            return true;
        }
        Node temp = get(index-1);
        Node toRemove = temp.next;
        temp.next = toRemove.next;
        toRemove=null;
        length--;
        return true;
    }
    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node next = temp.next;
        Node before = null;
        for (int i = 0; i < length; i++) {
            next = temp.next;
            temp.next = before;
            before = temp;
            temp = next;
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
