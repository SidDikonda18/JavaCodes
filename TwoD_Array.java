import java.util.Scanner;

public class TwoD_Array{

    public static void spiral(int arr[][]){
        int startCol=0,startRow=0;
        int endRow=arr.length-1,endCol=arr[0].length-1;

        while(startCol<=endCol && startRow<=endRow){
            //top
            for(int i=startCol;i<=endCol;i++)
                System.out.print(arr[startRow][i]+" ");
            
            //right
            for(int i=startRow+1; i<=endRow;i++)
                System.out.print(arr[i][endCol]+" ");
            
            //bottom
            for(int i=endCol-1; i>=startCol;i--){
                if(startRow==endRow)
                    break;
                System.out.print(arr[endRow][i]+" ");
            }
            //left
            for(int i=endRow-1;i>=startRow+1;i--){
                if(startCol==endCol)
                    break;
                System.out.print(arr[i][startCol]+" ");
            }
                
            
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        
    }

    public static void diagonalSum(int arr[][]){
        int priSum=0, secSum=0;
        for(int i=0;i<arr.length;i++){
            priSum+=arr[i][i];
            //System.out.print(arr[i][arr.length-1-i]+" ");
            secSum+=arr[i][arr.length-1-i];
        }
        int finals=secSum+priSum;
        if(arr.length%2!=0){
            int a=arr.length/2;
            //System.out.println(arr[a][a]);
            finals=finals-arr[a][a];
        }
        System.out.println("Diagonal Sum : "+finals);
    }

    public static void SearchInSortedMatrix(int arr[][],int key){
        int i=0, j=arr.length-1;
        while(i<=arr.length-1 && j>=0){
            if(arr[i][j]==key){
                System.out.println("Key found at ("+i+","+j+")");
                return;
            }
            if(key>arr[i][j]){
                //System.out.println(arr[i][j]);
                i++;
            }
            else{
                //System.out.println(arr[i][j]);
                j--;
            }
        }
        System.out.println("Key NOT found :(");
    }

    public static void main(String args[]){
        // int arr[][]=new int[3][3];
        // int n=arr.length, m=arr[0].length;

        // Scanner sc = new Scanner(System.in);
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++)
        //         arr[i][j]=sc.nextInt();
        // }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++)
        //         System.out.print(arr[i][j]+" ");
        //         System.out.println();
        // }
        //int matrix[][]={{1, 2, 3, 4},{5, 6, 7, 8},{9,10,11,12},{13,14,15,16}};
        //int matrix[][]={{1, 2, 3, 4,5},{6, 7, 8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        //spiral(matrix);
        int sortedMatrix[][]={{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,39,50}};
        //diagonalSum(matrix);
        SearchInSortedMatrix(sortedMatrix, 32);
    }
}