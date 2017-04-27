public int[] productExceptSelf(int[] nums) {
	int[] forwardScan=new int[nums.length];
	int[] reverseScan = new int[nums.length];
	int[] output = new int[nums.length];  
	forwardScan[0]=1;
        reverseScan[nums.length-1]=1;
	for (int i=1;i<nums.length;i++){
	        	forwardScan[i]=forwardScan[i-1]*nums[i-1];
        }
	for(int i=nums.length-1;i>0;i--){
        	reverseScan[i-1]=reverseScan[i]*nums[i];
	}
        for(int i=0;i<nums.length;i++){
		output[i]=reverseScan[i]*forwardScan[i];
	}
	return output;
}	  
