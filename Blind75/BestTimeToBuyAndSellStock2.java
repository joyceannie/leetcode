class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[i];
        int peak = prices[i];
        int maxProfit = 0;
        
        while (i < prices.length - 1) {
            int valleyIndex = getValleyIndex(i, prices);
            valley = prices[valleyIndex];
            i = valleyIndex + 1;
            int peakIndex = getPeakIndex(i, prices);
            if (peakIndex >= prices.length) {
                return maxProfit;
            }
            peak = prices[peakIndex];
            maxProfit += peak - valley;
            i = peakIndex + 1;
        }
        
        return maxProfit;
    }
    
    public int getValleyIndex(int pos, int[] prices) {
        while (pos < prices.length - 1 && prices[pos] > prices[pos+1]) {
            pos += 1;
        } 
        return pos;
    }
    
    public int getPeakIndex(int pos, int[] prices) {
        while (pos < prices.length -1 && prices[pos] < prices[pos+1]) {
            pos += 1;
        }
        return pos;
    }
}
