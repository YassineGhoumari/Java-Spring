class SinglyLinkedList {
    
    public Node head;

    public SinglyLinkedList() {
        head = null;
    }

    public void add(Integer value) {
        Node node = new Node(value);
        
        if (head == null) {
            head = node;
        } else {
            Node pointer = head;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = new Node(value);
        }
    }

    public void remove() {
        if (head == null) {
        } else {
            Node pointer = head;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer = null;
        }
    }

    public void printValues() {
        if (head == null) {
        } else {
            Node pointer = head;
            while (pointer != null) {
                System.out.println(pointer.value);
                pointer = pointer.next;
            }
        }
    }
    
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove();
        list.printValues();
    }
}
