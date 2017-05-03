public class binaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> solution = new ArrayList<List<Integer>>();
        if (root == null){
            return solution;
        }
        Queue <TreeNode> queue = new LinkedList<>();
        queue.offer(root); 
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> partial = new ArrayList<>();
            for (int i=0;i<size;i++){
                TreeNode data = queue.poll();
                if (data.left!=null){
                    queue.offer(data.left);
                }
                if (data.right!=null){
                    queue.offer(data.right);
                }
                partial.add(data.val);
            }
           solution.add(new ArrayList<>(partial)); 
        }
        return solution;
    }

}
