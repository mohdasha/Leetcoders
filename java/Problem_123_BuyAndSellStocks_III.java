public class Problem_123_BuyAndSellStocks_III {
    /**
     * Time complexity: O(n)
     * Space Complexity: O(n)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int max = 0;

        int[] profit= new int[prices.length];

        int min_far = Integer.MAX_VALUE;

        for(int i=0; i<prices.length; i++) {
            min_far = Math.min(min_far, prices[i]);
            max = Math.max(max, prices[i]-min_far);
            profit[i] = max;
        }

        int max_far = Integer.MIN_VALUE;

        for(int i=prices.length-1; i>0; i--) {
            max_far = Math.max(max_far, prices[i]);
            max = Math.max(max, max_far - prices[i] + profit[i-1]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Problem_123_BuyAndSellStocks_III().maxProfit(new int[]{3,3,5,0,0,3,1,4}));
        System.out.println(new Problem_123_BuyAndSellStocks_III().maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(new Problem_123_BuyAndSellStocks_III().maxProfit(new int[]{7,6,4,3,1}));
    }
}
