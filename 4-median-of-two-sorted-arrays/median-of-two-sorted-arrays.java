class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // List<Integer> list = new ArrayList<>();
        // for(int num:nums1){
        //     list.add(num);
        // }
        // for(int num:nums2){
        //     list.add(num);
        // }
        // Collections.sort(list);
        // double median;
        // int n =list.size();
        // if(list.size() %2 == 0){
        //   median = (list.get(n/2-1) + list.get(n/2))/2.0;
            
        // }else{
        //      median = list.get(n/2);
        // }

        // return median;
        // int n1 = nums1.length;
        // int n2 = nums2.length;
        // if(n1 >n2){
        //     return findMedianSortedArrays(nums2,nums1);
        // }
        // int low = 0;
        // int high =n1;
        // while(low<=high){
        //     int i1 = (low+high)/2;
        //     int i2 = (n1+n2+1)/2-i1;

        //     int max1 = (i1==0)?Integer.MIN_VALUE:nums1[i1-1];
        //     int min1 = (i1==n1)?Integer.MAX_VALUE:nums1[i1];

        //     int max2 = (i2==0)?Integer.MIN_VALUE:nums2[i2-1];
        //     int min2 = (i2==n2)?Integer.MAX_VALUE:nums2[i2];

        //     if(max1<=min2 && max2<=min1){
        //         if((n1+n2)%2 ==0){
        //             return (Math.max(max1,max2) + Math.min(min1,min2))/2.0;
        //         }else{
        //             return (Math.max(max1,max2));
        //         }
                
        //     }else if(max1>min2){
        //         high = i1-1;
        //     }else{
        //         low = i1+1;
        //     }

        // }
        // return  0.0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1>n2)return findMedianSortedArrays( nums2, nums1);
        int low = 0;int high = n1;int left = (n1+n2+1)/2;
        while(low<=high){
            int mid1 =(high+low)/2;
            int mid2 = left-mid1;
            int l1 = Integer.MIN_VALUE;int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE; int r2 = Integer.MAX_VALUE;
            if(mid1<n1) r1=nums1[mid1];
            if(mid2<n2) r2=nums2[mid2];
            if(mid1-1>=0) l1 = nums1[mid1-1];
            if(mid2-1>=0) l2 = nums2[mid2-1];
            if(l1<=r2 && l2<=r1){
                if((n1+n2)%2 !=0)return (double)Math.max(l1,l2);
                return (double)(Math.max(l1,l2) + Math.min(r1,r2))/2.0;

            }else if(l1>r2){
                high = mid1-1;
            }else{
                low = mid1+1;
            }
        }
        return 0.0;
    }
}