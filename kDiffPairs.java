public class kDiffPairs {
    public int findPairs(int[] nums, int k) {
        if (nums==null || nums.length==0 || k<0){
            return 0;
        }
        int count=0;
        Map<Integer,Integer> hmap = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (hmap.containsKey(nums[i])){
                hmap.put(nums[i],hmap.get(nums[i])+1);
                System.out.println(nums[i]);
            }
            else{
                hmap.put(nums[i],1);
            }
        }
        for (Map.Entry<Integer,Integer> mEntry:hmap.entrySet()){
            if (k==0){
                if (mEntry.getValue()>=2){
                    count++;
                }
            }
            else{
                if (hmap.containsKey(mEntry.getKey()+k)){
                    
                    count++;
                }
            }
        }
        return count;
    }
}
