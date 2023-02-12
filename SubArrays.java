import javax.sound.midi.Soundbank;

public class SubArrays{
    public static void subarrayMaxMin(int arr[]){   // Normal Method
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int sum=0;
        for (int i=0;i<arr.length;i++){
            //int start=i;
            for(int j=i;j<arr.length;j++){
                //int end=j;
                sum=0;
                //System.out.print("[");
                //for(int k=start;k<=end;k++)
                for (int k=i;k<=j;k++){
                    //System.out.print(arr[k]+" ");
                    sum= sum+arr[k];
                }
                if(sum<min)
                    min=sum;
                if(sum>max)
                    max=sum;
                //System.out.print("] => "+sum+"\t");
            }
            //System.out.println();
        }
        System.out.println("Using Normal Method :");
        System.out.println("Min: "+min+"\nMax: "+max);
    }



    public static void MaxSubarraySum(int arr[]){

        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        int minSum=Integer.MAX_VALUE;
        int prefixArr[]=new int[arr.length];
        prefixArr[0]=arr[0];
        for(int i=1;i<prefixArr.length;i++)
            prefixArr[i]=arr[i]+prefixArr[i-1];

        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                currSum= i==0 ? prefixArr[j] : prefixArr[j]-prefixArr[i-1];

                if(currSum>maxSum)
                    maxSum=currSum;
                if(currSum<minSum)
                    minSum=currSum;
            }
        }
        System.out.println("\nUsing Prefix Array Method : ");
        System.out.println("Maximum Sum of Subarray is : "+maxSum);
        System.out.println("Minimum Sum of Subarray is : "+minSum);
    }


    public static void kadanesAlgo(int arr[]){
        int currSum=0;
        int maxSum1=Integer.MIN_VALUE;
        //int minSum= Integer.MAX_VALUE;

        for(int i=0;i<arr.length;i++){
            currSum=currSum+arr[i];
            if(currSum<0)
                currSum=0;
            // if(currSum>maxSum1)
            //     maxSum1=currSum;
            maxSum1=Math.max(maxSum1, currSum);
        }
        System.out.println("\nUsing Kadane's Algorithm: ");
        System.out.println("maximum Subarray Sum by Kadane's Algorithm : "+maxSum1);
    }


    public static void main(String args[]){
        int[] arr={-2, -3, 4, -1, -2, 1, 5, -3};
        subarrayMaxMin(arr);  //Normal Method with O(n^3) Time complexity

        MaxSubarraySum(arr); //Using Prefix sum O(n^2) Time Complexity

        kadanesAlgo(arr); //Using kadabe's Algo O(n) Time complexity
    }
}