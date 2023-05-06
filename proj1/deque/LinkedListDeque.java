package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private class DoublyNode{
        public DoublyNode prev;
        public DoublyNode next;
        private T item;

        private DoublyNode(DoublyNode p, T i, DoublyNode n){
            prev = p;
            item = i;
            next = n;
        }
    }

    int size;
    DoublyNode sentFront;
    DoublyNode sentBack;

    public LinkedListDeque(){
        int size = 0;
        sentFront = new DoublyNode(null, null, null);
        sentBack = new DoublyNode(null,null,null);
        sentFront.next = sentBack;
        sentBack.prev = sentFront;
    }

    public void addFirst(T item){
        size += 1;
        DoublyNode currentNode = sentFront.next;
        DoublyNode newNode = new DoublyNode(sentFront,item,currentNode);
        sentFront.next = newNode;
        currentNode.prev = newNode;
    }

    @Override
    public void addLast(T item) {
        size += 1;
        DoublyNode currentNode = sentBack.prev;
        DoublyNode newNode = new DoublyNode(currentNode,item,sentBack);
        sentBack.prev = newNode;
        currentNode.next = newNode;


    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void printDeque() {
        DoublyNode dn = sentFront.next;
        while(dn != sentBack){
            System.out.println(dn.item);
            dn = dn.next;
        }
        System.out.println("\n");


    }
    @Override
    public T removeFirst() {
        if(size == 0){
            return null;
        }
        size -= 1;
        DoublyNode currentNode = sentFront.next;
        sentFront.next = currentNode.next;
        currentNode.next.prev = sentFront;
        return currentNode.item;
    }

    @Override
    public T removeLast() {
        if(size == 0){
            return null;
        }
        size -= 1;
        DoublyNode currentNode = sentBack.prev;
        sentBack.prev = currentNode.prev;
        currentNode.prev.next = sentBack;
        return currentNode.item;
    }

    @Override
    public T get(int index) {
        DoublyNode pd = sentFront.next;
        if(index + 1 > size){
            return null;
        }
        int i = 0;
        while(i < index){
            i++;
            pd = pd.next;
        }
        return pd.item;
    }
    private DoublyNode getNode(DoublyNode current, int index){
        if (index==0){
            return current.next;
        }
        current = getNode(current.next, index-1);
        return current;
    }
    public T getRecursive(int index){
        if (index+1>size){
            return null;
        }
        return getNode(sentFront, index).item;


    }
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }
    private class LinkedListIterator implements Iterator<T> {
        private int wizPos;
        private LinkedListIterator() {
            wizPos = 0;
        }

        public boolean hasNext() {
            return wizPos < size;
        }

        public T next() {
            T item = get(wizPos);
            wizPos += 1;
            return item;
        }
    }
    public boolean equals(Object o){
        if(this== o){
            return true;
        }
        if(o == null){
            return false;
        }
        if(!(o instanceof Deque)){
            return false;
        }

        Deque<T> ol = (Deque<T>) o;
        if(ol.size() != this.size()){
            return false;
        }

        for(int i = 0; i < size; i++){
            return false;
        }
        return true;
    }


    public void addIsEmptySize() {

    }

    public void addRemove() {

    }

    public void removeEmpty() {

    }

    public void multipleParam() {

    }

    public void emptyNullReturn() {

    }

    public void bigLLDeque() {

    }


}
