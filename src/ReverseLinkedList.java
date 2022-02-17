  // --------- Reverse Singly LinkedList --------------

public class ReverseLinkedList {
    Node head;
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

        // ---- add in LinkedList -------
        public void add(Node newNode){
            if(head == null){
                head = newNode;
                return;
            }
            Node temp = head;
            while(temp.next != null){
                temp= temp.next;
            }
            temp.next = newNode;
        }


    // --- Reverse by iterative method ----------
    public void revIterate(){
        if(head == null || head.next == null){
            return;
        }
        Node prevNode = head;
        Node currNode = head.next;
        while(currNode != null){
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            // --- update ---
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }

    // ------- Recursive method to reverse linked list
    public Node recursiveReverse(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node newHead = recursiveReverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
     }

     // --- display ----
    public void display(){
        if(head == null){
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while(temp!= null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // ------------------- Driver Code --------------------
    public static void main(String[] args) {
        ReverseLinkedList obj = new ReverseLinkedList();
        obj.add(new Node(1));
        obj.add(new Node(2));
        obj.add(new Node(3));
        obj.add(new Node(4));
        obj.display();

        obj.head = obj.recursiveReverse(obj.head);
        obj.display();

        obj.revIterate();
        obj.display();
    }
}
