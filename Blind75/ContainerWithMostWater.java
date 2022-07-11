class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxValue = 0;
        while (left < right) {
            maxValue = Math.max(maxValue, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left += 1;
            } else {
                right -= 1;
            }
            
        }
        
        return maxValue;
    }
}
