public class TrappingRainwater{

    public static void trappedWater(int arr[]){
        int volume=0;

        int rightMax[]=new int[arr.length];  //stores the max wall of right side
        int leftMax[]=new int[arr.length];   // stores the max wall of left side
        //int rmax=0,lmax=0;
        leftMax[0]=arr[0];  //initializing the 1st leftmax as there is no left wall of 1st wall same for below
        rightMax[arr.length-1]=arr[arr.length-1];
        for(int i=1;i<arr.length;i++)
            leftMax[i]=Math.min(arr[i], leftMax[i-1]);
            //leftMax[i]=leftMax[i-1]<arr[i]?arr[i]:leftMax[i-1];
        
        for(int i=arr.length-2;i>=0;i--)
            rightMax[i]=rightMax[i+1]<arr[i]?arr[i]:rightMax[i+1];
        

        for(int i=0;i<arr.length-1;i++){
            // int lmax=arr[i],rmax=arr[i];
            // int lmaxindx,rmaxindx;
            // for(int j=i-1;j>=0;j--){
            //     if(arr[j]>lmax)
            //         lmax=arr[j];
            //         lmaxindx=j;
            // }
            // for(int j=i+1;j<arr.length;j++){
            //     if(arr[j]>rmax)
            //         rmax=arr[j];
            //         rmaxindx=j;
            // }
            // int waterlevel=Math.min(lmax, rmax);
            // int a= waterlevel-arr[i];
            // System.out.print(a+", ");
            // volume=volume+waterlevel-arr[i];
            int WaterArea = Math.min(leftMax[i], rightMax[i])-arr[i];
            System.out.print(WaterArea+" ");
            volume=volume+WaterArea;


        }
        System.out.println();
        System.out.println("volume= "+volume);
    }

    public static void main(String[] args){
        int arr[] = {4,2,0,6,3,2,5};
        trappedWater(arr);
    }
}