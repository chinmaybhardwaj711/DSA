class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1 =0;
        int cnt2 = 0;
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            if(cnt1 ==0 && nums[i] != el2 ){
                el1 = nums[i];
                cnt1 =1;
            }else if(cnt2 == 0 && nums[i] !=el1){
                el2 =nums[i];
                cnt2 =1;
            }else if(nums[i] == el1){
                cnt1++;
            }else if(nums[i] == el2){
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }

           
        }
         cnt1 = 0;
         cnt2 =0;
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i] == el1)cnt1++;
            if(nums[i] == el2)cnt2++;
        }
        int min = (int)nums.length/3+1;
        if(cnt1>=min){
            result.add(el1);
        }
         if(cnt2>=min && el1!=el2){
            result.add(el2);
        }

        return result;
        



















    //     int n = nums.length;
    //     ArrayList<Integer> ans = new ArrayList<>();
    //  HashMap<Integer,Integer> map = new HashMap<>();
    //  for(int num:nums){
    //     map.put(num,map.getOrDefault(num,0)+1);
    //  }   

    //  for(int key:map.keySet()){
    //     if(map.get(key) > n/3){
    //         ans.add(key);
    //     }
    //  }

    //  return ans;
    }
    
}