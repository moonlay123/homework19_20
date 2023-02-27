import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T>{
    private int size;
    private Node head;
    private Node tail;
    public void add(T data){
        Node newNode = new Node(data);
        if(size == 0){
            head = newNode;
            tail = head;
        }else {
            tail.next = newNode;
        }
        size++;
    }
    public void addLast(T data){
        add(data);
    }
    public void addFirst(T data){
        if(isEmpty()){
            add(data);
            return;
        }
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

    }
    private void checkIndex(int index){
        if(index<0 || index >=size) throw new IndexOutOfBoundsException("Index: "+index+" size: "+size);
    }
    public void add(int index, T data){
        checkIndex(index);
        if(index==0){
            addFirst(data);
            return;
        }
        else if(index==size-1) {
            addLast(data);
            return;
        }
        Node cursor = head;
        Node previous = head;
        for(int i = 0;i<index;i++){
            previous = cursor;
            cursor = cursor.next;
        }
        Node newNode = new Node(data);
        previous.next=newNode;
        newNode.next=cursor;
    }
    public T get(int index){
        checkIndex(index);
        Node cursor = head;
        for(int i=0;i<index;i++) cursor = cursor.next;
        return cursor.data;
    }
    public T getFirst(){
        return head.data;
    }
    public T getLast(){
        return get(size-1);
    }
    public T remove(int index){
        checkIndex(index);
        Node removed=null;
        if(index == 0){
            removed = head;
            head = head.next;
        }
        Node cursor = head;
        Node previous = head;
        for(int i =0;i<index;i++){
            previous = cursor;
            cursor = cursor.next;
        }
        removed = cursor;
        if(index == size -1){
            previous.next = null;
            tail = previous;
        }else{
            previous.next = cursor.next;
        }

        size--;
        return removed.data;
    }
    public int size(){return size;}
    public boolean isEmpty(){
        return size==0;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }
    class MyListIterator implements Iterator<T>{
        Node cursor = head;
        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public T next() {
            Node current = cursor;
            cursor = cursor.next;
            return cursor.data;
        }
    }
    private class Node {
        T data;
        Node next = null;
        public Node(T data){
            this.data = data;
        }
    }
}
