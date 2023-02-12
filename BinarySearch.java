import java.util.*;

import javax.lang.model.util.ElementScanner14;
import javax.sound.midi.Soundbank;

public class BinarySearch{

    public static int binarySearch(int list[], int key){
        int first=0;
        int last=list.length-1;
        while(first<=last){
            int mid=(first+last)/2;
            if(list[mid]==key)
                return mid;
            else if(key> list[mid])
                first=mid+1;
            else
                last=mid-1;
        }
        return -1;
    }

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the size of list: ");
        int n=sc.nextInt();
        int[] list=new int[n];
        System.out.print("Please Enter the "+n+" numbers (sorted or unsorted): ");
        for(int i=0;i<n;i++){
            list[i]=sc.nextInt();
        }
        Arrays.sort(list);
        System.out.print("Sorted List is: ");
        for(int i=0;i<n;i++){
            System.out.print(list[i]+" ");
        }

        System.out.println("Please enter the KEY to be search: ");
        int key=sc.nextInt();
        int ind=binarySearch(list, key)+1;
        if(ind==0){
            System.out.println("Number is not present in list :(");
        }
        else
            System.out.println("Key is present at "+ind+" position");


        


    }
}