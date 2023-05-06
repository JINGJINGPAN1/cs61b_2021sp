package deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayDeque<T>  {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 0;
        size = 0;
    }

    public void addFirst(T item){
        if(size == items.length){
            resize(size * 2);
        }
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        items[nextFirst] = item;
        size ++;

    }

    public void addLast(T item){
        if(size == items.length){
            resize(size * 2);
        }
        nextLast = (nextLast + 1 % items.length) % items.length;
        items[nextLast] = item;
        size ++;

    }

    public boolean isEmpty(){

        return size == 0;
    }

    public int size(){

        return size;
    }

    public void printDeque(){
        for(int i = 0; i < items.length; i++){
            System.out.print(items[(nextFirst + i) % nextFirst] + " ");
        }
        System.out.println();
    }



    public void resize(int capacity){
        T[] newItems = (T[]) new Object[capacity];
        int oldSize = size;
        for(int i = 0; i < oldSize; i++){
            newItems[i] = items[(nextFirst + i) % nextFirst];
        }
        items = newItems;
        nextFirst = 0;
        nextLast = oldSize;
    }

    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        T item = items[nextFirst];
        items[nextFirst] = null;
        nextFirst = (nextFirst + 1) % items.length;
        size --;
        if(size > 0 && size < items.length / 4){
            resize(items.length / 2);
        }
        return item;

    }

    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        T item =  items[nextLast];
        items[nextLast] = null;
        nextLast = (nextLast + 1) % items.length;
        size --;

        if(size > 0 && size < items.length /4){
            resize(items.length/2);
        }
        return item;

    }

    public T get(int index){
        if(index > size || size < 0){
            return null;
        }
        return items[(nextFirst + index) % items.length];
    }

    public T getFirst(){
        if(isEmpty()){
            throw new NoSuchElementException("Deque is empty");
        }
        return items[nextFirst];
    }
}
