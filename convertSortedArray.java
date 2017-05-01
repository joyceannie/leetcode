public class convertSortedArray{
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode head=createTree(nums,0,nums.length-1);
        return head;
    }
    
    public TreeNode createTree(int[] nums,int low,int high){
        if (high-low+1==0){
            return null;
        }
        int mid=(high+low)/2;
        TreeNode node=new TreeNode(nums[mid]);
        node.left=createTree(nums,low,mid-1);
        node.right=createTree(nums,mid+1,high);
        return node;
    }
}
