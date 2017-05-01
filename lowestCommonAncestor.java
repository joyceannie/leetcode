public class lowestCommonAncestor {
    public TreeNode lowestAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val<p.val && root.val<q.val){
            return lowestAncestor(root.right,p,q);
        }
        else if(p.val<root.val && q.val<root.val){
            return lowestAncestor(root.left,p,q);
        }
        else{
            return root;
        }
    }
}
