    //-----------Doubly LinkedList contains - data value,Node next and Node previous for going forward and backward-----------

    class Node1
    {
        int data;
        Node1 next;
        Node1 previous;
        Node1(int data){
            this.data = data;
        }
    }

    public class DoublyLinkedList {
        Node1 head;
    // -------------inserting node at first ------------------
    public void insertAtFirst(Node1 newNode){
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head.previous = newNode;
        head = newNode;
    }

    //-----------inserting node at last---------------
        public void insertAtLast(Node1 newNode){
            if(head == null) {
                head = newNode;
                return;
            }
            Node1 temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.previous = temp;
        }

        //----------inserting at specific position-------------------
        public void insertAtPosition(int pos, Node1 newNode)
        {
            Node1 temp = head;
            for(int i=0; i<pos-1 ;i++){
                temp= temp.next;
            }
            Node1 temp2 = temp.next;
            newNode.next = temp.next;
            temp.next = newNode;
            newNode.previous = temp;
            temp2.previous = newNode;

        }

       // -------------deleting the node from beginning---------
       public void deleteFromBeginning(){
           if(head == null){
               System.out.println("List is empty.");
               return;
           }
           head = head.next;
           head.previous = null;
       }

    // --------------displaying the LinkedList---------------
        public void display() {
            if(head == null){
                System.out.println("List is empty.");
                return;
            }
            Node1 temp = head;
            System.out.println("----------LinkedList elements are-------");
            while(temp != null){
                System.out.println(temp.data);
                temp = temp.next;
            }
        }

        //---------------displaying the reverse LinkedList--------------------
        public void reverseDisplay(){
            if(head == null){
                System.out.println("List is empty.");
                return;
            }
            Node1 temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            System.out.println("---------LinkedList in reverse order--------------");
            while(temp != null) {
                System.out.println(temp.data);
                temp = temp.previous;
            }
    }

    //------------Driver Code-------------
    public static void main(String[] args) {
        DoublyLinkedList obj = new DoublyLinkedList();
        obj.insertAtFirst(new Node1(12));
        obj.insertAtFirst(new Node1(10));
        obj.insertAtLast(new Node1(14));
        obj.display();

        obj.reverseDisplay();

        obj.insertAtPosition(2,new Node1(100));
        obj.display();
        obj.reverseDisplay();

        obj.deleteFromBeginning();
        obj.display();
    }
}
