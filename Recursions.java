import javax.sound.midi.VoiceStatus;

public class Recursions{

    public static void PrintNto1(int n){
        if(n==1){
            System.out.print(n);
            return;
        }
        System.out.print(n+" ");
        PrintNto1(n-1);
    }

    public static void Print1toN(int n){
        if(n==1){
            System.out.print(n+" ");
            return;
        }
        Print1toN(n-1);
        System.out.print(n+" ");
        
    }

    public static int factorial(int n){
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }

    public static int SumOfNaturalNumber(int n){
        //static int sum=0;
        if(n==1){
            return 1;
        }
        return n+SumOfNaturalNumber(n-1);
    }

    public static int fibonacci(int n ){
        if(n==0)
            return 0;
        else if (n==1)
            return 1;
        return fibonacci(n-1)+fibonacci(n-2);
    }

    public static boolean isSorted(int arr[], int i){
        if(i==arr.length-1)
            return true;
        if(arr[i] >arr[i+1])
            return false;
        
        return isSorted(arr, i+1);
    }

    public static int power(int x, int n){      //Optimized Power
        if(n==1)
            return x;
        if(n%2==0){
            return power(x, (int)n/2) * power(x, (int)n/2);
        }
        else{
            return x* power(x, (n)/2) * power(x, (int)(n)/2);
        }
    }


    public static int tilingProblem(int n){
        // base case
        if(n==0 || n==1)
            return 1;
        
        // vertical tiles
        int fnm1=tilingProblem(n-1);

        // horizontal tiles
        int fnm2 = tilingProblem(n-2);

        return fnm1+fnm2;
    }


    public static void removeDuplicates(String str, int index, StringBuilder newStr, boolean arr[]){
        // static String newStr = "";
        // static boolean arr[] = new boolean[26];

        if(index==str.length()){
            System.out.println(newStr);
            return;
        }
        char ch=str.charAt(index);
        if(arr[ch-'a']== true){
            removeDuplicates(str, index+1,newStr,arr);
        }
        else{
            arr[ch-'a']=true;
            removeDuplicates(str, index+1, newStr.append(ch), arr);
        }
    }
    public static void main(String args[]){

        // Print1toN(10);
        // System.out.println(factorial(5));
        // System.out.println(SumOfNaturalNumber(10));
        // System.out.println(fibonacci(8)) ;

        // int arr[]={2,4,6,89,8,9};
        // System.out.println(isSorted(arr, 0));
        // System.out.println(power(5, 8));

        boolean arr[]= new boolean[26];
        String str= "siddhesh";
        removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
    }
}