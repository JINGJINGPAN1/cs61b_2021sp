package deque;

public class MaxArrayDeque< T extends Comparable<T> >extends ArrayDeque<T>{
    private T maxItem;

    @Override
    public void addFirst(T item){
        super.addFirst(item);
        if(maxItem == null || item.compareTo(maxItem) > 0){
            maxItem = item;
        }
    }

    @Override
    public void addLast(T item) {
        super.addLast(item);
        if(maxItem == null || item.compareTo(maxItem) > 0){
            maxItem = item;
        }
    }

    @Override
    public T removeFirst(){
        T removed = super.removeFirst();
        if(removed != null && removed.compareTo(maxItem) > 0){
            updateMaxItem();
        }
        return removed;
    }

    @Override
    public T removeLast(){
        T removed = super.removeLast();
        if(removed != null && removed.compareTo(maxItem) > 0){
            updateMaxItem();
        }
        return removed;
    }

    public void updateMaxItem(){
        for(int i = 0; i < size(); i++){
            T item = get(i);
            if(maxItem == null || item.compareTo(maxItem) > 0){
                maxItem = item;
            }

        }
    }

    public T getMaxItem(){
        return maxItem;
    }

}
