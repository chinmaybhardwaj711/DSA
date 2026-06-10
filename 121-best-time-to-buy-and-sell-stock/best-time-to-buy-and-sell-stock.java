class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit  = 0;
        int bp = prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i] > bp){
                int profit = prices[i]-bp;
                maxProfit = Math.max(profit,maxProfit);
            }else{
                bp = prices[i];
            }

        }
        return maxProfit;
    }
}













// int Maxprofit =0;
//         int bp = prices[0];
//         for(int i=1;i<prices.length;i++){
//             if(prices[i] > bp){
//                 int profit = prices[i] -bp;
//                 Maxprofit = Math.max(Maxprofit,profit);
//             }else{
//                 bp = prices[i];
//             }
//         }

//         return Maxprofit;