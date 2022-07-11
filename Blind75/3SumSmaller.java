class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j ++) {
                int start = j + 1;
                int end = nums.length - 1;
                int value = target - nums[i] - nums[j];
                while (start <=  end) {
                    int mid = (start + end)/2;
                    if (nums[mid] >= value) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
                count += end  - j;
            }
        }
        return count;
    }
}
