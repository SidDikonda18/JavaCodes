
public class StockBuySell{
    public static int stocks(int stock[]){
        int buyPrice=stock[0],sellPrice=0;

        for(int i=1;i<stock.length;i++){
            buyPrice=Math.min(stock[i],buyPrice); //getting the minimum buy price 
            if(buyPrice==stock[i])  //stock is buyied today then you cant sell it today and have to sell today onwards
                sellPrice=0;
            sellPrice=stock[i]>buyPrice && stock[i]>sellPrice ? stock[i] : sellPrice;   // storing the selling prince it should be greater than buy price and update if greater thatn previous sell price

        }
        System.out.println("Buy Price : "+buyPrice+" Selling Price : "+sellPrice);
        return sellPrice-buyPrice;
    }
    public static void main(String args[]){
        int stock[]= {7, 1, 5, 3, 6, 4};
        //int stock[]={45, 34, 67, 34, 93, 57, 27, 68, 69};
        int profit= stocks(stock);
        System.out.println("Profit : "+profit);
    }
}