import java.util.Scanner;

public class SmallestAndLargestNum{
    public static int smallestNumber(int arr[]){

        int small=Integer.MAX_VALUE;
        for(int i=0;i<10;i++){
            if(small>arr[i])
                small=arr[i];
        }
        return small;
    }

    public static int largestNumber(int arr[]){

        int large=Integer.MIN_VALUE;
        for(int i=0;i<10;i++){
            if(large<arr[i])
                large=arr[i];
        }
        return large;
    }


    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int[] arr=new int[10];
        for(int i=0;i<10;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("Entered numbers: ");
        for(int i=0;i<10;i++){
            System.out.print(arr[i]+" ");
        }

        System.out.println("Smallest Number from the list = "+smallestNumber(arr));
        System.out.println("Largest number from the list = "+largestNumber(arr));

        sc.close();
    }
}