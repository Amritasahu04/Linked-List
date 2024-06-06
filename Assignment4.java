import java.util.*;
class Node{
    protected int regd_no;
    protected float mark;
    protected Node next;

    Node(int regd_no, float mark){
        this.regd_no = regd_no;
        this.mark = mark;
        this.next = null;
    }
}

public class Assignment4{
    //Creation:-
    public static Node create(Node start) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter registration number: ");
        int regd_no = sc.nextInt();
        System.out.print("Enter marks: ");
        float mark = sc.nextFloat();
        start = new Node(regd_no, mark);
        return start;
    }

    //Displaying all the nodes in the list
    public static void display(Node start){
        Node curr = start;
        while(curr != null){
            System.out.println("Regd No.: " + curr.regd_no + " Mark:" + curr.mark);
            curr = curr.next;
        }
    }

    //The insertion operation at the beginning of the list
    public static Node InsBeg(Node start){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the registration Number: ");
        int regd_no = sc.nextInt();

        System.out.print("Enter the marks secured: ");
        float mark = sc.nextFloat();

        Node newNode = new Node(regd_no, mark);

        if(start == null){
            start = newNode;
        }else {
            newNode.next = start;
            start = newNode;
            System.out.println("Node inserted in the beginning");
        }
        return start;
    }

    //The insertion operation at the end of the list
    public static Node InsEnd(Node start){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the registration Number: ");
        int regd_no = sc.nextInt();

        System.out.print("Enter the marks secured: ");
        float mark = sc.nextFloat();

        Node newNode = new Node(regd_no, mark);

        if(start == null){
            start = newNode;
        }else{
            Node currNode = start;
            while(currNode.next != null){
                currNode = currNode.next;
            }
            currNode.next = newNode;
        }
        System.out.println("Node inserted in the end of the list");
        return start;
    }

    //The insertion operation at any position of the list
    public static Node InsAny(Node start){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the registration Number: ");
        int regd_no = sc.nextInt();

        System.out.print("Enter the marks secured: ");
        float mark = sc.nextFloat();

        System.out.print("Enter position to insert: ");
        int position = sc.nextInt();
        
        Node newNode = new Node(regd_no, mark);

        if(position == 1){
            newNode.next = start;
            start = newNode;
        }else{
            Node currNode = start;
            for(int i = 1; i < position -1 && currNode!= null; i++){
                currNode = currNode.next;
            }
            if(currNode != null){
                newNode.next = currNode.next;
                currNode.next = newNode;
            }
        }
        System.out.println("Node inserted at position " + position + ".");
        return start;
    }

    //The deletion operation From the beginning of the list
    public static Node DelBeg(Node start){
        if(start == null){
            System.out.println("List is empty, no node to delete!");
        }else{
            start = start.next;
            System.out.println("Node deleted from the beginning!");
        }
        return start;
    }
    
    //The deletion operation From the end of the list
    public static Node DelEnd(Node start){
        if(start == null){
            System.out.println("List is empty, no node to delete!");
        }else{
            Node secondLast = start;
            Node lastNode = start.next;

            while(lastNode.next != null){
                lastNode = lastNode.next;
                secondLast = secondLast.next;
            }
            System.out.println("Node deleted from the end!");
        }
        return start;
    }

    //The deletion operation From any position in the list
    public static Node DelAny(Node start){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter position of the Node to be deleted: ");
        int position = sc.nextInt();

        if(start == null){
            System.out.println("List is empty, no node to delete!");
        }
        if(position == 1){
            start = start.next;
            System.out.println("Node with positon " + position + " deleted!");
        }else{
            Node currNode = start;
            for(int i = 1; i < position -1 && currNode!= null; i++){
                currNode = currNode.next;
            }
            if(currNode == null || currNode.next == null){
                System.out.println("Position out of Range.");
            }
            currNode.next = currNode.next.next;
        }
        return start;
    }

    //The deletion operation by regd number
    public static Node DelByRegdNo(Node start){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Registration Number of the Node to be deleted: ");
        int regd_no = sc.nextInt();

        if(start == null){
            System.out.println("List is empty, no node to delete!");
        }else{
            if(start.regd_no == regd_no){
                start = start.next;
                System.out.println("Node with Registration Number " + regd_no + " deleted!");
            }else{
                Node currNode = start;
                Node prevNode = null;

                while(currNode != null && currNode.regd_no != regd_no){
                    prevNode = currNode;
                    currNode = currNode.next;
                }

                if(currNode == null){
                    System.out.println("Node with the Registration Number " + regd_no + " is not found.");
                }else{
                    prevNode.next = currNode.next;
                    System.out.println("Node with the Registration Number " + regd_no + " deleted.");
                }
            }
        }
        return start;
    }

    // Search a node based on student regd_no and update the mark of the student
    public static void search(Node start){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Registration Number to search: ");
        int regd_no = sc.nextInt();

        Node currNode = start;

        while(currNode != null && currNode.regd_no == regd_no){
            currNode = currNode.next;
        }

        if(currNode == null){
            System.out.println("Node with Registration Number " + regd_no + " not fount!");
        }else{
            System.out.println("Enter new Marks: ");
            float mark = sc.nextFloat();
            currNode.mark = mark;
            System.out.println("Node Updated");
        }
    }

    //Sort the nodes of the linked list according to the mark secured by the student from higher to lower.
    public static void sort(Node start){
        if(start == null || start.next == null){
            return;
        }
        Node currNode = start, index = null;
        Float tempMark; int tempRegd_no;

        while (currNode != null) {
            index = currNode.next;
            while(index != null){
                if(currNode.mark < index.mark){
                    tempMark = currNode.mark;
                    tempRegd_no = currNode.regd_no;
                    currNode.mark = index.mark;
                    currNode.regd_no = index.regd_no;
                    index.mark = tempMark;
                    index.regd_no = tempRegd_no;
                }
                index = index.next;
            }
            currNode = currNode.next;
        }
    }

    //Count the number of nodes present in the linked list
    public static int count(Node start){
        int count = 0;
        Node curr = start;
        while(curr != null){
            count++;
            curr = curr.next;
        }
        return count;
    }

    //Reverse the linked list
    public static Node reverse(Node start){
        Node prevNode = null;
        Node currNode = start;
        Node nextNode = null;
        // 1 -> 2 -> 3 -> 4 :: 1 <- 2 <- 3 <- 4
        while(currNode != null){
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        start = prevNode;
        return start;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Node start = null;
        while(true){
            System.out.println("****MENU*****");
            System.out.println("0:Exit");
            System.out.println("1:Creation");
            System.out.println("2:Display");
            System.out.println("3: Insert at Beginning");
            System.out.println("4: Insert at End");
            System.out.println("5: Insert at Any position");
            System.out.println("6: Delete from Beginning");
            System.out.println("7: Delete from End");
            System.out.println("8: Delete from Any position");
            System.out.println("9: Delete by Registration number");
            System.out.println("10: Search & update");
            System.out.println("11: Sort by Marks");
            System.out.println("12: Count Nodes");
            System.out.println("13: Reverse list");

            System.out.println("Enter the choice");
            int choice=sc.nextInt();

            switch(choice){
                case 0:
                    System.exit(0);
                case 1:
                    create(start);
                    break;
                case 2:
                    display(start);
                    break;
                case 3:
                    InsBeg(start);
                    break;
                case 4:
                    InsEnd(start);
                    break;
                case 5:
                    InsAny(start);
                    break;
                case 6:
                    DelBeg(start);
                    break;
                case 7:
                    DelEnd(start);
                    break;
                case 8:
                    DelAny(start);
                    break;
                case 9:
                    DelByRegdNo(start);
                    break;
                case 10:
                    search(start);
                    break;
                case 11:
                    sort(start);
                    break;
                case 12:
                    System.out.println("Number of Nodes: " + count(start));
                    break;
                case 13:
                    create(start);
                    break;
                case 14:
                    reverse(start);
                    break;
                default:
                System.out.println("Wrong choice");
            }
        }
    }
}
