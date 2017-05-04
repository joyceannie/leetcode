public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null){
            return result;
        }
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> partialList = new ArrayList<Integer>();
            for (int i=0;i<size;i++){
                TreeNode data = queue.poll();
                partialList.add(data.val);
                if (data.left!=null){
                    queue.offer(data.left);
                }
                if (data.right!=null){
                    queue.offer(data.right);
                }
            }
            list.add(new ArrayList<>(partialList));
        }
        for (int i=list.size()-1;i>=0;i--){
            result.add(list.get(i));
        }
        return result;
    }
}
