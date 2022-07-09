class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        int[] productFromRight = new int[nums.length];
        productFromRight[nums.length - 1] = 1;
        int[] productFromLeft = new int[nums.length];
        productFromLeft[0] = 1;
        
        for (int i = 1; i < nums.length; i++) {
            productFromLeft[i] = productFromLeft[i-1] * nums[i-1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            productFromRight[i] = productFromRight[i+1] * nums[i+1];
        }
        
        for (int i = 0; i < nums.length; i++) {
            product[i] = productFromLeft[i] * productFromRight[i];
        }
        
        return product;
    }
}
