import java.util.*;

public class Stacks{
    public static class StackA{

        static ArrayList<Integer> arrList = new ArrayList<>();

        //is Empty
        public  boolean isEmpty(){
            return arrList.size() ==0;
        }

        // Push
        public void push(int val){
            arrList.add(val);
        }

        //pop
        public  int pop(){
            int top= arrList.get(arrList.size()-1);
            arrList.remove(arrList.size()-1);
            return top;
        }

        //
        public int peek(){
            return arrList.get(arrList.size()-1);
        }


        public void pushAtEnd(int data){
            if(isEmpty()){
                push(data);
                return;
            }
            int val=pop();
            pushAtEnd(data);
            push(val);
            return;
        }

    }



    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next= null;
        }
    }
    static Node top;

    public static class StackB{
        public boolean isEmpty(){
            return top==null;
        }


        public void push(int data){
            Node newNode=new Node(data);
            if(top == null){
                top=newNode;
            }
            else{
                newNode.next=top;
                top= newNode;
            }
        }

        public int pop(){
            if(top == null ){
                System.out.println("Stack is empty ");
                return -1;
            }
            else{
                Node temp=top;
                top=temp.next;
                return temp.data;
            }
        }

        public int peek(){
            if(top ==null){
                System.out.println("Stack is empty ");
                return -1;
            }
            else{
                return top.data;
            }
        }

    }
    

    public static void reverseString(String str){
        Stack<Character> s=new Stack<>();
        int i=0;
        while(i<str.length()){
            s.push(str.charAt(i));
            i++;
        }
        StringBuilder st=new StringBuilder();
        while(!s.isEmpty()){
            st.append(s.pop());
        }
        System.out.println(st);
    }

    public static void pushatEnd(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int a=s.pop();
        pushatEnd(s, data);
        s.push(a);
    }

    public static void reverseStack(Stack<Integer> s){
        while(!s.isEmpty()){
            return;
        }
        int a=s.pop();
        reverseStack(s);
        pushatEnd(s, a);
        return;
    }

    public static void main(String args[]){
        // StackA s= new StackA();
        // s.push(23);
        // s.push(34);
        // s.push(56);
        // while(!s.isEmpty()){
        //         System.out.println(s.peek());
        //         s.pop();
        //     }
        // s.pushAtEnd(90);
        // System.out.println(s.arrList);
        // System.out.println(s.peek());


        // StackB s= new StackB();
        // s.push(23);
        // s.push(12);
        // s.push(98);
        // while(!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        // }


        // ****************** Collection framework ******************
        Stack<Integer> s= new Stack<>();        // no need of external decalration or any code dust make obj of Stack class which is already coded in framework
        s.push(23);
        s.push(12);
        s.push(98);
        s.push(76);
        s.push(29);
        s.push(65);
        //pushatEnd(s, 88);
        reverseStack(s);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }

        //reverseString("Siddhesh");




        
    }
}