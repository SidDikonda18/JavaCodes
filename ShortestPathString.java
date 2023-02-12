import javax.lang.model.util.ElementScanner14;

public class ShortestPathString{

    public static double shortestPath(String str){
        int x=0, y=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='N')  //north
                y++;
            else if(str.charAt(i)=='S') //south
                y--;
            else if(str.charAt(i)=='E') //east
                x++;
            else    //west
                x--;
        }
        return Math.sqrt((double)x*x+y*y);
    }
    public static void main(String args[]){

        String str="WNEENESENNN";
        System.out.println(shortestPath(str));
    }
}