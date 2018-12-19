package algorithm.datastructures;

/**
 * Simple HashTable with chaining implementation
 */
public class HashTableChaining {

    private static final int INITIAL_SIZE = 26;
    private static HashNode[] contents = new HashNode[INITIAL_SIZE];

    public static void main(String[] args) {
        HashTableChaining table = new HashTableChaining();
        table.put("abc", "3");
        table.put("def", "3");
        table.put("a", "1");
        System.out.println(contents);

        HashNode node = table.get("def");
        assert (node.getKey().equals("def"));
    }

    public HashNode get(String key) {
        int index = hash(key);
        HashNode fetchNode = contents[index];
        while (!key.equals(fetchNode.getKey()) && fetchNode.getNext() != null) {
            fetchNode = fetchNode.getNext();
        }
        return fetchNode;
    }

    public void put(String key, String value) {
        int index = hash(key);
        HashNode currentNode = contents[index];
        if (null != currentNode) {
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            HashNode newNode = new HashTableChaining().new HashNode(); // ideally should be a different class
            newNode.setKey(key);
            newNode.setValue(value);
            currentNode.setNext(newNode);
        } else {
            currentNode = new HashTableChaining().new HashNode();
            currentNode.setKey(key);
            currentNode.setValue(value);
            contents[index] = currentNode;
        }
    }

    /**
     * Not an ideally hashing mechanism, using length temporarily
     */
    public static int hash(String word) {
        return word.length();
    }

    class HashNode {
        private String key;
        private String value;
        private HashNode next;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public HashNode getNext() {
            return next;
        }

        public void setNext(HashNode next) {
            this.next = next;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}

