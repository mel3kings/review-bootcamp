package algorithm.datastructures;

/**
 * Simple hash table using length as the hash
 */
public class HashTable {

    private static final int INITIAL_SIZE=16;
    private static HashNode[] table = new HashNode[INITIAL_SIZE];

    public static void main(String[] args){
        HashTable t = new HashTable();
        t.add("one" , "1");
        t.add("three", "3");
        t.add("four", "4");
        t.add("two", "2");

        HashNode getter = t.get("two");
        System.out.println(getter.getValue());
    }

    public void add(String key, String value){
        int index = hash(key);
        if(null == table[index]){
            table[index] = new HashNode(key, value);
        }else{
            HashNode current = table[index];
            HashNode last = null;
            while(current != null){
                last = current;
                current = current.getNext();
            }
            last.setNext(new HashNode(key, value));
        }
    }

    public HashNode get(String key){
        int index = hash(key);
        HashNode current = table[index];
        while(current.getKey() != key && current != null){
            current = current.getNext();
        }
        return current;
    }

    public int hash(String key){
        return key.length();
    }

}

class HashNode{
    private String key;
    private String value;
    private HashNode next;

    public HashNode(String key, String value){
        this.key = key;
        this.value = value;
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public HashNode getNext() {
        return next;
    }

    public void setNext(HashNode next) {
        this.next = next;
    }
}

