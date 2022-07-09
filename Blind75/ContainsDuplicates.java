class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numbersSeen = new HashSet<>();
        for (int num: nums) {
            if (numbersSeen.contains(num)) {
                return true;
            }
            numbersSeen.add(num);
        }
        return false;
    }
}
