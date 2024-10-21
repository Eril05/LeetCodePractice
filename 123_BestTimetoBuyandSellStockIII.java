/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 105
*/

class Solution {
    public int maxProfit(int[] prices) {
    
    int pricelen=prices.length;
      int minValue=prices[0];
      int maxValue=prices[pricelen-1];

    int []minList=new int[pricelen];
    int []maxList=new int[pricelen];
    int profit=0;

    for(int i=1;i<pricelen;i++){

        minList[i]=Math.max(minList[i-1],prices[i]-minValue);
        minValue=Math.min(prices[i],minValue);
    }

    for(int j=pricelen-2;j>=0;j--){

        
        maxList[j]=Math.max(maxList[j+1],maxValue-prices[j]);
        maxValue=Math.max(maxValue,prices[j]);
    }
        profit=Math.max(maxList[0],minList[pricelen-1]);

    for(int i=1;i<pricelen;i++){

        profit=Math.max(profit,minList[i-1]+maxList[i]);

    }

    return profit;
        
    }
}

//Solution 2

// Buy and Sell Stock Pattern
// Approach - 2 Tabulation


class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int [][][]dp = new int [n+1][2][3];
        int profit =0;
        
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int transaction =1;transaction<=2;transaction++){
                    if(buy ==0){
                        profit = Math.max(0+dp[i+1][0][transaction], -prices[i]+ dp[i+1][1][transaction]);
                    }
                    if(buy ==1){
                        profit = Math.max(0+dp[i+1][1][transaction],prices[i]+dp[i+1][0][transaction-1]);
                    }
                    dp[i][buy][transaction] = profit;
                }
            }
        }
        return dp[0][0][2];
        
    }
}
