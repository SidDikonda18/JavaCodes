import java.util.Scanner;

public class BinaryToDecimal {

    public static int binaryToDecimal(int bin){
        int dec=0;
        //int temp=bin;
        int indx =0;
        while (bin>0){
            int last=bin%10;
            dec= dec+ (last*(int)Math.pow(2, indx));
            indx++;
            bin=bin/10;
        }
        return dec;

    }


    // public static void DecimalToBinary(int dec){

    //     int[] bin=new int[50];
    //     int ind=0;
    //     int ii=0;
    //     while(dec>0){
    //         //bin= bin*10 + ((dec%2)*(int)Math.pow(2, ind));
    //         bin[ii]= dec%2;
    //         dec=dec/2;
    //         System.out.print(bin[ii]);
    //         ii++;
            

    //     }
    //     System.out.println("\n");
    //     int[] rev=new int[50];
    //     int j=0;
    //     for (int i=bin.length-1;i>-1;i--){
    //         rev[j]=bin[i];
    //         j++;
    //     }
    //     //return rev;

    //     for(int i=0;i<rev.length;i++){
    //         System.out.print(rev[j]);
    //     }
    // }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter the binary number: ");
        int bin=sc.nextInt();

        System.out.println("Decial Number is : "+binaryToDecimal(bin));

        // System.out.print("Enter the Decimal number: ");
        // int dec=sc.nextInt();

        // // System.out.print("Binary Number is : "+DecimalToBinary(dec));

        // DecimalToBinary(dec);
    }
}