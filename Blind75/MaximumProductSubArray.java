class Solution {
    public int maxProduct(int[] nums) {
        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int temp_max_so_far = Math.max(nums[i], Math.max(max_so_far * nums[i], min_so_far * nums[i]));
            min_so_far = Math.min(nums[i], Math.min(max_so_far * nums[i], min_so_far * nums[i]));
            max_so_far = temp_max_so_far;
            result = Math.max(result, max_so_far);
                                  
        }
        
        return result;
    }
}
