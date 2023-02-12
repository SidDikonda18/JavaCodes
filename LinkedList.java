public class LinkedList{

    public class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void print(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+ " -> ");
            temp=temp.next;
        }
        System.out.println("null");
    }


    public void addFront(int data){
        // create the new node
        Node newNode=new Node(data);
        size++;
        if(head==null){ //if Linked list is empty
            head=tail=newNode;
            return;
        }

        //create the link
        newNode.next = head;

        // change the head to newnode
        head=newNode;
    }

    public void addEnd(int data){
        //create the neewNode
        Node newNode=new Node(data);
        size++;
        if(head==null){ //if Linked list is empty
            head=tail=newNode;
            return;
        }
        //setup the link 
        tail.next=newNode;

        // move the tail 
        tail=newNode;
    
    }

    public void addMiddle(int index, int data){
        if(index==0){
            addFront(data);
            return;
        }
        Node temp=head;
        int n=0;
        while(n<index-1){
            temp=temp.next;     // we will reach to the index-1 position 
            n++;
        }
        Node newNode= new Node(data);
        size++;
        newNode.next=temp.next;
        temp.next=newNode;
    }


    public int removeFirst(){
        if(size==0){
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int data=head.data;
            head=tail=null;
            size--;
            return data;
        }
        int data = head.data;
        head=head.next;
        size--;
        return data;
    }

    public int removeEnd(){
        if(size==0){
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int data=head.data;
            head=tail=null;
            size--;
            return data;
        }
        Node temp=head;
        while(temp.next!=tail){
            temp=temp.next;
        }
        int data = tail.data;
        tail=temp;
        tail.next=null;
        size--;
        return data;
    }

    public int removeMiddle(int index){
        if(size==0){
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int data=head.data;
            head=tail=null;
            size--;
            return data;
        }
        int ct=0;
        Node temp=head;
        while(ct<index-1){
            temp=temp.next;
            ct++;
        }

        int data=temp.next.data;
        temp.next=temp.next.next;
        size--;
        return data;
    }

    public int searchIterative(int key){
        Node temp=head;
        int i=0;
        while(temp!=null){
            if(temp.data == key){
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;
    }

    public int searchRecursive(Node head, int key){
        if(head==null){
            return -1;
        }
        else if(head.data == key){
            return 0;
        }
        int a=searchRecursive(head.next, key);
        if( a != -1){
            return a+1;
        }
        return -1;  

    }

    public Node reverseLL(Node head){
        Node prev, cur,nextt;
        prev=head;
        cur=prev.next;
        prev.next=null;

        tail=prev;
        //System.out.println("tail ="+tail.data);
        while(cur.next!=null){
            nextt=cur.next;
            cur.next=prev;
            prev=cur;
            cur=nextt;
        }
        cur.next=prev;
        head=cur;
        //System.out.println();
        return head;
    }

    public Node findMid(Node head){
        Node slow=head;
        Node fast = head.next;      // mid = last node of 1st half
        while(fast!=null && fast.next!=null){
            slow=slow.next; // step by 1 node
            fast=fast.next.next;    // step by 2 node
        }
        return slow;
    }

    public boolean palindrome(Node head){
        if(head==null || head.next==null )
            return true;

        // find mid
        Node mid= findMid(head);

        Node left=head;
        // reverse the 2nd half
        Node right=reverseLL(mid);

        while(right.next !=null){
            if(left.data!=right.data)
                return false;
            right=right.next;
            left=left.next; 
        }
        // print(left);
        // print(right);
        return true;
    }


    public boolean isCycle(Node head){
        Node slow=head;
        Node fast = head;

        while(fast.next!=null && fast.next.next != null){
            
            System.out.println("Slow: "+slow.data+" Fast : "+fast.data);
            fast=fast.next.next;
            slow= slow.next;
            if(fast==slow)
                return true;
        }
        
        return false;
    }

    public void createCycle(Node head, int ind){
        int n=0;
        Node temp=head;
        // go to that perticular index
        while(n<ind){
            temp=temp.next;
            n++;
        }
        // connect the last index to given index
        tail.next=temp;
        System.out.println(tail.next.data);
    }

    public void removeCycle(Node head){
         
        Node slow=head;
        Node fast = head;

        // detect the cycle
        while(fast.next!=null && fast.next.next != null){
            
            //System.out.println("Slow: "+slow.data+" Fast : "+fast.data);
            fast=fast.next.next;
            slow= slow.next;
            //find meeting point
            if(fast==slow){     
                slow=head;
                Node prev=null;
                // removing the cycle
                while(fast!=slow){
                    slow=slow.next;
                    prev=fast;
                    fast=fast.next;
                }
                prev.next=null;
            }
        }

        
    }

    public Node merge(Node newLeft, Node newRight){
        Node mergeLL= new Node(-1);
        Node temp=mergeLL;

        while(newLeft!=null && newRight!=null){
            if(newLeft.data <= newRight.data){
                temp.next=newLeft;
                newLeft= newLeft.next;
                temp=temp.next;
            }
            else{
                temp.next=newRight;
                newRight= newRight.next;
                temp=temp.next;
            }
        }
        
        if(newLeft!=null){
            temp.next = newLeft;
            temp= temp.next;
        }
        // print(mergeLL.next);
        if(newRight!=null){
            temp.next = newRight;
            temp= temp.next;
        }
        // print(mergeLL.next);
        // System.out.println("\n");
        return mergeLL.next;

    }

    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        // find mid
        Node mid= findMid(head);

        // left and right division
        Node rightHead = mid.next;
        mid.next=null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // merge the both left and right
        // print(newLeft);
        // print(newRight);
        // System.out.println("\n");
        return merge(newLeft, newRight);

    }



    public void zigZagLL(Node head){
        //find the mid 
        Node mid = findMid(head);
        
        //revers the 2nd half
        Node RH = reverseLL(mid.next);
        mid.next=null;
        Node LH = head;
        // print(LH);
        // print(RH);

        Node nextL, nextR;
        while(LH!= null && RH != null){

            nextL = LH.next;
            nextR = RH.next;

            //point left to right and right to left
            LH.next=RH;
            RH.next=nextL;

            // update pointer
            LH=nextL;
            RH=nextR;
        }
        // RH.next=null;

    }


    public static void main(String args[]){

        LinkedList ll = new LinkedList();
        ll.addFront(2);
        ll.addFront(55);
        ll.addFront(6);
        // //ll.print();
        ll.addEnd(10);
        ll.addEnd(4);
        ll.addEnd(73);
        ll.addEnd(23);
        ll.addEnd(48);
        ll.addEnd(90);
        // //ll.print();
        //ll.addMiddle(3, 9);
        // ll.print(head);
        //System.out.println(ll.removeFirst());
        //System.out.println(ll.removeEnd());
        //System.out.println(ll.removeMiddle(5));
        //ll.print();
        // System.out.println(ll.searchIterative(10));
        // System.out.println(ll.searchRecursive(head, 10));
        //head=ll.reverseLL(head);
        ll.print(head);
        // boolean a= ll.palindrome(head);
        // System.out.print(a);
        //System.out.println("Size of the LL : "+size);


        // head=new Node(1);
        // head.next=new Node(2);
        // head.next.next=new Node(3);
        // Node temp=head.next;    //node of 2
        // head.next.next.next=new Node(4);
        // head.next.next.next.next=temp; //1->2->3->4-
        //                                 // ^        |
        //                                 // |        |
        //                                 // |________| 
        //ll.createCycle(head, 2);
        //System.out.println(ll.isCycle(head));
        //ll.removeCycle(head);
        //head=ll.mergeSort(head);

        ll.zigZagLL(head);
        ll.print(head);
    }
}