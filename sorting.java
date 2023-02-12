public class sorting{

    public static void bubbleSort(int arr[]){
        int temp;
        for (int turn=0;turn<arr.length-1;turn++){
            //int item=arr[i];
            for(int j=0;j<arr.length-turn-1;j++){
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            //print(arr);
        }

    }

    public static void selectionSort(int arr[]){
        for(int iteration=0;iteration<arr.length-1;iteration++){
            int min=iteration;
            for(int j=iteration+1;j<arr.length;j++){
                if(arr[min]>arr[j])
                    min=j;
            }
            int temp=arr[iteration];
            arr[iteration]=arr[min];
            arr[min]=temp;
            print(arr);
        }
    }


    public static void insertionSort(int arr[]){
        for(int i=1;i<arr.length;i++){
            int cur=arr[i];
            int prev=i-1;
            
            while(prev>=0 && arr[prev]>cur){   // finding correct position to insert
                arr[prev+1]=arr[prev];
                prev--;
            }

            arr[prev+1]=cur;   //insertig value
            // for(int j=i-1; j>0; j--){
            //     if(arr[j]> arr[j+1])
            //         arr[j+1]=arr[j];
            //     else
            //         arr[j]=temp;
            // }
            //System.out.println(cur);
            //print(arr);
        }
    }

    public static void countingSort(int arr[]){
        int max=Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++)
            max=Math.max(max, arr[i]);  // find the maximum length of the counting array
        int countinigArr[]=new int[max+1];

        for(int i=0;i<arr.length;i++)
            countinigArr[arr[i]]++;     //incrementing the count of counting array
        int index=0;
        for(int i=0;i<countinigArr.length;i++){     //sorting the array
            while(countinigArr[i]>0){
                arr[index]=i;
                countinigArr[i]--;
                index++;
            }
        }
        //print(arr);
    }



    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }


    public static void merge(int arr[],int si, int mid, int ei){
        int temp[] = new int[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
                k++;
            }
            else{
                temp[k]=arr[j];
                j++;
                k++;
            }
        }
        //right part
        while(j<=ei){
            temp[k++]=arr[j++];
        }
        //left part
        while(i<=mid){
            temp[k++]=arr[i++];
        }

        // copy the temp to arr
        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }
        //print(temp);
    }
    public static void mergeSort(int arr[], int si, int ei){
        // base case 
        if(ei<=si){
            return;
        }

        int mid=si+(ei-si)/2;   // find the mid
        mergeSort(arr, si, mid);    //Left part
        mergeSort(arr, mid+1, ei);  // Right part

        // Merge the array
        merge(arr,si,mid,ei);
    }


    

    public static void quickSort(int arr[], int si, int ei){
        if(si>=ei)
            return;
        // make pivot as the last element of the array
        int pivot=arr[ei];
        
        // partition of the array
        int i=-1;
        for(int ind=0;ind<=ei;ind++){
            if(arr[ind]<=pivot){
                i++;
                //swap
                int temp=arr[ind];
                arr[ind]=arr[i];
                arr[i]=temp;
            }
        }
        // System.out.println("pivot="+pivot);
        // print(arr);
        // i will be the pivot index
        quickSort(arr, si, i-1);       //left half
        quickSort(arr, i+1, ei);        // right half
        //print(arr);
    }


    // **************** SORTED AND ROTATED ARRAY SEARCH ************************
    public static int rotatedSearch(int arr[], int si, int ei, int key){

        int mid=si+(ei-si)/2;
        while(mid>=0 && mid<=ei){
            //System.out.println("arr[mid]= "+arr[mid]);
            if(arr[mid]==key)       // Item Found 
                return mid;

            if(arr[si]<= arr[mid]){     //On the Line 1
                if(arr[si] <= key && key <=arr[mid]){       
                    // Left of Mid
                    ei=mid-1;
                }
                else{       
                    // right of mid
                    si = mid+1;
                }
            }
            else if(arr[mid]<=arr[ei]){     
                // on the Line 2
                if(arr[mid] <= key && key<= arr[ei]){   
                    // Right of mid
                    si= mid+1;
                }
                else{       
                    // Left of mid
                    ei = mid-1;
                }
            }
            
            mid=si+(ei-si)/2;
        }
        return -1;
    }



    public static void main(String args[]){
        int arr[] = {56,23,43,33,6,82,63,14,76};
        //int arr[]={2,4,3,4,5,6,2,7,5,3,8,7,8,9};
        //bubbleSort(arr);
        //selectionSort(arr);
        insertionSort(arr);
        //countingSort(arr);
        //print(arr);
        //mergeSort(arr, 0, arr.length-1);
        //quickSort(arr, 0, arr.length-1);

        // int arr[]= {4,5,6,7,0,1,2};
        // System.out.println("Index of the item : "+rotatedSearch(arr, 0, arr.length-1, 6));
        print(arr);
    }
}