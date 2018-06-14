package algorithm.datastructures;

public class Queue {
    private static int rear = -1, front =0, size=0;
    private String[] data;

    public Queue(int size){
        data = new String[size];
    }

    public void insert(String value){
        data[++rear] = value;
        size++;
    }

    public String remove(){
        size--;
        return data[front++];
    }

    public String peekFront(){
        return data[front];
    }
    public String peekRear(){
        return data[rear];
    }

    public static void main(String[] args){
        Queue customers = new Queue(5);
        customers.insert("Old Lady");
        customers.insert("Young Man");
        customers.insert("Engineer");
        customers.insert("Banker");
        System.out.println("Next Customer to be procaessed : " + customers.remove());
        System.out.println("Next Customer to be processed : " + customers.remove());
        customers.insert("Late College Kid");
        System.out.println("Next in line is: "+ customers.peekFront());
        System.out.println("Last in line is: "+ customers.peekRear());
        System.out.println("Next Customer to be processed : " + customers.remove());
        System.out.println("Next Customer to be processed : " + customers.remove());
        System.out.println("Next Customer to be processed : " + customers.remove());
    }
}
