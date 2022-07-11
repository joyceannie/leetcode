class Solution {
    public int missingNumber(int[] nums) {
        int missingValue = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missingValue ^= i ^ nums[i];
            }
        return missingValue;
    }
}
