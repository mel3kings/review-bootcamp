package algorithm.datastructures;

public class LinkedListNode{
    private String value;
    private LinkedListNode previous;
    private LinkedListNode next;

    public LinkedListNode getPrevious(){
        return this.previous;
    }

    public void setPrevious(LinkedListNode previous){
        this.previous = previous;
    }

    public void setNext(LinkedListNode next){
        this.next = next;
    }

    public LinkedListNode getNext(){
        return this.next;
    }

    public void setValue(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }


    public LinkedListNode getHead(){
        if(this.getPrevious() != null){
            return getPrevious().getHead();
        }else{
            return this;
        }
    }

}

