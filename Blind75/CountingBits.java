class Solution {
    public int[] countBits(int n) {
        int[] counts = new int[n + 1];
        for (int i = 1; i < n+1; i++) {
            counts[i] = counts[i & (i - 1)] + 1;
        }
        
        return counts;
    }
}
