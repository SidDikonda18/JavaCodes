public class PairsArray{
    public static void pairs(int arr[]){
        for (int i=0;i<arr.length;i++){
            int temp=arr[i];
            for(int j=i+1;j<arr.length;j++){
                System.out.print("("+temp+", "+arr[j]+"), ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int[] arr={23,45,54,22,45};
        pairs(arr);
    }
}