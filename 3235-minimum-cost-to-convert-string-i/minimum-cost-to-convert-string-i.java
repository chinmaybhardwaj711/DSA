class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {

        int dist[][] = new int[26][26];
        for(int row[]:dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        

        for(int i=0;i<original.length;i++){
            int u = original[i]-'a';
            int v = changed[i]-'a';
            int wt = cost[i];
            
            dist[u][v] = Math.min(dist[u][v],wt);

        }

        for(int i=0;i<26;i++){
            dist[i][i] =0;
        }

        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE){
                        continue;
                    }
                    dist[i][j] = Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
        int n = source.length();

        long totalCost =0;
       for(int i=0;i<n;i++){
            char s = source.charAt(i);
            char t = target.charAt(i);

            int u = s-'a';
            int v = t-'a';
            if(u==v){
                continue;
            }
            if(dist[u][v] == Integer.MAX_VALUE){
                return -1;
            }
            totalCost+= dist[u][v];
       }

        return totalCost;


        


    }
}