class Solution {
    public void f(int ind,int target,List<Integer> ds, int[]candidates,List<List<Integer>> ans){
       if(target == 0){
        ans.add(new ArrayList<>(ds));
        return;
       }
       for(int i =ind;i<candidates.length;i++){
        if(i!=ind && candidates[i] == candidates[i-1]){
            continue;
        }
        if(candidates[i] >target){
            break;
        }
        ds.add(candidates[i]);
        f(i+1,target-candidates[i],ds,candidates,ans);
        ds.remove(ds.size()-1);
       }
       

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        f(0,target,new ArrayList<>(),candidates,ans);
        return ans;
    }
}