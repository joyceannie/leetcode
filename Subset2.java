public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       List<List<Integer>> subset = new ArrayList<List<Integer>>();
        if (nums==null || nums.length==0){
            return subset;
        }
        Arrays.sort(nums);
        List<Integer> partialSubset = new ArrayList<Integer>();
        findSubsets(nums,0,subset,partialSubset);
        return subset;
    }
    
    private void findSubsets(int[] num, int pos, List<List<Integer>> subset, List<Integer> partialSubset ){
        if (pos == num.length && !subset.contains(partialSubset)){
            subset.add(new ArrayList<Integer>(partialSubset));
        }
        else if (pos!=num.length){
            partialSubset.add(num[pos]);
            findSubsets(num,pos+1,subset,partialSubset);
            partialSubset.remove(partialSubset.size()-1);
            findSubsets(num,pos+1,subset,partialSubset);
        }
    }
}
