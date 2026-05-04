class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for(int num:nums1){
            list.add(num);
        }
        for(int num:nums2){
            list.add(num);
        }
        Collections.sort(list);
        double median;
        int n =list.size();
        if(list.size() %2 == 0){
          median = (list.get(n/2-1) + list.get(n/2))/2.0;
            
        }else{
             median = list.get(n/2);
        }

        return median;
    }
}