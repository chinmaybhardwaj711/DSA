class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    
        ArrayList<Integer> ans = new ArrayList<>();

        ans =topSortUtil(prerequisites,numCourses);

        if(ans.size() != numCourses){
            return new int[0];
        }
      
        int result[] = new int[numCourses];
        for(int i=0;i<result.length;i++){
            result[i] = ans.get(i);
        }

        return  result;

        // for(int i=0;i<prerequisites.length;i++){
        //     if(!visited[i]){
        //         topSortUtil(prerequisites,i,visited,s);
        //     }
        // }
        // ArrayList<Integer> ans = new LinkedList<>();
        // while(!s.isEmpty()){
        //     ans.add(s.pop());
            
        // }
        // return ans.toArray();
    }
    public static void createIndeg(int[][]prerequisites, int[]indeg){
        for(int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            indeg[v]++;
        }
    }

    public static ArrayList<Integer> topSortUtil(int[][]prerequisites,int numCourses){
        int[] indeg = new int[numCourses];
        createIndeg(prerequisites,indeg);
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0;i<indeg.length;i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.remove();
            ans.add(curr);

            for(int j=0;j<prerequisites.length;j++){
                int u = prerequisites[j][1];
                int v = prerequisites[j][0];

                if(curr == u){
                    indeg[v]--;

                    if(indeg[v] == 0){
                        q.add(v);
                    }
                }
            }

        }

        return ans;

        

            
    }
}