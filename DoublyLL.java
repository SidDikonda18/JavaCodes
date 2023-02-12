public class DoublyLL{
    public class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void display(){
        Node temp=head;
        System.out.print("null -> ");
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println("null");

    }
    public void displayReverse(){
        Node temp=tail;
        System.out.print("null -> ");
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.prev;
        }
        System.out.println("null");
    }

    public void insert(int data){
        Node newNode =new Node(data);
        if(head==null){
            head= newNode;
            tail=newNode;
            size++;
        }
        else{
            Node temp=head;
            temp.prev=newNode;
            newNode.next=head;
            head = newNode;
            size++;
        }
    }

    public void insertEnd(int data){
        if(head==null){
            insert(data);
            return;
        }
        else{
            Node newNode=new Node(data);
            size++;
            tail.next=newNode;
            newNode.prev=tail;
            tail=tail.next;
        }
        return;
    }
    public void remove(){
        if (head==null){
            System.out.println("DLL is empty!!!!");
            return;
        }
        else{
            Node temp=head;
            temp.next.prev=null;
            head=temp.next;

        }
    }

    public void removeEnd(){
        if(head==null){
            System.out.println("DLL is empty!!!!");
            return;
        }
        else{
            Node temp=tail;
            tail=temp.prev;
            tail.next=null;
            temp.prev=null;
        }
        return;
    }


    public static void main(String args[]){
        DoublyLL dll=new DoublyLL();

        dll.insert(23);
        dll.insert(43);
        dll.insert(65);
        dll.insertEnd(90);
        dll.insert(12);

        dll.display();
        //dll.remove();
        dll.removeEnd();
        dll.display();
        dll.displayReverse();
    }
}