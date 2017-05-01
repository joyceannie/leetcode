public class sameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null){
            return true;
        }
        else if(p==null || q==null){
            return false;
        }
        else if(p.val==q.val){
                
            return isSameTree(p.right,q.right) && isSameTree(p.left,q.left);
             
        }
        else{
        return false;
        }
    }
}
