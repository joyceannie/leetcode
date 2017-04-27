import java.util.*;
public class productOfArrayExceptSelf {

	/**
	 * @param args
	 */
	
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
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan =new Scanner(System.in);
		System.out.println("Enter size");
		int count=scan.nextInt();
		int[] input=new int[count];
		for(int i=0;i<count;i++){
			input[i]=scan.nextInt();
		}
		
		productOfArrayExceptSelf obj = new productOfArrayExceptSelf();
		int[] output=obj.productExceptSelf(input);
		for (int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}
	}
	

}
