package deque;


public class LinkedListDeque<T> {
//    create LinkedListDeque
    private int size;
    BaseNode<T> sentinel;

    public static class BaseNode<T>{
        public T item;
        public BaseNode<T> next;
        public BaseNode<T> prev;

        public BaseNode(BaseNode<T> m, T i,BaseNode<T> n){
            prev=m;
            item=i;
            next=n;
        }
    }

    public LinkedListDeque(){
        size=0;
        sentinel = new BaseNode<T>(null, (T) "start1", null);
        sentinel.prev=sentinel;
        sentinel.next=sentinel;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        if(this.size==0){
            return true;
        }
        return false;
    }

    public void addFirst(T item){
        BaseNode<T> newNode= new BaseNode<T>(null, item, null);
        sentinel.next.prev=newNode;
        newNode.next=sentinel.next;

        sentinel.next=newNode;
        newNode.prev=sentinel;

        size+=1;
    }

    public void addLast(T item){
        //sentinel.prev points to the last node
        BaseNode<T> newNode= new BaseNode<>(null, item, null);
        sentinel.prev.next=newNode;
        newNode.prev=sentinel.prev;

        newNode.next=sentinel;
        sentinel.prev=newNode;

        size+=1;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line.
     */
    public void printDeque(){
        BaseNode<T> curr=sentinel.next;
        while(curr!=sentinel){
            System.out.println(curr.item + " ");
            curr=curr.next;
        }
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */

    public T removeFirst(){
        //remove sentinel.next
        if(this.size==0){
            return null;
        }

        T returnItem =sentinel.next.item;
        sentinel.next.next.prev=sentinel;
        sentinel.next=sentinel.next.next;
        size-=1;

        return returnItem;
    }

    public T removeLast(){
        //remove sentinel.prev
        if(this.size==0){
            return null;
        }

        T returnItem =sentinel.prev.item;
        sentinel.prev.prev.next=sentinel;
        sentinel.prev=sentinel.prev.prev;

        size-=1;

        return returnItem;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth. If no such item exists, returns null.
     * @param index
     * @return item value
     */
    public T get(int index){

        BaseNode<T> curr=sentinel.next;
        for(int i=0;i<index;i++){
            curr=curr.next;
        }
        return curr.item;
    }

    public T getRecursive(int index){

        return getRecursiveHelper(index,sentinel.next);

    }

    public T getRecursiveHelper(int i, BaseNode<T> pointer){
        if(i==0){
            return pointer.item;
        }
        return getRecursiveHelper(i-1,pointer.next);
    }








}
