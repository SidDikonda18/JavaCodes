import java.util.*;

public class ArrayLists{
    public static int MostWater(ArrayList<Integer> height){
        int waterArea=0;
        int lp=0, rp=height.size()-1;

        while(lp<rp){
            int ht=Math.min(height.get(rp),height.get(lp));
            int width=rp-lp;
            waterArea=Math.max(waterArea,ht*width);

            if(height.get(lp)<height.get(rp))
                lp++;
            else
                rp--;
            
        }
        return waterArea;
    }


    public static boolean PairSum(ArrayList<Integer> list, int target){
        int lp=0, rp=list.size()-1;
        while(lp<rp){
            if(list.get(lp)+list.get(rp)==target)
                return true;
            else if(list.get(lp)+list.get(rp)<target)
                lp++;
            else 
                rp--;
        }
        return false;
    }

    public static boolean PairSum1(ArrayList<Integer> list, int target){    // for Circular sorted arrayList
        int lp=0, rp=list.size()-1;
        int n=list.size();
        while(lp<rp){
            if(list.get(lp)+list.get(rp)==target)
                return true;
            else if(list.get(lp)+list.get(rp)<target)
                lp=(lp+1)%n;
            else 
                rp=(n+rp-1)%n;
        }
        return false;
    }

    public static void main(String args[]){

        // ArrayList<Integer> li= new ArrayList<>();

        // li.add(23);
        // li.add(89);
        // li.add(74);
        // li.add(1,54);
        // li.add(50);

        // System.out.println(li);
        // for(int i=li.size()-1;i>=0;i--){
        //     System.out.print(li.get(i)+" ");
        // }
        // System.out.println(li);
        // System.out.println(li.get(3));
        // li.remove(2);
        // System.out.println(li);
        // li.set(1,99);
        // System.out.println(li);
        // System.out.println(li.contains(26));
        // System.out.println(li.size());




        //*****************2D ARRAYLIST******************* */

        // ArrayList<ArrayList<Integer>> mainlist= new ArrayList<>();
        // ArrayList<Integer> list = new ArrayList();
        // list.add(1); list.add(2); list.add(3);
        // mainlist.add(list);

        // ArrayList<Integer> list2=new ArrayList();
        // list2.add(2);   list2.add(4);   list2.add(6); list2.add(8);
        // mainlist.add(list2);

        // for(int i=0;i<mainlist.size();i++){
        //     ArrayList<Integer> templist = mainlist.get(i);
        //     for(int j=0;j<templist.size();j++)
        //         System.out.print(templist.get(j)+ " ");
        //     System.out.println();
        // }
        // System.out.println(mainlist);
        
        //************************************************************** */

        // ArrayList<Integer> height = new ArrayList();
        // height.add(1);
        // height.add(8);
        // height.add(6);
        // height.add(2);
        // height.add(5);
        // height.add(4);
        // height.add(8);
        // height.add(3);
        // height.add(7);

        //System.out.println(MostWater(height));
        ArrayList<Integer> arr = new ArrayList();
        arr.add(5);
        arr.add(6);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        System.out.println(PairSum1(arr, 7));
    }
}