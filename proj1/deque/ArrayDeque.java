package deque;



public class ArrayDeque<Item> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private Item[] items;
    public int arrayCapacity;

    public ArrayDeque(){
        arrayCapacity=8;
        items = (Item[]) new Object[arrayCapacity];
        size = 0;
        nextFirst=4;
        nextLast=5;
    }

    public void addFirst(Item item){
        if(isFull()){
            resize(2*size);
        }

        items[nextFirst]=item;
        nextFirst-=1;
        nextFirst=(nextFirst+arrayCapacity)%arrayCapacity;
        size+=1;

    }

    public void addLast(Item item){
        if(isFull()){
            resize(2*size);
        }

        items[nextLast]=item;
        nextLast+=1;
        nextLast=nextLast%arrayCapacity;
        size+=1;


    }

    private boolean isFull() {
        if(size==items.length){
            return true;
        }
        return false;
    }

    private void resize(int capacity) {
        //
        Item[] a = (Item[]) new Object[capacity];
        if(capacity<arrayCapacity){
            System.arraycopy(items,nextFirst+1,a,0,size);
            items = a;

            this.nextFirst=capacity-1;
            this.nextLast=size;
            this.arrayCapacity=capacity;
        }
        else{
            System.arraycopy(items, nextFirst+1, a, 0, size-(nextFirst+1));
            System.arraycopy(items, 0, a, size-(nextFirst+1), nextFirst+1);
            items = a;

            this.nextFirst=capacity-1;
            this.nextLast=size;
            this.arrayCapacity=capacity;
        }

    }

    public Item removeLast(){

        if(isEmpty()){
            return null;
        }

        if(isUnder25Percent()){
            resize(arrayCapacity/2);
        }

        Item returnItem=items[nextLast-1];
        items[nextLast-1]=null;
        nextLast-=1;
        nextLast=nextLast%arrayCapacity;
        this.size-=1;
        
        return returnItem;
    }

    public Item removeFirst(){

        if(isEmpty()){
            return null;
        }

        if(isUnder25Percent()){
            resize(arrayCapacity/2);
        }

        Item returnItem=items[(nextFirst+1)%arrayCapacity];
        items[(nextFirst+1)%arrayCapacity]=null;
        nextFirst+=1;
        nextFirst=nextFirst%arrayCapacity;
        this.size-=1;

        return returnItem;
    }



    private boolean isUnder25Percent() {
        if(size<=0.25*arrayCapacity){
            return true;
        }
        return false;
    }

    public void printDeque(){
        //before resize
        for(int i=nextFirst+1;i<arrayCapacity;i++){
            System.out.print(items[i] + " ");
        }
        //for(int i=nextFirst+1;i<arrayCapacity)

        for(int i=0;i<=nextFirst;i++){
            if(items[i]==null){
                continue;
            }
            System.out.print(items[i] + " ");
        }

    }



    public boolean isEmpty(){
        if(this.size==0){
            return true;
        }
        return false;
    }

    public int size(){
        if(size<0){
            return 0;
        }
        return this.size;
    }

    public Item get(int index){

        if((index<0)|(index>arrayCapacity)){
            return null;
        }

//        int i=(nextFirst+1)%arrayCapacity;
//        while (i<index) {
//            i++;
//        }

        int i=(nextFirst+1+index)%arrayCapacity;
        return items[i];

    }



}
