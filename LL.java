class LL{
    Node head;
    private int size;

    LL(){
        this.size = 0;
    }
    class Node{
        String data;
        Node next;
    
        Node(String data){
            this.data = data;
            this.next = null;
            size++;
        }
    
    }
    //add-First
    public void addFirst(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    //add-Last
    public void addLast(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = newNode;

    }

    //print
    public void printList(){
        Node currNode = head;
        if(head == null){
            System.out.println("list is empty!");
            return;
        }
        while(currNode != null){
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    //Delete-First
    public void deleteFirst(){
        if(head == null){
            System.out.println("list is empty!");
            return;
        }
        size--;
        head = head.next;
    }

    //Delete-last
    public void deleteLast(){
        if(head == null){
            System.out.println("list is empty!");
            return;
        }
        size--; //fixed position, cannot be written anywhere else.
        if(head.next == null){
            head = null;
            return;
        }
        Node secondLast = head;
        Node lastNode = head.next;
        while(lastNode.next != null){
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
    }
    //get-Size
    public int getSize(){
        return size;
    }
    public static void main(String[] args) {
        LL list = new LL();
        list.addFirst("Amrita");
        list.addFirst("Sahu");
        list.printList();
        System.out.println("Size of the list is: " + list.getSize());
    }
}
