class Solution {
    public void f(int ind,int target,int[]candidates,List<Integer>ds,List<List<Integer>>ans){
        if(ind ==candidates.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(candidates[ind] <=target){
            ds.add(candidates[ind]);
            f(ind,target-candidates[ind],candidates,ds,ans);
            ds.remove(ds.size()-1);
        
        }
            f(ind+1,target,candidates,ds,ans);



    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        f(0,target,candidates,new ArrayList<>(),ans);
        return ans;
    }
}