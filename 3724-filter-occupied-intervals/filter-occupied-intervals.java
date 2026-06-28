class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {
      //1
      Arrays.sort(occupiedIntervals,(a,b)->Integer.compare(a[0],b[0]));

      //2
      List<int[]> merged = new ArrayList<>();
      for(int[]interval:occupiedIntervals){
        if(merged.size()==0 ||merged.get(merged.size()-1)[1]+1<interval[0]){
            merged.add(new int[]{interval[0],interval[1]});
        }else{
            merged.get(merged.size()-1)[1] = Math.max( merged.get(merged.size()-1)[1],interval[1]);
        }
      }


      List<List<Integer>> ans = new ArrayList<>();
      for(int arr[]:merged){
        int s =arr[0];
        int e = arr[1];

        if(e<freeStart || s>freeEnd){
            ans.add(Arrays.asList(arr[0],arr[1]));
        }else{
            if(s<freeStart){
                ans.add(Arrays.asList(s,freeStart-1));
            }
            if(e>freeEnd){
                ans.add(Arrays.asList(freeEnd+1,e));
            }
        }
      }
      return ans;
    }
}