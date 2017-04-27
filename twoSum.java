public class twoSum {
    public int[] twoSum(int[] nums, int target) {
               if(nums.length==2){
        return nums;
        }
        Map<Integer,Integer> hmap = new HashMap<Integer,Integer>(); 
        int temp=0;
        for (int i=0;i<nums.length;i++){
        	temp=target - nums[i];
        	if(hmap.containsKey(temp)){
        		return(new int[]{i,hmap.get(temp)});
        	}
        	hmap.put(nums[i], i);
        }
        return new int[]{0,0};
    }
}
