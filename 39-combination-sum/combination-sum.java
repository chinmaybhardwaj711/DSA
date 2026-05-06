class Solution {
    

    Set<List<Integer>> set = new HashSet<>();

    void combSum(int []candidates,int idx,List<Integer> comb,List<List<Integer>> ans,int target ){
        if(idx == candidates.length ||target<0 ){
            return ;
        }
        if(target == 0){
            if(!set.contains(comb)){
                set.add(new ArrayList<>(comb));
                ans.add(new ArrayList<>(comb));
                
            }
            return ;
        }
        comb.add(candidates[idx]);
        combSum(candidates,idx+1,comb,ans, target-candidates[idx]);
        combSum(candidates,idx,comb,ans,target-candidates[idx]);
        comb.remove(comb.size()-1);

        combSum(candidates,idx+1,comb,ans,target);
    }

    public List<List<Integer>> combinationSum(int[] candidates,int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();

        combSum(candidates,0,comb,ans,target);

        return ans;
    }
}