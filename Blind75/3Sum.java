class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        
        for (int i= 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int start = i+1;
            int end = nums.length - 1;
            while (start < end) {
                int currentSum = nums[i] + nums[start] + nums[end];
                if (currentSum == 0) {
                   
                    triplets.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    while (start < nums.length-1  && nums[start] == nums[start+1]) {
                      start += 1;  
                    }
                    start += 1;
                    end -= 1;
                } else if (currentSum < 0) {
                    start += 1;
                } else {
                    end -= 1;
                }
            }
        }
        return triplets;
    }
}
