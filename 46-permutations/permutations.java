class Solution {
    // public void f(List<Integer>ds,boolean freq[],int n,int[]nums,List<List<Integer>> ans){
    //     if(ds.size() ==n){
    //         ans.add(new ArrayList<>(ds));
    //         return;
    //     }

        
    //     for(int i=0;i<n;i++){
    //         if(!freq[i]){
    //             freq[i] = true;
    //             ds.add(nums[i]);
    //             f(ds,freq,n,nums,ans);
    //             freq[i] = false;
    //             ds.remove(ds.size()-1);

    //         }
    //     }
    

    // }
    public void permute(int ind,int nums[],int n,List<List<Integer>>ans){
        if(ind == nums.length){
            ArrayList<Integer> ds = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
        }

        for(int i=ind;i<n;i++){
            swap(nums,ind,i);
            permute(ind+1,nums,n,ans);
            swap(nums,i,ind);
        }


    }

    public void swap(int nums[], int ind,int i){
        int t = nums[i];
        nums[i] = nums[ind];
        nums[ind] = t;
    }
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        permute(0,nums,n,ans);
        return ans;






        // int n = nums.length;
        // List<List<Integer>> ans = new ArrayList<>();
        // boolean freq[] = new boolean[n];
        // List<Integer> ds = new ArrayList<>();
        // f(ds,freq,n,nums,ans);
        // return ans;
    }
}