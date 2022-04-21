class MyHashSet {
    
	// Node class: stores values for linked lists
    private static final class Node {
        final int value;
        Node next;
        
        public Node(int val) {
            this.value = val;
            this.next = null;
        }
    }
    
	// The table stores the 50,000 buckets, each of which is a node (i.e linked list)
    private final Node[] table;
    private final int CAPACITY = 50000;

    public MyHashSet() {
        table = new Node[CAPACITY];
    }
    
	// To add, traverse through the nodes at the key's bucket (since the key is an integer, the hash
	// code is just (key % CAPACITY)) until that value is found (it already exists- don't add it again)
	// or the end of the list has been reached (add the value)
    public void add(int key) {
        Node curr = table[key % CAPACITY];
        
        if (curr == null) {
            table[key % CAPACITY] = new Node(key);
        } else {
            while (curr.next != null) {
                if (curr.value == key) return;
                curr = curr.next;
            }
            if (curr.value != key) {
                curr.next = new Node(key);
            }
        }
    }
    
	// To remove, the process is the same as above except we need the previous node to delete the current node
    public void remove(int key) {
        Node curr = table[key % CAPACITY];
        if (curr == null) return;
        if (curr.value == key) {
            table[key % CAPACITY] = curr.next;
            return;
        }
        Node prev = null;
        
        while (curr.next != null) {
            if (curr.value == key) {
                prev.next = curr.next;
            }
            prev = curr;
            curr = curr.next;
        }
    }
    
	// To find the value, traverse through the nodes at the key's bucket
    public boolean contains(int key) {
        Node curr = table[key % CAPACITY];
        
        while (curr != null) {
            if (curr.value == key) return true;
            curr = curr.next;
        }
        return false;
    }
    
}