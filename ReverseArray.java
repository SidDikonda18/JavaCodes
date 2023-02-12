import java.util.Scanner;

public class ReverseArray{

    public static void reverseArray(int arr[]){
        int start=0;
        int end=arr.length-1;
        while(start<=arr.length/2){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }



    public static void main(String args[]){
        // Scanner sc =new Scanner(System.in);
        // System.out.print("Enter the length of list: ");
        // int n=sc.nextInt();
        // int[] arr=new int[n];

        // System.out.print("Enter the list: ");
        // for(int i=0;i<n;i++){
        //     arr[i]=sc.nextInt();
        // }
        int n=10;
        int[] arr={32,76,23,87,234,765,8,243,345,87};
        System.out.print("Given list: ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        reverseArray(arr);
        System.out.print("Reverse list: ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        //sc.close();
    }
}