package deque;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class MaxArrayDeque1<T> extends ArrayDeque<T> {
    private Comparator<T> comparator;
    public MaxArrayDeque1() {
        super();
        comparator = null;
    }
    public MaxArrayDeque1(Comparator<T> c) {
        super();
        comparator = c;
    }

    public T max(){
        if(isEmpty()){
            return null;
        }
        T max = getFirst();
        for(T item: this){
            if(comparator.compare(item,max) > 0){
                max = item;

            }
        }
        return max;

    }
    public T max(Comparator<T> c) {
        if(isEmpty()){
            return null;
        }
        T max = getFirst();
        for(T item: this){
            if(c.compare(item, max) > 0){
                max = item;
            }
        }
        return max;
    }
}
